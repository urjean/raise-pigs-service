package com.raise.pigs.service.config.auth;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.raise.pigs.service.config.globalException.ServiceException;
import com.raise.pigs.service.entity.SysPermission;
import com.raise.pigs.service.entity.SysUser;
import com.raise.pigs.service.service.ISysPermissionService;
import com.raise.pigs.service.service.ISysUserService;
import com.raise.pigs.service.utils.result.ResultEnum;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author osumg
 * @since 2020/8/20
 */
@Component
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private ISysUserService iSysUserService;
    @Autowired
    private ISysPermissionService iSysPermissionService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        if (StringUtils.isBlank(s)) {
            throw new ServiceException(ResultEnum.PARAM_NOT_MATCH);
        }
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        wrapper.eq("account", s);
        wrapper.eq("valid", 1);
        SysUser sysUser = iSysUserService.getOne(wrapper);

        if (sysUser == null) {
            throw new ServiceException("用户不存在");
        }

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        if (sysUser != null) {
            //获取该用户所拥有的权限
            List<SysPermission> sysPermissions = iSysPermissionService.selectPermissionByUser(sysUser.getId());
            // 声明用户授权
            sysPermissions.forEach(sysPermission -> {
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(sysPermission.getPermissionCode());
                grantedAuthorities.add(grantedAuthority);
            });
        }
        return new User(sysUser.getAccount(), sysUser.getPassword(), grantedAuthorities);

    }
}
