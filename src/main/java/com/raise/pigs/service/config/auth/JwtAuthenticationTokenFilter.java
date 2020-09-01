package com.raise.pigs.service.config.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.raise.pigs.service.utils.result.ResultEnum;
import com.raise.pigs.service.utils.result.ResultUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * <p>
 * jwt验证
 * </p>
 *
 * @author osumg
 * @since 2020/8/21
 */
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String authToken = authHeader.substring("Bearer ".length());
            String username = null;
            try {
                username = JwtTokenUtils.getUsername(authToken);
            } catch (Exception e) {
                response.setContentType("application/json;charset=utf-8");
                response.getWriter().write(new ObjectMapper().writeValueAsString(ResultUtils.error(ResultEnum.TOKEN_EXPIRATION)));
                return;
            }

            if (!StringUtils.isEmpty(username)) {
                List<GrantedAuthority> authorities = AuthorityUtils.commaSeparatedStringToAuthorityList((String) JwtTokenUtils.getAuthority(authToken));
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, null, authorities);
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }

        chain.doFilter(request, response);
    }
}
