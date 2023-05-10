package com.example.talentmanagemnet.config.security.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class JWTUtils {
    public static Long expiry = TimeUnit.DAYS.toMillis(7);
    public static String secretKey = "qwertyuiop1lkjhgfdsa2zxcvbnm3mnbvcxz4asdfghjkl5poiuytrewq";

    public static Date getExpiry() {
        return new Date(System.currentTimeMillis() + expiry);
    }


    public static Algorithm getAlgorithm() {
        return Algorithm.HMAC256(secretKey.getBytes());
    }

    public static JWTVerifier getVerifier() {
        return JWT.require(getAlgorithm()).build();
    }
}
