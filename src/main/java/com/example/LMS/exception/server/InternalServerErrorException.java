package com.example.LMS.exception.server;

// InternalServerErrorException.java
public class InternalServerErrorException extends RuntimeException {
    public InternalServerErrorException(String message) {
        super(message);
    }
}