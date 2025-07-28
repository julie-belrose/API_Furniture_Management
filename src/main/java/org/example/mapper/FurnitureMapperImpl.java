package org.example.mapper;

import org.example.domain.furniture.Furniture;
import org.springframework.stereotype.Component;
import org.example.dto.furniture.FurnitureDto;
import org.example.dto.furniture.FurnitureRequest;

/**
 * Manual implementation of FurnitureMapper.
 */
@Component
public class FurnitureMapperImpl implements FurnitureMapper {

    @Override
    public FurnitureDto toDto(Furniture entity) {
        if (entity == null) return null;

        return FurnitureDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .price(entity.getPrice())
                .stock(entity.getStock())
                .build();
    }

    @Override
    public Furniture toEntity(FurnitureDto dto) {
        if (dto == null) return null;

        return Furniture.builder()
                .id(dto.getId())
                .name(dto.getName())
                .description(dto.getDescription())
                .price(dto.getPrice())
                .stock(dto.getStock())
                .build();
    }

    @Override
    public Furniture fromRequest(FurnitureRequest request) {
        if (request == null) return null;

        return Furniture.builder()
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .stock(request.getStock())
                .build();
    }
}
