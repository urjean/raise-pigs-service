package com.raise.pigs.service.config.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.raise.pigs.service.utils.result.ResultBody;
import com.raise.pigs.service.utils.result.ResultEnum;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>
 * 登录失败
 * </p>
 *
 * @author osumg
 * @since 2020/8/20
 */
@Component
public class AuthenticationFailureHandlerImpl implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.setContentType("application/json;charset=utf-8");
        ResultBody<Object> resultBody = new ResultBody<>(ResultEnum.FAIL_LOGIN);
        httpServletResponse.getWriter().write(new ObjectMapper().writeValueAsString(resultBody));
    }
}
