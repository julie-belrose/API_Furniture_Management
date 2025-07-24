package org.example.mapper;

public interface GenericMapper<E, Dto> {
    Dto toDto(E entity);
    E toEntity(Dto dto);
}
