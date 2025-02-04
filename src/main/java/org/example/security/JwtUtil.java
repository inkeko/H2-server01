package org.example.security;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    // A titkos kulcsot az application.properties-ből olvassuk be.
    // Győződj meg róla, hogy a jwt.secret értéke base64-kódolt és legalább 256 bit hosszú!
    private final Key key;

    // Token érvényessége: 10 óra (példa)
    private final long JWT_EXPIRATION = 10 * 60 * 60 * 1000;

    public JwtUtil(@Value("${jwt.secret}") String base64Secret) {
        // A base64 kódolt titkos kulcs dekódolása és Key objektummá alakítása
        this.key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(base64Secret));
    }

    // Token generálása adott felhasználónév alapján
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + JWT_EXPIRATION))
                .signWith(key, SignatureAlgorithm.HS256)
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
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
