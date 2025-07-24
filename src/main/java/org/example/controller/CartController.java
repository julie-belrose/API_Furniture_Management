package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.CartItemDto;
import org.example.service.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/cart")
@RequiredArgsConstructor
public abstract class CartController implements GenericCrudController<CartItemDto, UUID> {

    private final CartService cartService;

    @Override
    @PostMapping
    public ResponseEntity<CartItemDto> save(@RequestBody CartItemDto dto) {
        CartItemDto saved = cartService.addCartItem(dto);
        return ResponseEntity.ok(saved);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<CartItemDto> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(cartService.getCartItemById(id));
    }

    @Override
    @GetMapping
    public ResponseEntity<List<CartItemDto>> getAll() {
        return ResponseEntity.ok(cartService.getAllCartItems());
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        boolean deleted = cartService.removeCartItem(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}