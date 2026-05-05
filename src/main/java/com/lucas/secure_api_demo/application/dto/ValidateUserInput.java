package com.lucas.secure_api_demo.application.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record ValidateUserInput(@NotBlank(message = "You must provide an email")
                                @Email
                                String email,
                                @NotBlank(message = "You must provide a password")
                                String password) {
}
