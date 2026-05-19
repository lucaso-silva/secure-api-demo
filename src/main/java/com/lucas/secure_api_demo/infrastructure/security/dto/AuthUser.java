package com.lucas.secure_api_demo.infrastructure.security.dto;

public record AuthUser(Long userId,
                       String email,
                       String role) {
}
