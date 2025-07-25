package org.example.exception;

import org.springframework.http.HttpStatus;

import java.util.UUID;

/**
 * Exception thrown when a cart item is not found.
 */
public class CartItemNotFoundException extends BaseException {
    
    public CartItemNotFoundException(UUID cartItemId) {
        super(HttpStatus.NOT_FOUND, String.format("Cart item with ID %s not found", cartItemId));
    }
}
