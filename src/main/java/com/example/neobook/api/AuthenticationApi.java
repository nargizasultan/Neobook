package com.example.neobook.api;

import com.example.neobook.dto.AuthResponse;
import com.example.neobook.dto.SignInRequest;
import com.example.neobook.dto.SignUpRequest;
import com.example.neobook.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationApi {

    private final AuthenticationService authenticationService;


    @PostMapping("/register")
    public AuthResponse register(@RequestBody SignUpRequest signUpRequest) {
        return authenticationService.register(signUpRequest);

    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody SignInRequest signInRequest){
        return authenticationService.login(signInRequest);
    }
}
