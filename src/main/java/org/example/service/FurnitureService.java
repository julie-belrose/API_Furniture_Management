package org.example.service;

import org.example.domain.furniture.Furniture;
import org.example.dto.furniture.FurnitureDto;
import org.example.dto.furniture.FurnitureRequest;

import java.util.UUID;

/**
 * Business interface for high-level furniture operations.
 */
public interface FurnitureService extends GenericCrud<FurnitureDto, Furniture, UUID> {
    FurnitureDto create(FurnitureRequest request);
}
