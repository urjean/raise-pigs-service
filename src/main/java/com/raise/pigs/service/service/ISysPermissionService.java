package com.raise.pigs.service.service;

import com.raise.pigs.service.entity.SysPermission;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 权限表 服务类
 * </p>
 *
 * @author osumg
 * @since 2020-08-20
 */
public interface ISysPermissionService extends IService<SysPermission> {

    /**
     * 查询用户的权限列表
     *
     * @param userId
     * @return
     */
    List<SysPermission> selectPermissionByUser(Long userId);

}
