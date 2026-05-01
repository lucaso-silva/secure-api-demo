package com.lucas.secure_api_demo.infrastructure.persistence.adapter;

import com.lucas.secure_api_demo.domain.model.User;
import com.lucas.secure_api_demo.application.ports.outbound.UserGateway;
import com.lucas.secure_api_demo.infrastructure.persistence.mapper.UserMapper;
import com.lucas.secure_api_demo.infrastructure.persistence.repository.UserJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class UserRepositoryAdapter implements UserGateway {

    private final UserJpaRepository userRepository;
    private final UserMapper mapper;

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email)
                .map(mapper::toDomain);
    }
}
