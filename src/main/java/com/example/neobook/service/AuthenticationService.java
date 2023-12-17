package com.example.neobook.service;

import com.example.neobook.dto.AuthResponse;
import com.example.neobook.dto.SignInRequest;
import com.example.neobook.dto.SignUpRequest;
import org.springframework.stereotype.Service;

@Service
public interface AuthenticationService {
    AuthResponse register(SignUpRequest signUpRequest);
    AuthResponse login(SignInRequest signInRequest);
}
