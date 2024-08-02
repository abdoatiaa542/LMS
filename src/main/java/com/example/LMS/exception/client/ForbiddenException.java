package com.example.LMS.exception.client;


// ForbiddenException.java
public class ForbiddenException extends RuntimeException {
    public ForbiddenException(String message) {
        super(message);
    }
}