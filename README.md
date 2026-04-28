# Secure API Demo - Spring Security

![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen)
![Spring Security](https://img.shields.io/badge/Spring%20Security-enabled-green)
![Status](https://img.shields.io/badge/status-initial-blue)

This project demonstrates a simple setup of **Spring Security** in a Spring Boot application.

The goal is to show the basics of API protection, including:

- Public and protected routes
- Basic authentication using `formLogin`
- Default behavior of Spring Security (login flow and session-based authentication)

## Tech Stack

- Java
- Spring Boot
- Spring Security

## What is implemented

- `/auth/public` → public endpoint  
- `/auth/private` → protected endpoint (requires authentication)  

**Spring Security is configured to:**

- Restrict access to protected routes  
- Redirect unauthenticated users to `/login`  
- Manage authentication using HTTP session (stateful)  

## 📌 Current Status

This is an **initial version** of the project, focused on understanding the fundamentals of Spring Security.

## 🔜 Next Steps

The next step is to evolve this API to a **stateless authentication model using JWT**, including:

- Token generation  
- Token validation  
- Use of claims  
- Custom authentication filter

---
[Lucas Oliveira](https://www.linkedin.com/in/lucas-oliveira10/)
