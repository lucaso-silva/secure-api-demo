package com.lucas.secure_api_demo.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class User {

    private Long id;
    private String name;
    private String email;
    private String password;
    private String role;
}
