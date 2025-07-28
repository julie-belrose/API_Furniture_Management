package org.example.mapper;

import org.example.domain.cart.Cart;
import org.example.domain.cart.CartItem;
import org.example.dto.cart.CartDto;
import org.example.dto.cart.CartItemDto;

public interface CartMapper extends GenericMapper<Cart, CartDto> {
    CartItemDto toDto(CartItem entity);
    CartItem toEntity(CartItemDto dto);
    Cart fromRequest(CartDto dto);
}
