package com.example.polis_hospital_management.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String resource, Long id) {
        super(resource + " with ID " + id + " not found!");
    }
}
