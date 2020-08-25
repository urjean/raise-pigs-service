package com.raise.pigs.service.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.raise.pigs.service.entity.SysPermission;
import com.raise.pigs.service.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author osumg
 * @since 2020-08-20
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

    IPage<SysUser> findAllUser(Page<SysUser> page);

    IPage<SysUser> findUserBy(Page<SysUser> page, SysUser sysUser);

}
