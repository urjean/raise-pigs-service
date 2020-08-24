package com.raise.pigs.service.config.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.raise.pigs.service.utils.result.ResultBody;
import com.raise.pigs.service.utils.result.ResultEnum;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>
 * 无权访问
 * </p>
 *
 * @author osumg
 * @since 2020/8/20
 */
@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        httpServletResponse.setContentType("application/json;charset=utf-8");
        ResultBody<Object> resultBody = new ResultBody<>(ResultEnum.NO_AUTH);
        httpServletResponse.getWriter().write(new ObjectMapper().writeValueAsString(resultBody));
    }
}
