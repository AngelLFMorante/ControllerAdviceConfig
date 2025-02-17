package org.afernandez.example.controlleradvice.exception;

/**
 * Excepción para recursos no encontrados.
 */
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}

