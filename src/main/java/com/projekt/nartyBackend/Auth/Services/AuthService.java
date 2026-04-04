package com.projekt.nartyBackend.Auth.Services;

import com.projekt.nartyBackend.Auth.Entities.Role;
import com.projekt.nartyBackend.Auth.Mappers.UserMapper;
import com.projekt.nartyBackend.Auth.Repositories.UserRepository;
import com.projekt.nartyBackend.Auth.dtos.RegistationDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;


}
