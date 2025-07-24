package org.example.mapper;

import org.example.domain.cart.CartItem;
import org.example.domain.furniture.Furniture;
import org.example.dto.CartItemDto;
import org.example.dto.AddCartItemRequest;
import org.springframework.stereotype.Component;

/**
 * Manual implementation of CartItemMapper.
 */
@Component
public class CartItemMapperImpl implements CartItemMapper {

    @Override
    public CartItemDto toDto(CartItem entity) {
        if (entity == null) return null;

        Furniture furniture = entity.getFurniture();

        return CartItemDto.builder()
                .id(entity.getId())
                .furnitureId(furniture.getId())
                .name(furniture.getName())
                .description(furniture.getDescription())
                .price(furniture.getPrice())
                .quantity(entity.getQuantity())
                .build();
    }

    @Override
    public CartItem toEntity(CartItemDto dto) {
        throw new UnsupportedOperationException("Mapping from CartItemDto to CartItem is not supported.");
    }

    @Override
    public CartItem fromRequest(AddCartItemRequest request) {
        return CartItem.builder()
                .quantity(request.getQuantity())
                .build();
    }
}
