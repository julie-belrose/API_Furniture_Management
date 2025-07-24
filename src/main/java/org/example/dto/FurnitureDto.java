package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * Data Transfer Object (DTO) used to expose furniture data via the API.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FurnitureDto {

    private UUID id;
    private String name;
    private String description;
    private double price;
    private int stock;
}
