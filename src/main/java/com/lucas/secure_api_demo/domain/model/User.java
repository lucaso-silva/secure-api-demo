package com.lucas.secure_api_demo.domain.model;

import lombok.Getter;

@Getter
public class User {

    private Long id;
    private final String name;
    private final String email;
    private final String password;
    private final String role;

    public User(String name, String email, String password, String role) {
        this(null, name, email, password, role);
    }

    public User(Long id, String name, String email, String password, String role)
    {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }
}
