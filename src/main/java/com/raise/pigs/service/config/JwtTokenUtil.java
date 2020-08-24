package com.raise.pigs.service.config;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author osumg
 * @since 2020/8/21
 */
public class JwtTokenUtil {

    private JwtTokenUtil() {
    }

    public static String generateToken(String subject) {
        return Jwts.builder()
                .setClaims(null)
                .setSubject(subject)
                // 设置过期时间
                .setExpiration(new Date(System.currentTimeMillis() + 10 * 1000))
                .signWith(SignatureAlgorithm.HS512, "_salt_osumg")
                .compact();
    }

    public static String parseToken(String token) {
        return Jwts.parser()
                .setSigningKey("_salt_osumg")
                .parseClaimsJws(token).getBody().getSubject();
    }
}
