package com.lucas.secure_api_demo.application.exception;

public class EmailAlreadyInUseException extends RuntimeException {
    public EmailAlreadyInUseException(String formatted) {
        super(formatted);
    }
}
