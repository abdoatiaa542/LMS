package com.example.LMS.exception.client;


// BadRequestException.java
public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}