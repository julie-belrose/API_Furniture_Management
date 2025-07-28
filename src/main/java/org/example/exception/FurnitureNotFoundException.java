package org.example.exception;

import org.springframework.http.HttpStatus;

import java.util.UUID;

/**
 * Exception thrown when a furniture is not found.
 */
public class FurnitureNotFoundException extends BaseException {
    
    public FurnitureNotFoundException(UUID furnitureId) {
        super(HttpStatus.NOT_FOUND, String.format("Furniture with ID %s not found", furnitureId));
    }
}
