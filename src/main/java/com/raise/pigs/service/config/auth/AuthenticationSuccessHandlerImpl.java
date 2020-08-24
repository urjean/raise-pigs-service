package com.raise.pigs.service.config.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.raise.pigs.service.config.JwtTokenUtil;
import com.raise.pigs.service.utils.result.ResultUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * <p>
 * 登录成功
 * </p>
 *
 * @author osumg
 * @since 2020/8/20
 */
@Component
public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        httpServletResponse.setContentType("application/json;charset=utf-8");

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String token = JwtTokenUtil.generateToken(userDetails.getUsername());
        HashMap<String, String> map = new HashMap<>();
        map.put("token", token);
        httpServletResponse.getWriter().write(new ObjectMapper().writeValueAsString(ResultUtils.success(map)));
    }


}
