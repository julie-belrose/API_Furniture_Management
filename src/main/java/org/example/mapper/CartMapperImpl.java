package org.example.mapper;

import org.example.domain.cart.Cart;
import java.time.LocalDateTime;
import org.example.dto.cart.CartDto;

public abstract class CartMapperImpl implements CartMapper {

    private final CartItemMapper cartItemMapper;

    public CartMapperImpl(CartItemMapper cartItemMapper) {
        this.cartItemMapper = cartItemMapper;
    }

    @Override
    public CartDto toDto(Cart entity) {
        return CartDto.builder()
                .id(entity.getId())
                .total(entity.getTotal())
                .items(entity.getItems().stream()
                        .map(cartItemMapper::toDto)
                        .toList())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }

    @Override
    public Cart toEntity(CartDto dto) {
        return Cart.builder()
                .id(dto.getId())
                .total(dto.getTotal())
                .items(dto.getItems().stream()
                        .map(cartItemMapper::toEntity)
                        .toList())
                .createdAt(dto.getCreatedAt())
                .updatedAt(dto.getUpdatedAt())
                .build();
    }

    @Override
    public Cart fromRequest(CartDto dto) {
        return Cart.builder()
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }
}
