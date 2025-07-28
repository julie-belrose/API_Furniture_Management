package org.example.controller;

import org.example.dto.cart.AddCartItemRequest;
import org.example.dto.cart.CartDto;
import org.example.service.CartService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Controller for managing shopping carts.
 */
@RestController
@RequestMapping("/api/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    /**
     * Create a new cart.
     */
    @PostMapping
    public ResponseEntity<CartDto> createCart() {
        return ResponseEntity.ok(cartService.createCart());
    }

    /**
     * Get all items in a cart.
     */
    @GetMapping("/{cartId}")
    public ResponseEntity<CartDto> getCart(@PathVariable UUID cartId) {
        return ResponseEntity.ok(cartService.getCart(cartId));
    }

    /**
     * Add a furniture item to a cart.
     */
    @PostMapping("/{cartId}/add")
    public ResponseEntity<CartDto> addCartItem(
            @PathVariable UUID cartId,
            @Valid @RequestBody AddCartItemRequest request
    ) {
        return ResponseEntity.ok(cartService.addCartItem(cartId, request));
    }

    /**
     * Remove an item from the cart.
     */
    @DeleteMapping("/{cartId}/remove/{cartItemId}")
    public ResponseEntity<CartDto> removeCartItem(
            @PathVariable UUID cartId,
            @PathVariable UUID cartItemId
    ) {
        return ResponseEntity.ok(cartService.removeCartItem(cartId, cartItemId));
    }

    /**
     * Clear all items from the cart.
     */
    @DeleteMapping("/{cartId}/clear")
    public ResponseEntity<CartDto> clearCart(@PathVariable UUID cartId) {
        return ResponseEntity.ok(cartService.clearCart(cartId));
    }
}