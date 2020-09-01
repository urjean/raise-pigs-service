package com.raise.pigs.service.config.auth;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.raise.pigs.service.entity.SysUser;
import com.raise.pigs.service.service.impl.SysUserServiceImpl;
import com.raise.pigs.service.utils.result.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
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
    @Autowired
    private SysUserServiceImpl sysUserService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        // 生成权限字符串
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        StringBuilder builder = new StringBuilder();
        for (GrantedAuthority authority : authorities) {
            builder.append(authority.getAuthority())
                    .append(",");
        }

        // 查询用户信息
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        wrapper.eq("account", authentication.getName());
        wrapper.eq("valid", 1);
        SysUser sysUser = sysUserService.getOne(wrapper);

        HashMap<String, Object> map = new HashMap<>();
        map.put("userInfo", sysUser);
        map.put("token", JwtTokenUtils.generateToken(authentication.getName(), new ObjectMapper().writeValueAsString(sysUser), builder.toString()));

        httpServletResponse.setContentType("application/json;charset=utf-8");
        httpServletResponse.getWriter().write(new ObjectMapper().writeValueAsString(ResultUtils.success(map)));
    }


}
