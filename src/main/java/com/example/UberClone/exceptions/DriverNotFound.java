package com.example.UberClone.exceptions;

public class DriverNotFound extends RuntimeException {
    public DriverNotFound(String message) {
        super(message);
    }
}
