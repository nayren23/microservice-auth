package com.example.springauth.controller;

import com.example.springauth.service.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@RestController
@RequestMapping("/auth/")
public class AuthController {

    @PostMapping("/login")
    public String authentification(HttpServletRequest request) {
        String username = null;
        String password = null;

        String authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader != null && authorizationHeader.startsWith("Basic")) {
            // On recupere les informations d'identification de l'en-tête d'autorisation
            String base64Credentials = authorizationHeader.substring("Basic".length()).trim();
            byte[] credDecoded = Base64.getDecoder().decode(base64Credentials);
            String credentials = new String(credDecoded, StandardCharsets.UTF_8);
            // Les informations d'identification sont de la forme "username:password"
            final String[] values = credentials.split(":", 2);
            username = values[0];
            password = values[1];
        }
        AuthService authService = new AuthService();
        return authService.generateToken(username, password);
    }
}