package org.example.repository;

import org.example.domain.furniture.Furniture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FurnitureRepository extends JpaRepository<Furniture, UUID> {
}