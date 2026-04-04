package com.projekt.nartyBackend.Auth.Services;

import com.projekt.nartyBackend.Auth.Entities.Role;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import java.security.Key;
import java.util.Date;

public class Jwt {
    private Claims claims;
    private Key secret;

    public Jwt(Claims claims, Key secret) {
        this.claims = claims;
        this.secret = secret;
    }

    public Boolean isExpired() {
        try {
            return claims.getExpiration().before(new Date());
        }catch (Exception e) {
            return true;
        }
    }

    public Long getId() {
        return Long.valueOf( claims.getSubject());
    }

    public Role getRole() {
        return Role.valueOf(claims.get("role", String.class));
    }

    public String toString(){
        return Jwts.builder().claims(claims).signWith(secret).compact();
    }

}
