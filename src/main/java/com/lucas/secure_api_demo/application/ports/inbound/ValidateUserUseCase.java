package com.lucas.secure_api_demo.application.ports.inbound;

import com.lucas.secure_api_demo.application.dto.AuthUserOutput;
import com.lucas.secure_api_demo.application.dto.ValidateUserInput;

public interface ValidateUserUseCase {
    AuthUserOutput validateCredentials(ValidateUserInput input);
}
