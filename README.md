# Secure API Demo - Spring Security & JWT

![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen)
![Spring Security](https://img.shields.io/badge/Spring%20Security-enabled-green)
![JWT](https://img.shields.io/badge/JWT-authentication-blue)
![Status](https://img.shields.io/badge/status-learning%20project-blue)

This project demonstrates the evolution of **Spring Security** in a Spring Boot API, from basic route protection to a fully stateless authentication flow using JWT.

---

# Overview

The goal of this project is to explore how authentication and authorization work in practice, step by step:

1. Route protection with Spring Security
2. Custom authentication (register + login)
3. Stateless authentication and authorization with JWT

---

# Tech Stack

* Java 21
* Spring Boot
* Spring Security
* JWT (JJWT)
* H2 Database
* Lombok

---

# What is implemented

## Public and Protected Routes

* `/auth/public` → public endpoint
* `/auth/private` → protected endpoint

---

## Custom Authentication Flow

Instead of relying on Spring Security’s default login flow, this project implements custom endpoints for authentication:

* `/auth/register` → user registration
* `/auth/login` → user authentication

Passwords are securely stored using **BCrypt**.

---

## JWT Authentication

After successful login:

* credentials are validated
* a JWT token is generated
* the client must send the token in subsequent requests

Example:

```http
Authorization: Bearer <token>
```

The token includes:

* user identity (`subject`)
* user id
* user role
* expiration time

---

## JWT Authentication Filter

The project includes a custom `JwtAuthenticationFilter` responsible for:

* intercepting requests
* extracting the JWT from the request header
* validating the token
* extracting claims
* authenticating the user in Spring Security’s `SecurityContext`

---

## Role-Based Authorization

The API supports authorization based on user roles.

Examples:

* `/auth/admin` → requires `OWNER`
* `/auth/client` → requires `OWNER` or `CLIENT`

Implemented using:

* `hasRole(...)`
* `hasAnyRole(...)`

---

## Error Handling

Custom security handlers were implemented to standardize authentication and authorization errors:

### 401 Unauthorized

Returned when:

* token is missing
* token is invalid

Handled by:

* `CustomAuthenticationEntryPoint`

---

### 403 Forbidden

Returned when:

* the authenticated user does not have permission to access a resource

Handled by:

* `CustomAccessDeniedHandler`

---

## Global Exception Handling

The project also includes:

* `GlobalExceptionHandler`
* standardized API error responses using `ProblemDetail`

Validation errors return structured responses containing invalid fields and messages.

---

# Security Configuration

Spring Security is configured to:

* disable `formLogin`
* disable `httpBasic`
* use stateless session management
* allow public authentication routes
* protect private routes
* authenticate requests through JWT

---

# 📌 Current Status

The application now supports:

* custom authentication flow
* stateless JWT authentication
* token validation
* claims extraction
* role-based authorization
* standardized error handling

---

# 🔜 Possible Next Steps

Potential future improvements:

* refresh token flow
* persistent database
* UserDetailsService integration
* token revocation / blacklist
* integration and security tests

---

# 📎 Related Content

This project is part of a learning series about Spring Security and JWT.

* Post I → Route protection with Spring Security
* Post II → Custom authentication (register + login)
* **Post III → JWT authentication and authorization**

---

## Connect with me

- LinkedIn: [Lucas Oliveira](https://www.linkedin.com/in/lucas-oliveira10/)
