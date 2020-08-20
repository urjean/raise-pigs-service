package com.raise.pigs.service.mapper;

import com.raise.pigs.service.entity.SysPermission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 权限表 Mapper 接口
 * </p>
 *
 * @author osumg
 * @since 2020-08-20
 */
public interface SysPermissionMapper extends BaseMapper<SysPermission> {
    /**
     * 查询用户的权限列表
     *
     * @param userId
     * @return
     */
    List<SysPermission> selectPermissionByUser(Long userId);
}
