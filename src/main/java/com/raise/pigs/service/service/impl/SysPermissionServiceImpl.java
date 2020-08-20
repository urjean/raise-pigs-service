package com.raise.pigs.service.service.impl;

import com.raise.pigs.service.entity.SysPermission;
import com.raise.pigs.service.mapper.SysPermissionMapper;
import com.raise.pigs.service.service.ISysPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 权限表 服务实现类
 * </p>
 *
 * @author osumg
 * @since 2020-08-20
 */
@Service
public class SysPermissionServiceImpl extends ServiceImpl<SysPermissionMapper, SysPermission> implements ISysPermissionService {
    @Autowired
    private SysPermissionMapper sysPermissionMapper;

    @Override
    public List<SysPermission> selectPermissionByUser(Long userId) {
        return sysPermissionMapper.selectPermissionByUser(userId);
    }
}
