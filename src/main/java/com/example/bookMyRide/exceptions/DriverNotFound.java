package com.example.bookMyRide.exceptions;

public class DriverNotFound extends RuntimeException {
    public DriverNotFound(String message) {
        super(message);
    }
}
