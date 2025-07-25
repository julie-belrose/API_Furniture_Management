package org.example.service;

import java.util.List;
import java.util.Optional;

/**
 * Generic CRUD interface for services using DTOs.
 *
 * @param <Dto>    the Data Transfer Object type
 * @param <Entity> the entity type (e.g., Furniture)
 * @param <ID>     the identifier type (e.g., UUID)
 */
public interface GenericCrud<Dto, Entity, ID> {

    /**
     * Saves a new DTO.
     *
     * @param dto the DTO to save
     * @return the saved DTO
     */
    Dto save(Dto dto);

    /**
     * Finds a DTO by its ID.
     *
     * @param id the identifier
     * @return an optional containing the found DTO, or empty if not found
     */
    Optional<Dto> findById(ID id);

    /**
     * Returns all DTOs.
     *
     * @return a list of DTOs
     */
    List<Dto> findAll();

    /**
     * Updates an existing DTO.
     *
     * @param dto the DTO to update
     * @return an optional containing the updated DTO
     */
    Optional<Dto> update(Dto dto);

    /**
     * Deletes a DTO by ID.
     *
     * @param id the identifier
     * @return true if deleted, false otherwise
     */
    boolean delete(ID id);
}
