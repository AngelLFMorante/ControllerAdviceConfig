package org.afernandez.example.controlleradvice.repository;

import org.afernandez.example.controlleradvice.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio JPA para la entidad Item.
 */
@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}

