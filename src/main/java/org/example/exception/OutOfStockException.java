package org.example.exception;

import org.springframework.http.HttpStatus;

import java.util.UUID;

/**
 * Exception thrown when trying to add more items to cart than are available in stock.
 */
public class OutOfStockException extends BaseException {
    
    public OutOfStockException(UUID furnitureId, int requested, int available) {
        super(
            HttpStatus.BAD_REQUEST, 
            String.format("Not enough stock for furniture %s. Requested: %d, Available: %d", 
                furnitureId, requested, available)
        );
    }
}
