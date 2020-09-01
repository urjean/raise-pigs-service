package com.raise.pigs.service.config.auth;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.raise.pigs.service.config.globalException.ServiceException;
import com.raise.pigs.service.entity.SysUser;
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
public class JwtTokenUtils {

    // 设置过期时间 30天
    public static final long EXPIRITION = 2592000000L;

    public static final String APPSECRET_KEY = "_salt_osumg";

    public static final String AUTHORITY_KEY = "role";

    public static final String USER_INFO = "USER_INFO";

    private JwtTokenUtils() {
    }

    /**
     * 生成token
     *
     * @param subject
     * @param userInfo
     * @param authentication
     * @return
     */
    public static String generateToken(String subject, String userInfo, String authentication) {
        return Jwts.builder()
                .claim(USER_INFO, userInfo)
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

    /**
     * 获取用户信息
     *
     * @param authorization
     * @return
     */
    public static SysUser getUserInfo(String authorization) {
        // 6 为 "Bearer ".length()
        String token = authorization.substring(6);
        String userInfoStr = (String) Jwts.parser()
                .setSigningKey(APPSECRET_KEY)
                .parseClaimsJws(token).getBody().get(USER_INFO);
        ObjectMapper mapper = new ObjectMapper();

        // 解决 localDateTime 转换异常
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper.registerModule(new JavaTimeModule());

        SysUser sysUser;
        try {
            sysUser = mapper.readValue(userInfoStr, SysUser.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new ServiceException("token错误");
        }

        return sysUser;
    }

    /**
     * 获取用户id
     *
     * @param authorization
     * @return
     */
    public static Long getUserId(String authorization) {
        return getUserInfo(authorization).getId();
    }
}
