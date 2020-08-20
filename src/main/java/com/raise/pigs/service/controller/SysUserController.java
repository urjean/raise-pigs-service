package com.raise.pigs.service.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.raise.pigs.service.entity.SysUser;
import com.raise.pigs.service.service.ISysUserService;
import com.raise.pigs.service.utils.result.ResultBody;
import com.raise.pigs.service.utils.result.ResultUtils;
import com.raise.pigs.service.utils.snowflake.SnowflakeUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author osumg
 * @since 2020-08-20
 */
@RestController
@RequestMapping("/service/sys-user")
public class SysUserController {
    public static final Logger LOGGER = LoggerFactory.getLogger(SysUserController.class);
    @Autowired
    private ISysUserService iSysUserService;

    @GetMapping("/find-all")
    public ResultBody<List<SysUser>> findAll() {
        return ResultUtils.success(iSysUserService.list());
    }

    @PostMapping("/find-by")
    public ResultBody<List<SysUser>> findBy(@RequestBody Map<String, String> reqMap) {
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        if(!StringUtils.isBlank(reqMap.get("account"))){
            wrapper.like("account", reqMap.get("account"));
        }
        return ResultUtils.success(iSysUserService.list(wrapper));
    }

    @PostMapping("/add")
    public ResultBody<Object> add(@RequestBody SysUser sysUser){
        sysUser.setCreateTime(LocalDateTime.now());
        return ResultUtils.successNoData();
    }

}
