package org.example.service.impl;

import org.example.domain.furniture.Furniture;
import org.example.dto.FurnitureDto;
import org.example.dto.FurnitureRequest;
import org.example.mapper.FurnitureMapper;
import org.example.repository.FurnitureRepository;
import org.example.service.FurnitureService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Implementation of the FurnitureService interface.
 * Provides business logic for handling furniture operations.
 */
@Service
public class FurnitureServiceImpl extends GenericCrudImpl<FurnitureDto, Furniture, UUID> implements FurnitureService {

    private final FurnitureRepository furnitureRepository;
    private final FurnitureMapper furnitureMapper;

    public FurnitureServiceImpl(FurnitureRepository furnitureRepository, FurnitureMapper furnitureMapper) {
        super(furnitureRepository, furnitureMapper);
        this.furnitureRepository = furnitureRepository;
        this.furnitureMapper = furnitureMapper;
    }


    public FurnitureDto create(FurnitureRequest request) {
        Furniture entity = furnitureMapper.fromRequest(request);
        Furniture saved = furnitureRepository.save(entity);
        return furnitureMapper.toDto(saved);
    }

    @Override
    protected UUID extractId(FurnitureDto dto) {
        return dto.getId();
    }

    @Override
    public Optional<FurnitureDto> findById(UUID id) {
        return furnitureRepository.findById(id).map(furnitureMapper::toDto);
    }

    @Override
    public List<FurnitureDto> findAll() {
        return furnitureRepository.findAll().stream()
                .map(furnitureMapper::toDto)
                .toList();
    }

    @Override
    public boolean delete(UUID id) {
        if (furnitureRepository.existsById(id)) {
            furnitureRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public FurnitureDto save(FurnitureDto dto) {
        Furniture entity = furnitureMapper.toEntity(dto);
        Furniture saved = furnitureRepository.save(entity);
        return furnitureMapper.toDto(saved);
    }

    @Override
    public Optional<FurnitureDto> update(FurnitureDto dto) {
        if (dto.getId() == null || !furnitureRepository.existsById(dto.getId())) {
            return Optional.empty();
        }
        Furniture entity = furnitureMapper.toEntity(dto);
        Furniture updated = furnitureRepository.save(entity);
        return Optional.of(furnitureMapper.toDto(updated));
    }
}
