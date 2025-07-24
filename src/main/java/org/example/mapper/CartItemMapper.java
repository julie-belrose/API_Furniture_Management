package org.example.mapper;

import org.example.domain.cart.CartItem;
import org.example.dto.CartItemDto;
import org.example.dto.AddCartItemRequest;

/**
 * Maps between CartItem entity and CartItemDto.
 * Also maps AddCartItemRequest into CartItem entity.
 */
public interface CartItemMapper extends GenericMapper<CartItem, CartItemDto> {

    /**
     * Converts an AddCartItemRequest into a CartItem entity.
     */
    CartItem fromRequest(AddCartItemRequest request);
}
