package com.raise.pigs.service.config.auth;

import com.raise.pigs.service.config.globalException.ServiceException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * token工具类
 * </p>
 *
 * @author osumg
 * @since 2020/8/21
 */
public class JwtTokenUtil {

    // 设置过期时间 30天
    public static final long EXPIRITION = 2592000000L;

    public static final String APPSECRET_KEY = "_salt_osumg";

    public static final String AUTHORITY_KEY = "role";

    private JwtTokenUtil() {
    }

    /**
     * 生成token
     *
     * @param subject
     * @param authentication
     * @return
     */
    public static String generateToken(String subject, String authentication) {
        return Jwts.builder()
                .claim(AUTHORITY_KEY, authentication)
                .setSubject(subject)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRITION))
                .signWith(SignatureAlgorithm.HS512, APPSECRET_KEY)
                .compact();
    }

    /**
     * 获取用户名
     *
     * @param token
     * @return
     */
    public static String getUsername(String token) {
        return Jwts.parser()
                .setSigningKey(APPSECRET_KEY)
                .parseClaimsJws(token).getBody().getSubject();
    }

    /**
     * 获取用户权限
     *
     * @param token
     * @return
     */
    public static Object getAuthority(String token) {
        return Jwts.parser()
                .setSigningKey(APPSECRET_KEY)
                .parseClaimsJws(token).getBody().get(AUTHORITY_KEY);
    }
}
