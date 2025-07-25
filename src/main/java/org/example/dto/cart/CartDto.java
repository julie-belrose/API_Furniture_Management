package org.example.dto.cart;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * DTO for {@link org.example.domain.cart.Cart} entity.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CartDto {
    private UUID id;
    private List<CartItemDto> items;
    private double total;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
