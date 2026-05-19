package com.lucas.secure_api_demo.infrastructure.controller;

import com.lucas.secure_api_demo.application.dto.RegisterUserInput;
import com.lucas.secure_api_demo.application.dto.ValidateUserInput;
import com.lucas.secure_api_demo.application.ports.inbound.RegisterUserUseCase;
import com.lucas.secure_api_demo.application.ports.inbound.ValidateUserUseCase;
import com.lucas.secure_api_demo.infrastructure.controller.dto.LoginResponse;
import com.lucas.secure_api_demo.infrastructure.controller.dto.UserResponse;
import com.lucas.secure_api_demo.infrastructure.security.JwtService;
import com.lucas.secure_api_demo.infrastructure.security.dto.AuthUser;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@AllArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final RegisterUserUseCase register;
    private final ValidateUserUseCase validate;
    private final JwtService jwtService;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@Valid @RequestBody RegisterUserInput input) {
        var user = register.create(input);
        var uri = URI.create("/users/" + user.getId());
        return ResponseEntity.created(uri).body(UserResponse.from(user));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody ValidateUserInput input) {
        var authenticatedUser = validate.validateCredentials(input);
        var token = jwtService.generateToken(authenticatedUser.id(),
                authenticatedUser.email(),
                authenticatedUser.role());

        return ResponseEntity.ok(new LoginResponse(token));
    }

    @GetMapping("/public")
    public ResponseEntity<String> publicRoute(){
        return ResponseEntity.ok("Public route access");
    }

    @GetMapping("/private")
    public ResponseEntity<String> privateRoute() {
        return ResponseEntity.ok("Private route access");
    }

    @GetMapping("/me")
    public ResponseEntity<AuthUser> getCurrentUser(@AuthenticationPrincipal AuthUser authUser) {
        return ResponseEntity.ok(authUser);
    }

    @GetMapping("/admin")
    public ResponseEntity<String> adminRoute(){
        return ResponseEntity.ok("Admin route access");
    }

    @GetMapping("/client")
    public ResponseEntity<String> clientRoute(){
        return ResponseEntity.ok("Client route access");
    }
}
