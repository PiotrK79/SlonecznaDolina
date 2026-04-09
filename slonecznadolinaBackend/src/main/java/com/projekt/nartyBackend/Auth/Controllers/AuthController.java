package com.projekt.nartyBackend.Auth.Controllers;

import com.projekt.nartyBackend.Auth.Entities.Role;
import com.projekt.nartyBackend.Auth.Entities.User;
import com.projekt.nartyBackend.Auth.Mappers.UserMapper;
import com.projekt.nartyBackend.Auth.Repositories.UserRepository;
import com.projekt.nartyBackend.Auth.Services.JwtService;
import com.projekt.nartyBackend.Auth.dtos.JwtResponse;
import com.projekt.nartyBackend.Auth.dtos.LoginDto;
import com.projekt.nartyBackend.Auth.dtos.RegistationDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @PostMapping("/register")
    public ResponseEntity<?> register
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

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@Valid @RequestBody LoginDto request){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getEmail(), request.getPassword()
        ));

        var user = userRepository.findByEmail(request.getEmail()).orElse(null);

        var accessToken = jwtService.generateAccessToken(user);

        return ResponseEntity.ok(new JwtResponse(accessToken.toString()));
    }

    @PostMapping("/refresh")
    public ResponseEntity<JwtResponse> refresh(@CookieValue(value = "refreshToken") String refreshToken){
        var jwt = jwtService.parseToken(refreshToken);
        if(jwt == null || jwt.isExpired()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        var user = userRepository.findById(jwt.getId()).orElseThrow();
        var accessToken = jwtService.generateAccessToken(user);

        return ResponseEntity.ok(new JwtResponse(accessToken.toString()));
    }

    @GetMapping("/me")
    public ResponseEntity<User> me(){
        var authentication =  SecurityContextHolder.getContext().getAuthentication();
        var userId = (Long) authentication.getPrincipal();

        var user = userRepository.findById(userId).orElse(null);
        if(user == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(user);
    }
}
