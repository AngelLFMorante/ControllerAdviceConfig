package org.afernandez.example.controlleradvice.exception;

/**
 * Excepción para IDs inválidas.
 */
public class InvalidIdException extends RuntimeException {
    public InvalidIdException(String message) {
        super(message);
    }
}

