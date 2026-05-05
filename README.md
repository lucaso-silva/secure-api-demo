# Secure API Demo - Spring Security

![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen)
![Spring Security](https://img.shields.io/badge/Spring%20Security-enabled-green)
![Status](https://img.shields.io/badge/status-under%20development-orange)

This project demonstrates the evolution of **Spring Security** in a Spring Boot API, from basic route protection to a custom authentication flow.

## Overview

The goal of this project is to explore how authentication works in practice, step by step:

1. **Route protection with Spring Security**
2. **Custom authentication (register + login)**
3. *(Next step)* Stateless authentication using JWT

---

## Tech Stack

- Java 21  
- Spring Boot  
- Spring Security  
- H2 Database  
- Lombok  

---

## What is implemented

### Public and Protected Routes

- `/auth/public` → public endpoint  
- `/auth/private` → protected endpoint (requires authentication)  

---

### Custom Authentication Flow

Instead of relying on Spring Security’s default login, this project implements:

- `/auth/register` → user registration  
- `/auth/login` → credential validation  

---

### Password Security

- Passwords are encrypted using **BCrypt**
- Password comparison is handled via `PasswordEncoder`

---

### Security Configuration

Spring Security is configured to:

- Allow access to authentication endpoints (`/auth/register`, `/auth/login`)  
- Protect all other routes  
- Use a **stateless session policy** (preparing for JWT)  

---

## 📌 Current Status

This project is currently focused on:

- Understanding authentication fundamentals  
- Implementing a custom login flow  
- Securing user credentials properly  

---

## 🔜 Next Steps

The next step is to evolve this API to a **stateless authentication model using JWT**, including:

- Token generation  
- Token validation  
- Use of claims  
- Custom authentication filter  

---

## 📎 Related Content

This project is part of a learning series about Spring Security and JWT.

- Post I → Route protection with Spring Security  
- **Post II → User authentication (register + login)**  
- Post III → *(coming next)* JWT authentication  

---
[Lucas Oliveira](https://www.linkedin.com/in/lucas-oliveira10/)
