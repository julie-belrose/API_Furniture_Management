package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.FurnitureDto;
import org.example.dto.FurnitureRequest;
import org.example.service.FurnitureService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

/**
 * REST controller for managing furniture items.
 */
@RestController
@RequestMapping("/api/furniture")
@RequiredArgsConstructor
public abstract class FurnitureController implements GenericCrudController<FurnitureDto, UUID> {

    private final FurnitureService furnitureService;

    @Override
    @PostMapping
    public ResponseEntity<FurnitureDto> save(@RequestBody FurnitureDto dto) {
        FurnitureDto saved = furnitureService.save(dto);
        return ResponseEntity.ok(saved);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<FurnitureDto> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(furnitureService.findById(id)
                .orElseThrow(() -> new RuntimeException("Furniture not found")));
    }

    @Override
    @PutMapping
    public ResponseEntity<FurnitureDto> update(@RequestBody FurnitureDto dto) {
        return ResponseEntity.ok(furnitureService.update(dto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Furniture not found")));
    }

    @Override
    @GetMapping
    public ResponseEntity<List<FurnitureDto>> getAll() {
        return ResponseEntity.ok(furnitureService.findAll());
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        boolean deleted = furnitureService.delete(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    // Endpoint specific for creation from a FurnitureRequest
    @PostMapping("/create")
    public ResponseEntity<FurnitureDto> create(@RequestBody FurnitureRequest request) {
        return ResponseEntity.ok(furnitureService.create(request));
    }
}
