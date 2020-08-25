package com.raise.pigs.service.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.raise.pigs.service.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author osumg
 * @since 2020-08-20
 */
public interface ISysUserService extends IService<SysUser> {
    IPage<SysUser> findAllUser(Page<SysUser> page);

    IPage<SysUser> findUserBy(Page<SysUser> page, SysUser sysUser);
}
