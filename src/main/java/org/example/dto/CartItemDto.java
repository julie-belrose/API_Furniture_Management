package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * DTO used to expose cart item data via the API.
 * Includes basic info about the furniture linked to the cart item.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CartItemDto {

    private UUID id;             // Cart item ID
    private UUID furnitureId;    // ID of the linked furniture
    private String name;         // Furniture name
    private String description;  // Furniture description
    private double price;        // Furniture price
    private int quantity;        // Quantity added to the cart
}
