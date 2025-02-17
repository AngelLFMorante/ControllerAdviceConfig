package org.afernandez.example.controlleradvice.services;

import org.afernandez.example.controlleradvice.exception.InvalidIdException;
import org.afernandez.example.controlleradvice.exception.ResourceNotFoundException;
import org.afernandez.example.controlleradvice.model.Item;
import org.afernandez.example.controlleradvice.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio que maneja la lógica de negocio para Items.
 */
@Service
public class ItemService {

    private final ItemRepository repository;

    public ItemService(ItemRepository repository) {
        this.repository = repository;
    }

    /**
     * Obtiene todos los Items.
     * @return Lista de Items.
     */
    public List<Item> getAllItems() {
        return repository.findAll();
    }

    /**
     * Obtiene un Item por su ID.
     * @param id ID del Item.
     * @return Item encontrado.
     * @throws ResourceNotFoundException si el Item no existe.
     */
    public Item getItemById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Item con ID " + id + " no encontrado"));
    }

    /**
     * Crea un nuevo Item.
     * @param item Item a crear.
     * @return Item creado.
     */
    public Item createItem(Item item) {
        return repository.save(item);
    }

    /**
     * Actualiza un Item existente.
     * @param id ID del Item.
     * @param item Datos a actualizar.
     * @return Item actualizado.
     * @throws InvalidIdException si el ID no es válido.
     * @throws ResourceNotFoundException si el Item no existe.
     */
    public Item updateItem(String id, Item item) {
        if (!id.matches("\\d+")) {
            throw new InvalidIdException("La id no está bien formulada, no se permiten caracteres");
        }

        Long itemId = Long.parseLong(id);
        if (!repository.existsById(itemId)) {
            throw new ResourceNotFoundException("Item con ID " + itemId + " no encontrado");
        }

        item.setId(itemId);
        return repository.save(item);
    }

    /**
     * Elimina un Item por su ID.
     * @param id ID del Item.
     * @throws InvalidIdException si el ID no es válido.
     * @throws ResourceNotFoundException si el Item no existe.
     */
    public void deleteItem(String id) {
        if (!id.matches("\\d+")) {
            throw new InvalidIdException("La id no está bien formulada, no se permiten caracteres");
        }

        Long itemId = Long.parseLong(id);
        if (!repository.existsById(itemId)) {
            throw new ResourceNotFoundException("Item con ID " + itemId + " no encontrado");
        }

        repository.deleteById(itemId);
    }
}
