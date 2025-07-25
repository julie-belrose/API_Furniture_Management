package org.example.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
