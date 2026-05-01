package com.lucas.secure_api_demo.application.ports.outbound;

import com.lucas.secure_api_demo.domain.model.User;

import java.util.Optional;

public interface UserGateway {
    Optional<User> findByEmail(String email);
}
