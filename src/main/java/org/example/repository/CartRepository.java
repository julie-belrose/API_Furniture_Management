package org.example.repository;

import org.example.domain.cart.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Repository for {@link org.example.domain.cart.Cart} entity.
 */
@Repository
public interface CartRepository extends JpaRepository<Cart, UUID> {
    // Custom query methods can be added here if needed
}
