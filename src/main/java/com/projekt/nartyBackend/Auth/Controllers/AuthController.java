package com.projekt.nartyBackend.Auth.Controllers;

import com.projekt.nartyBackend.Auth.Entities.Role;
import com.projekt.nartyBackend.Auth.Mappers.UserMapper;
import com.projekt.nartyBackend.Auth.Repositories.UserRepository;
import com.projekt.nartyBackend.Auth.dtos.JwtResponse;
import com.projekt.nartyBackend.Auth.dtos.LoginDto;
import com.projekt.nartyBackend.Auth.dtos.RegistationDto;
import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<?> login
            (@Valid @RequestBody RegistationDto request) {
        if(userRepository.findByEmail((request.getEmail())).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("An account with this email is already registered.");
        }

        var user = userMapper.toEntity(request);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);

        var savedUser = userRepository.save(user);

        return ResponseEntity.ok().body(userMapper.toDto(savedUser));
    }
}
