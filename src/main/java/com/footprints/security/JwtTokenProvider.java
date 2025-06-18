package com.footprints.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenProvider {

    @Value("${jwt.secret}")
    private String jwtSecret;
    @Value("${jwt.expiration-milliseconds}")
    private long jwtExpirationMilliseconds;

    public String generateToken(Authentication authentication) {
        final String username = authentication.getName();
        final Date currentDate = new Date();
        final Date expireDate = new Date(currentDate.getTime() + jwtExpirationMilliseconds);

        return Jwts.builder()
                .subject(username)
                .issuedAt(new Date())
                .expiration(expireDate)
                .signWith(getKey())
                .compact();
    }

    private Key getKey() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
    }

    public String getUsername(String token) {
        return Jwts.parser()
                .verifyWith((SecretKey) getKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

    public boolean validateToken(String token) {
        Jwts.parser()
                .verifyWith((SecretKey) getKey())
                .build()
                .parse(token);
        return true;
    }
}