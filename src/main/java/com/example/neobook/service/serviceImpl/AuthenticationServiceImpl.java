package com.example.neobook.service.serviceImpl;

import com.example.neobook.dto.AuthResponse;
import com.example.neobook.dto.SignInRequest;
import com.example.neobook.dto.SignUpRequest;
import com.example.neobook.entity.User;
import com.example.neobook.enums.Role;
import com.example.neobook.exceptions.AlreadyExistException;
import com.example.neobook.repository.UserRepository;
import com.example.neobook.security.jwt.JwtService;
import com.example.neobook.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;


    @Override
    public AuthResponse register(SignUpRequest signUpRequest) {
        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            throw new AlreadyExistException("User with email" + signUpRequest.getEmail() + " already exists in database");
        }
        User user = new User();
        user.setEmail(signUpRequest.getEmail());
        user.setRole(Role.USER);
        user.setPhone(signUpRequest.getPhone());
        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        userRepository.save(user);
        String token = jwtService.generateToken(signUpRequest.getEmail());
        return new AuthResponse(user.getEmail(), token, user.getRole());

    }

    @Override
    public AuthResponse login(SignInRequest signInRequest) {
        User user = userRepository.getUserByEmail(signInRequest.getEmail()).orElseThrow(() -> new UsernameNotFoundException("User with email " + signInRequest.getEmail() + " doesn't exists"));
        if (signInRequest.getEmail().isBlank()) {
            throw new BadCredentialsException("Email is blank!");
        }
        if (!passwordEncoder.matches(signInRequest.getPassword(), user.getPassword())) {
            throw new BadCredentialsException("Incorrect password");
        }
        String token = jwtService.generateToken(user.getUsername());
        return new AuthResponse(user.getEmail(), token, user.getRole());
    }
}
