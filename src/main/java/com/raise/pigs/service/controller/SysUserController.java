package com.raise.pigs.service.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.raise.pigs.service.entity.SysUser;
import com.raise.pigs.service.service.ISysUserService;
import com.raise.pigs.service.utils.result.ResultBody;
import com.raise.pigs.service.utils.result.ResultUtils;
import com.raise.pigs.service.utils.snowflake.SnowflakeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
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
    @Autowired
    private ISysUserService iSysUserService;

    /**
     * 根据账号查询用户信息
     *
     * @param map
     * @return
     */
    @PostMapping("/find-by")
    public ResultBody<Object> findBy(@RequestBody Map<String, Object> map) {
        // todo 参数校验
        Page<SysUser> page = new Page<>();
        page.setCurrent((Integer) map.get("current"));
        page.setSize((Integer) map.get("size"));
        SysUser sysUser = new SysUser();
        sysUser.setAccount((String) map.get("account"));
        return ResultUtils.success(iSysUserService.findUserBy(page, sysUser));
    }

    /**
     * 添加用户
     *
     * @param sysUser 用户实体
     * @return 成功与否
     */
    @PostMapping("/add")
    public ResultBody<Object> add(@RequestBody SysUser sysUser) {
        sysUser.setId(SnowflakeUtils.createId());
        sysUser.setPassword(new BCryptPasswordEncoder().encode(sysUser.getPassword()));
        sysUser.setCreateTime(LocalDateTime.now());
        iSysUserService.save(sysUser);
        return ResultUtils.successNoData();
    }

    /**
     * 查询所有有效用户
     *
     * @param current 当前页
     * @param size    每页显示大小
     * @return SysUser
     */
    @GetMapping("/find-user")
    public ResultBody<Object> findAllUser(Integer current, Integer size) {
        Page<SysUser> page = new Page<>();
        page.setCurrent(current);
        page.setSize(size);
        return ResultUtils.success(iSysUserService.findAllUser(page));
    }

    /**
     * 根据账号查询用户是否存在
     *
     * @param account 账号
     * @return {
     * hasOne:boolean 是否存在
     * }
     */
    @GetMapping("/find/{account}")
    public ResultBody<Object> findAccount(@PathVariable String account) {
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        wrapper.eq("account", account);
        SysUser sysUser = iSysUserService.getOne(wrapper);
        HashMap<String, Object> map = new HashMap<>();
        map.put("hasOne", !(sysUser == null));
        return ResultUtils.success(map);
    }
}
