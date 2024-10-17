package com.hhplus.hhplus3week.app.common;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtProvider {


    @Value("${auth.jwt.accessTokenExpirationHour}")
    private long EXPIRATION_TIME;

    private final SecretKey secretKey;

    public JwtProvider(@Value("${auth.jwt.secret}") String secretKey) {
        this.secretKey = Keys.hmacShaKeyFor(Decoders.BASE64URL.decode(secretKey));
    }


    // JWT 생성 메소드
    public String createAccessToken(Long userId) {
        return Jwts.builder()
                .claim("userId", userId)
                .subject(String.valueOf(userId))
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(secretKey)
                .compact();
    }

    // JWT에서 사용자 이름 추출 메소드
    public Long getUserIdFromToken(String token) {
        Claims claims =
                Jwts.parser().verifyWith(secretKey)
                        .build()
                        .parseSignedClaims(token)
                        .getPayload();
        return Long.valueOf(claims.getSubject());
    }

    // JWT 유효성 검사 메소드
    public boolean validateToken(String token, Long userId) {
        Long extractedUserId = getUserIdFromToken(token);
        return (extractedUserId.equals(userId) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        Date expiration = Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getExpiration();
        return expiration.before(new Date());
    }

}
