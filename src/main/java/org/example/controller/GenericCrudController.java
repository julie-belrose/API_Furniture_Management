package org.example.controller;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface GenericCrudController<T, ID> {
    ResponseEntity<List<T>> getAll();
    ResponseEntity<T> getById(ID id);
    ResponseEntity<T> save(T dto);
    ResponseEntity<T> update(T dto);
    ResponseEntity<Void> delete(ID id);
}
