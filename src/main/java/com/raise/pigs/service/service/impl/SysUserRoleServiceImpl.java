package com.raise.pigs.service.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.raise.pigs.service.entity.SysUser;
import com.raise.pigs.service.entity.SysUserRole;
import com.raise.pigs.service.mapper.SysUserMapper;
import com.raise.pigs.service.mapper.SysUserRoleMapper;
import com.raise.pigs.service.service.ISysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户角色关系表 服务实现类
 * </p>
 *
 * @author osumg
 * @since 2020-08-20
 */
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements ISysUserRoleService {

}
