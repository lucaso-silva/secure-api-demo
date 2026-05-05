package com.lucas.secure_api_demo.infrastructure.controller.dto;

import com.lucas.secure_api_demo.domain.model.User;

public record UserResponse(Long id,
                           String name,
                           String email,
                           String role) {
    public static UserResponse from(User user){
        return new UserResponse(user.getId(),
                user.getName(),
                user.getEmail(),
                user.getRole());
    }
}
