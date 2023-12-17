package com.example.neobook.dto;

import com.example.neobook.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {
    private String email;
    private String jwt;
    private Role role;

}
