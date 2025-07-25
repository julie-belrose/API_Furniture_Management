package org.example.service.impl;

import org.example.domain.cart.CartItem;
import org.example.domain.furniture.Furniture;
import org.example.dto.AddCartItemRequest;
import org.example.dto.CartItemDto;
import org.example.mapper.CartItemMapper;
import org.example.repository.CartItemRepository;
import org.example.repository.FurnitureRepository;
import org.example.service.CartItemService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Service implementation for cart operations.
 */
@Service
public abstract class CartItemServiceImpl extends GenericCrudImpl<CartItemDto, CartItem, UUID> implements CartItemService {

    private final CartItemRepository cartItemRepository;
    private final FurnitureRepository furnitureRepository;
    private final CartItemMapper cartItemMapper;

    public CartItemServiceImpl(CartItemRepository cartItemRepository,
                               FurnitureRepository furnitureRepository,
                               CartItemMapper cartItemMapper) {
        super(cartItemRepository, cartItemMapper);
        this.cartItemRepository = cartItemRepository;
        this.furnitureRepository = furnitureRepository;
        this.cartItemMapper = cartItemMapper;
    }

    @Override
    protected UUID extractId(CartItemDto dto) {
        return dto.getId();
    }

    @Override
    public List<CartItemDto> getAllCartItems() {
        return cartItemRepository.findAll().stream()
                .map(cartItemMapper::toDto)
                .toList();
    }

    @Override
    public CartItemDto addCartItem(AddCartItemRequest request) {
        Furniture furniture = furnitureRepository.findById(request.getFurnitureId())
                .orElseThrow(() -> new RuntimeException("Furniture not found"));

        CartItem item = cartItemMapper.fromRequest(request);
        item.setFurniture(furniture);

        CartItem saved = cartItemRepository.save(item);
        return cartItemMapper.toDto(saved);
    }

    public CartItemDto updateCartItem(UUID id, CartItemDto dto) {
        CartItem entity = cartItemMapper.toEntity(dto);
        CartItem updated = cartItemRepository.save(entity);
        return cartItemMapper.toDto(updated);
    }

    @Override
    public boolean removeCartItem(UUID id) {
        if (cartItemRepository.existsById(id)) {
            cartItemRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public void clearCart() {
        cartItemRepository.deleteAll();
    }
}
