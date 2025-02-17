package org.afernandez.example.controlleradvice.controller;

import org.afernandez.example.controlleradvice.model.Item;
import org.afernandez.example.controlleradvice.services.ItemService;
import org.springframework.http.ResponseEntity;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador REST para gestionar Items.
 */
@RestController
@RequestMapping("/items")
public class ItemController {

    private final ItemService service;

    public ItemController(ItemService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Item>> getAllItems() {
        return ResponseEntity.ok(service.getAllItems());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.getItemById(id));
    }

    @PostMapping
    public ResponseEntity<Item> createItem(@RequestBody Item item) {
        return ResponseEntity.ok(service.createItem(item));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable("id") String id, @RequestBody Item item) {
        return ResponseEntity.ok(service.updateItem(id, item));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable("id") String id) {
        service.deleteItem(id);
        return ResponseEntity.noContent().build();
    }
}

