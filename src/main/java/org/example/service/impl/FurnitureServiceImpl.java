package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.domain.furniture.Furniture;
import org.example.dto.FurnitureDto;
import org.example.dto.FurnitureRequest;
import org.example.mapper.FurnitureMapper;
import org.example.repository.FurnitureRepository;
import org.example.service.FurnitureService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Service implementation for furniture logic.
 */
@Service
@RequiredArgsConstructor
public class FurnitureServiceImpl extends GenericCrudImpl<Furniture, UUID> implements FurnitureService {

    private final FurnitureRepository furnitureRepository;
    private final FurnitureMapper furnitureMapper;

    @Override
    public FurnitureDto create(FurnitureRequest request) {
        Furniture entity = furnitureMapper.fromRequest(request);
        Furniture saved = furnitureRepository.save(entity);
        return furnitureMapper.toDto(saved);
    }

    @Override
    public FurnitureDto save(FurnitureDto dto) {
        Furniture entity = furnitureMapper.toEntity(dto);
        Furniture saved = furnitureRepository.save(entity);
        return furnitureMapper.toDto(saved);
    }

    @Override
    public FurnitureDto update(FurnitureDto dto) {
        Furniture entity = furnitureMapper.toEntity(dto);
        Furniture updated = furnitureRepository.save(entity);
        return furnitureMapper.toDto(updated);
    }

    @Override
    public FurnitureDto findById(UUID id) {
        return furnitureRepository.findById(id)
                .map(furnitureMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Furniture not found"));
    }

    @Override
    public List<FurnitureDto> findAll() {
        return furnitureRepository.findAll().stream()
                .map(furnitureMapper::toDto)
                .toList();
    }

    @Override
    public boolean delete(UUID id) {
        if (furnitureRepository.existsById(id)) {
            furnitureRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
