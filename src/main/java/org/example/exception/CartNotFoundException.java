package org.example.exception;

import org.springframework.http.HttpStatus;

import java.util.UUID;

/**
 * Exception thrown when a cart is not found.
 */
public class CartNotFoundException extends BaseException {
    public CartNotFoundException(UUID cartId) {
        super(HttpStatus.NOT_FOUND, String.format("Cart with ID %s not found", cartId));
    }
}
