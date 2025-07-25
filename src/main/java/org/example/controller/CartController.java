package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.AddCartItemRequest;
import org.example.dto.CartItemDto;
import org.example.service.CartItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/cart")
@RequiredArgsConstructor
public abstract class CartController implements GenericCrudController<CartItemDto, UUID> {

    private final CartItemService cartService;

    @PostMapping
    public ResponseEntity<CartItemDto> save(@RequestBody AddCartItemRequest request) {
        return ResponseEntity.ok(cartService.addCartItem(request));
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

    @PutMapping("/{id}")
    public ResponseEntity<CartItemDto> update(@PathVariable UUID id, @RequestBody AddCartItemRequest request) {
        CartItemDto updated = cartService.updateCartItem(id, request);
        return ResponseEntity.ok(updated);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        boolean deleted = cartService.removeCartItem(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}