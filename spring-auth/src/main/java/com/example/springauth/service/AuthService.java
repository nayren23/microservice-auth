package com.example.springauth.service;

import org.springframework.stereotype.Service;
import java.util.Base64;

@Service
public class AuthService {

    public AuthService() {
    }

    public String generateToken(String login, String password) {
        String encoding = Base64.getEncoder().encodeToString((login + ":" + password).getBytes());
        return "Basic " + encoding;
    }
}