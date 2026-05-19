package com.lucas.secure_api_demo.application.exception;

import org.springframework.http.HttpStatus;

public class InvalidCredentialsException extends BusinessException {
    public static final String CODE = "auth.invalid-credentials";
    public static final String MESSAGE = "Invalid email or password";
    public static final HttpStatus HTTP_STATUS = HttpStatus.UNAUTHORIZED;

    public InvalidCredentialsException() {
        super(CODE, MESSAGE, HTTP_STATUS);
    }
}
