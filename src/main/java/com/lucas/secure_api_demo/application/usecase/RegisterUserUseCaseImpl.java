package com.lucas.secure_api_demo.application.usecase;

import com.lucas.secure_api_demo.application.dto.RegisterUserInput;
import com.lucas.secure_api_demo.application.exception.EmailAlreadyInUseException;
import com.lucas.secure_api_demo.application.ports.inbound.RegisterUserUseCase;
import com.lucas.secure_api_demo.application.ports.outbound.UserGateway;
import com.lucas.secure_api_demo.domain.model.User;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class RegisterUserUseCaseImpl implements RegisterUserUseCase {

    private final UserGateway userGateway;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User create(RegisterUserInput input) {
        if(userGateway.existsByEmail(input.email())){
            throw new EmailAlreadyInUseException("Email '%s' already exists.".formatted(input.email()));
        }

        return userGateway.save(new User(
                input.name(),
                input.email(),
                passwordEncoder.encode(input.password()),
                input.role()
        ));
    }
}
