package org.example.service;

import org.example.dto.FurnitureDto;
import org.example.dto.FurnitureRequest;

/**
 * Service interface for furniture-related operations.
 */
public interface FurnitureService {

    /**
     * Creates a furniture item from a request.
     * 
     * @param request the incoming request
     * @return the created DTO
     */
    FurnitureDto create(FurnitureRequest request);
}
