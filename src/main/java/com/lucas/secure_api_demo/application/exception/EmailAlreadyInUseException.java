package com.lucas.secure_api_demo.application.exception;

import org.springframework.http.HttpStatus;

public class EmailAlreadyInUseException extends BusinessException {
    public static final String CODE = "auth.email-already-in-use";
    public static final HttpStatus  HTTP_STATUS = HttpStatus.CONFLICT;

    public EmailAlreadyInUseException(String message) {
        super(CODE, message, HTTP_STATUS);
    }
}
