package org.example.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Request object for creating or updating a furniture item via the API.
 * Includes validation annotations to ensure proper input from clients.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FurnitureRequest implements Serializable {

    @NotBlank(message = "Name is required")
    private String name;

    @Size(max = 255, message = "Description must be 255 characters max")
    private String description;

    @Positive(message = "Price must be a positive number")
    private double price;

    @Min(value = 0, message = "Stock cannot be negative")
    private int stock;
}
