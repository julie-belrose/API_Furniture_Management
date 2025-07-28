package org.example.domain.cart;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.example.domain.furniture.Furniture;

import java.util.UUID;

/**
 * Represents an item added to the shopping cart.
 * Each CartItem is linked to a specific Furniture and has a quantity.
 */
@Entity
@Table(name = "cart_item") // Maps this entity to the "cart_item" table in the database
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartItem {

    @Id // Declares the primary key of the entity
    @GeneratedValue(strategy = GenerationType.UUID) // Uses a custom generator to auto-generate UUID
    @Column(name = "id", updatable = false, nullable = false) // Makes the column required and immutable
    private UUID id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    // Creates a many-to-one relationship to Furniture.
    // "optional = false" = required
    // "fetch = LAZY" = load furniture only when needed (lazy loading)
    @JoinColumn(name = "furniture_id", nullable = false)
    // Specifies the foreign key column name in the "cart_item" table
    private Furniture furniture;

    @Column(nullable = false)
    // Represents how many units of this furniture are in the cart
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    /**
     * Calculates the subtotal for this cart item (price * quantity).
     * 
     * @return The subtotal amount for this item
     */
    public double getSubtotal() {
        if (furniture == null) {
            return 0.0;
        }
        return furniture.getPrice() * quantity;
    }
}
