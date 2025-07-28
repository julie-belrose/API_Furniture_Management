package org.example.service;

import org.example.dto.cart.AddCartItemRequest;
import org.example.dto.cart.CartDto;
import org.example.domain.cart.Cart;
import java.util.UUID;

/**
 * Service interface for shopping cart operations.
 */
public interface CartService extends GenericCrud<CartDto, Cart, UUID> {

    /**
     * Creates a new cart.
     */
    CartDto createCart();

    /**
     * Retrieves a cart by ID.
     */
    CartDto getCart(UUID cartId);

    /**
     * Adds a furniture item to the cart.
     */
    CartDto addCartItem(UUID cartId, AddCartItemRequest request);

    /**
     * Removes an item from the cart by ID.
     */
    CartDto removeCartItem(UUID cartId, UUID cartItemId);

    /**
     * Clears the entire cart.
     */
    CartDto clearCart(UUID cartId);
}
