package org.example.security;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    // Egy titkos kulcs, ezt természetesen biztonságosan kell tárolni (pl. környezeti változóként)
    private final String SECRET_KEY = "mysecretkey123456";

    // Token érvényessége: 10 óra (példa)
    private final long JWT_EXPIRATION = 10 * 60 * 60 * 1000;

    // Token generálása adott felhasználónév alapján
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + JWT_EXPIRATION))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    // Tokenből kinyerjük a felhasználónevet
    public String extractUsername(String token) {
        return getClaims(token).getSubject();
    }

    // Ellenőrizzük, hogy a token érvényes-e
    public boolean validateToken(String token, String username) {
        String extractedUsername = extractUsername(token);
        return (extractedUsername.equals(username) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        Date expiration = getClaims(token).getExpiration();
        return expiration.before(new Date());
    }

    private Claims getClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }
}

