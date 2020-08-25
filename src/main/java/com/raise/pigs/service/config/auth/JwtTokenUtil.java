package com.raise.pigs.service.config.auth;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * <p>
 * token工具类
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
                // 设置过期时间 30天
                .setExpiration(new Date(System.currentTimeMillis() + 2592000000L))
                .signWith(SignatureAlgorithm.HS512, "_salt_osumg")
                .compact();
    }

    public static String parseToken(String token) {
        return Jwts.parser()
                .setSigningKey("_salt_osumg")
                .parseClaimsJws(token).getBody().getSubject();
    }
}
