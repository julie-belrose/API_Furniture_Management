package org.example.service;

import java.util.List;
import java.util.Optional;

public interface GenericCrud<T, ID> {
    T save(T entity);
    Optional<T> findById(ID id);
    List<T> findAll();
    T update(T entity);
    boolean delete(ID id);
}
