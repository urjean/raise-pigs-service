package com.raise.pigs.service.config.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.raise.pigs.service.utils.result.ResultBody;
import com.raise.pigs.service.utils.result.ResultEnum;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
        ResultBody<Object> resultBody = new ResultBody<>(ResultEnum.SUCCESS_LOGIN);
        httpServletResponse.getWriter().write(new ObjectMapper().writeValueAsString(resultBody));
    }


}
