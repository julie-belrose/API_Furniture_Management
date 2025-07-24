package org.example.service;

import org.example.dto.FurnitureDto;
import org.example.dto.FurnitureRequest;

import java.util.UUID;

/**
 * Business interface for high-level furniture operations.
 */
public interface FurnitureService {
    FurnitureDto create(FurnitureRequest request);

    FurnitureDto save(FurnitureDto dto);

    FurnitureDto update(FurnitureDto dto);

    boolean delete(UUID id);
}
