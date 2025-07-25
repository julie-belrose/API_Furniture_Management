package org.example.service;

import org.example.dto.CartItemDto;
import org.example.dto.AddCartItemRequest;

import java.util.List;
import java.util.UUID;

/**
 * Service interface for shopping cart operations.
 */
public interface CartService {

    /**
     * Returns the cart item with the specified ID.
     */
    CartItemDto getCartItemById(UUID id);

    /**
     * Returns all cart items with detailed furniture info.
     */
    List<CartItemDto> getAllCartItems();

    /**
     * Adds a furniture item to the cart.
     */
    CartItemDto addCartItem(AddCartItemRequest request);

    /**
     * Updates an existing cart item.
     */
    CartItemDto updateCartItem(UUID id, AddCartItemRequest request);

    /**
     * Removes an item from the cart by ID.
     */
    boolean removeCartItem(UUID id);

    /**
     * Clears the entire cart.
     */
    void clearCart();
}
