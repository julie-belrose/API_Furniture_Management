package org.example.domain.furniture;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.UUID;

/**
 * Represents a piece of furniture available for sale.
 * Mapped to the "furniture" table in the database.
 */
@Entity // Marks this class as a JPA entity to be persisted in the database.
@Table(name = "furniture") // Specifies the table name in the database.
@Data
@NoArgsConstructor // Lombok annotation to generate a no-argument constructor.
@AllArgsConstructor // Lombok annotation to generate a constructor with all fields.
@Builder // Lombok annotation to generate a builder pattern for the class.
public class Furniture {

    /**
     * Unique identifier for each furniture item.
     * Generated using a UUID strategy.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    /**
     * Name of the furniture item.
     * This field is required.
     */
    @Column(nullable = false)
    private String name;

    /**
     * Optional description of the furniture.
     * Maximum length is 255 characters.
     */
    @Column(length = 255)
    private String description;

    /**
     * Price of the furniture.
     * Must be a positive value.
     */
    @Column(nullable = false)
    private double price;

    /**
     * Current available stock of the furniture.
     * Must be zero or a positive integer.
     */
    @Column(nullable = false)
    private int stock;
}
