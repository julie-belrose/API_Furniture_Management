package org.example.mapper;

import org.example.domain.furniture.Furniture;
import org.example.dto.furniture.FurnitureRequest;
import org.example.dto.furniture.FurnitureDto;

/**
 * Maps between Furniture entity and FurnitureDto.
 * Also maps FurnitureRequest into Furniture entity.
 */
public interface FurnitureMapper extends GenericMapper<Furniture, FurnitureDto> {

    /**
     * Converts a FurnitureRequest into a Furniture entity.
     */
    Furniture fromRequest(FurnitureRequest request);
}