package org.example.service.impl;

import org.example.mapper.GenericMapper;
import org.example.service.GenericCrud;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public abstract class GenericCrudImpl<Dto, Entity, ID> implements GenericCrud<Dto, Entity, ID> {

    protected final JpaRepository<Entity, ID> repository;
    protected final GenericMapper<Entity, Dto> mapper;

    protected abstract ID extractId(Dto dto);

    protected GenericCrudImpl(JpaRepository<Entity, ID> repository, GenericMapper<Entity, Dto> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Dto save(Dto dto) {
        Entity entity = mapper.toEntity(dto);
        Entity saved = repository.save(entity);
        return mapper.toDto(saved);
    }

    @Override
    public Optional<Dto> findById(ID id) {
        return repository.findById(id).map(mapper::toDto);
    }

    @Override
    public List<Dto> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public Optional<Dto> update(Dto dto) {
        Entity entity = mapper.toEntity(dto);
        Entity updated = repository.save(entity);
        return Optional.of(mapper.toDto(updated));
    }

    @Override
    public boolean delete(ID id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
