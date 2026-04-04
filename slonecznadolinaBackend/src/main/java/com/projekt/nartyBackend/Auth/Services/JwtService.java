package com.projekt.nartyBackend.Auth.Services;

import com.projekt.nartyBackend.Auth.Entities.User;
import com.projekt.nartyBackend.Auth.JwtConfig;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@AllArgsConstructor
@Service
public class JwtService {
    private final JwtConfig jwtConfig;

    public Jwt generateAccessToken(User user) {
        return generateToken(user, jwtConfig.getAccessTokenValiditySeconds());
    }

    private Jwt generateToken(User user, long expiration){
        var claims = Jwts.claims()
                .subject(user.getId().toString())
                .add("email", user.getEmail())
                .add("role", user.getRole())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + expiration * 1000))
                .build();
        return new Jwt(claims, jwtConfig.getSecret());
    }

    private Claims getClaims(String token){
        return Jwts.parser()
                .verifyWith(jwtConfig.getSecret())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public Jwt parseToken(String token){
        try{
            var claims = getClaims(token);
            return new Jwt(claims, jwtConfig.getSecret());
        }catch(Exception e){
            return null;
        }
    }


}
