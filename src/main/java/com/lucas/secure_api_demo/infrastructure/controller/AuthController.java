package com.lucas.secure_api_demo.infrastructure.controller;

import com.lucas.secure_api_demo.application.dto.RegisterUserInput;
import com.lucas.secure_api_demo.application.ports.inbound.RegisterUserUseCase;
import com.lucas.secure_api_demo.infrastructure.controller.dto.UserResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@AllArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private RegisterUserUseCase register;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@Valid @RequestBody RegisterUserInput input) {
        var user = register.create(input);
        var uri = URI.create("/users/" + user.getId());
        return ResponseEntity.created(uri).body(UserResponse.from(user));
    }

    @GetMapping("/public")
    public ResponseEntity<String> publicRoute(){
        return ResponseEntity.ok("<h1>Public route access</h1>");
    }

    @GetMapping("/private")
    public ResponseEntity<String> privateRoute() {
        return ResponseEntity.ok("<h1>Private route access</h1>");
    }
}
