package org.example.service.impl;

import org.example.domain.cart.Cart;
import org.example.domain.cart.CartItem;
import org.example.domain.furniture.Furniture;
import org.example.dto.cart.AddCartItemRequest;
import org.example.dto.cart.CartDto;
import org.example.exception.CartNotFoundException;
import org.example.exception.FurnitureNotFoundException;
import org.example.exception.OutOfStockException;
import org.example.mapper.CartMapper;
import org.example.repository.CartRepository;
import org.example.repository.FurnitureRepository;
import org.example.service.CartService;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Service implementation for cart operations.
 */
@Service
public abstract class CartServiceImpl extends GenericCrudImpl<CartDto, Cart, UUID> implements CartService {

    private final CartRepository cartRepository;
    private final FurnitureRepository furnitureRepository;
    private final CartMapper cartMapper;

    public CartServiceImpl(CartRepository cartRepository,
            FurnitureRepository furnitureRepository,
            CartMapper cartMapper) {
        super(cartRepository, cartMapper);
        this.cartRepository = cartRepository;
        this.furnitureRepository = furnitureRepository;
        this.cartMapper = cartMapper;
    }

    @Override
    public CartDto createCart() {
        Cart cart = new Cart();
        cart.setTotal(0.0);
        return cartMapper.toDto(cartRepository.save(cart));
    }

    @Override
    public CartDto getCart(UUID cartId) {
        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new CartNotFoundException(cartId));
        return cartMapper.toDto(cart);
    }

    @Override
    public CartDto addCartItem(UUID cartId, AddCartItemRequest request) {
        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new CartNotFoundException(cartId));

        Furniture furniture = furnitureRepository.findById(request.getFurnitureId())
                .orElseThrow(() -> new FurnitureNotFoundException(request.getFurnitureId()));

        if (request.getQuantity() > furniture.getStock()) {
            throw new OutOfStockException(furniture.getId(), request.getQuantity(), furniture.getStock());
        }

        CartItem item = new CartItem();
        item.setCart(cart);
        item.setFurniture(furniture);
        item.setQuantity(request.getQuantity());

        cart.getItems().add(item);
        cart.updateTotal();

        return cartMapper.toDto(cartRepository.save(cart));
    }

    @Override
    public CartDto removeCartItem(UUID cartId, UUID cartItemId) {
        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new CartNotFoundException(cartId));

        cart.getItems().removeIf(i -> i.getId().equals(cartItemId));
        cart.updateTotal();

        return cartMapper.toDto(cartRepository.save(cart));
    }

    @Override
    public CartDto clearCart(UUID cartId) {
        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new CartNotFoundException(cartId));

        cart.getItems().clear();
        cart.setTotal(0.0);

        return cartMapper.toDto(cartRepository.save(cart));
    }
}