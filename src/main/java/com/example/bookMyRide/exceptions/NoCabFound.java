package com.example.bookMyRide.exceptions;

public class NoCabFound extends RuntimeException {
    public NoCabFound(String message) {
        super(message);
    }
}
