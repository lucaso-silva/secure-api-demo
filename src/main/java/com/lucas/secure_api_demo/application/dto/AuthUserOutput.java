package com.lucas.secure_api_demo.application.dto;

public record AuthUserOutput(Long id,
                             String email,
                             String role) {
}
