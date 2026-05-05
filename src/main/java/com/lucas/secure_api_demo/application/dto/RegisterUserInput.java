package com.lucas.secure_api_demo.application.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegisterUserInput(@NotBlank(message = "You must provide a name")
                                String name,
                                @NotBlank(message = "You must provide an email")
                                @Email
                                String email,
                                @NotBlank(message = "You must provide a password")
                                @Size(min = 6, max = 20)
                                String password,
                                @NotBlank(message = "You must provide a role")
                                String role) {
}
