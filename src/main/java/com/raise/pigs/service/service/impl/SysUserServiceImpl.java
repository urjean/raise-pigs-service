package com.raise.pigs.service.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.raise.pigs.service.entity.SysUser;
import com.raise.pigs.service.mapper.SysUserMapper;
import com.raise.pigs.service.service.ISysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author osumg
 * @since 2020-08-20
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {
    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public IPage<SysUser> findAllUser(Page<SysUser> page) {
        return sysUserMapper.findAllUser(page);
    }

    @Override
    public IPage<SysUser> findUserBy(Page<SysUser> page, SysUser sysUser){
        return sysUserMapper.findUserBy(page,sysUser);
    }
}
