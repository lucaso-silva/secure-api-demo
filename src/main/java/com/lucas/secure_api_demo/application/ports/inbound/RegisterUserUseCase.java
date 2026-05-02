package com.lucas.secure_api_demo.application.ports.inbound;

import com.lucas.secure_api_demo.application.dto.RegisterUserInput;
import com.lucas.secure_api_demo.domain.model.User;

public interface RegisterUserUseCase {
    User create(RegisterUserInput input);
}
