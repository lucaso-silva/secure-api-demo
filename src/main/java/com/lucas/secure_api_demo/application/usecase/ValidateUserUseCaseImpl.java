package com.lucas.secure_api_demo.application.usecase;

import com.lucas.secure_api_demo.application.dto.AuthUserOutput;
import com.lucas.secure_api_demo.application.dto.ValidateUserInput;
import com.lucas.secure_api_demo.application.exception.InvalidCredentialsException;
import com.lucas.secure_api_demo.application.ports.inbound.ValidateUserUseCase;
import com.lucas.secure_api_demo.application.ports.outbound.UserGateway;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class ValidateUserUseCaseImpl implements ValidateUserUseCase {
    private final UserGateway userGateway;
    private final PasswordEncoder passwordEncoder;

    @Override
    public AuthUserOutput validateCredentials(ValidateUserInput input) {
        var user = userGateway.findByEmail(input.email())
                .orElseThrow(() -> new InvalidCredentialsException("Invalid credentials"));

        if(!passwordEncoder.matches(input.password(), user.getPassword())) {
            throw new InvalidCredentialsException("Invalid credentials");
        }

        return new AuthUserOutput(user.getId(), user.getEmail(), user.getRole());
    }
}
