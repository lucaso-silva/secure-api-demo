package com.lucas.secure_api_demo.infrastructure.security;

import com.lucas.secure_api_demo.infrastructure.security.dto.AuthUser;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;

    @Value("${jwt.header}")
    private String header;

    @Value("${jwt.prefix}")
    private String prefix;

    @Autowired
    public JwtAuthenticationFilter(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String authHeader = request.getHeader(header);

        if (authHeader != null && authHeader.startsWith(prefix + " ")) {
            final String token = authHeader.substring(prefix.length() + 1);

            if (jwtService.isTokenValid(token)) {
                final String email = jwtService.extractEmail(token);
                final Long userId = jwtService.extractUserId(token);
                final String role = jwtService.extractRole(token);
                final AuthUser authUser = new AuthUser(userId, email, role);

                var authorities = List.of(new SimpleGrantedAuthority("ROLE_"+ role));

                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(authUser, null, authorities);

                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                if(SecurityContextHolder.getContext().getAuthentication() == null) {
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        }
        filterChain.doFilter(request, response);
    }
}
