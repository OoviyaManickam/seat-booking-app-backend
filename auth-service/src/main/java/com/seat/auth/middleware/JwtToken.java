package com.seat.auth.middleware;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.seat.auth.entity.AuthEntity;
import com.seat.auth.model.TokenModel;

import io.jsonwebtoken.Jwts;

@Component
public class JwtToken {
    private static final SecretKey SECRET_KEY = Jwts.SIG.HS512.key().build();
    private static final long EXPIRATION_TIME = 7200000;

    public String generateToken(AuthEntity user) {
        TokenModel token = new TokenModel();
        BeanUtils.copyProperties(user, token);
        return Jwts.builder()
                .subject(token.toString())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SECRET_KEY)
                .compact();
    }

    public TokenModel getTokenModelfromToken(String token) {
        TokenModel tokenModel = new TokenModel();
        tokenModel.parse(Jwts.parser()
                .verifyWith(SECRET_KEY)
                .build().parseSignedClaims(token.subSequence(0, token.length())).getPayload().getSubject());
        return tokenModel;
    }
}

