package com.raise.pigs.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.raise.pigs.service.entity.SysUser;
import com.raise.pigs.service.mapper.SysUserMapper;
import com.raise.pigs.service.utils.RedisUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ServiceApplicationTests {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private RedisUtils redisUtils;

    @Test
    void contextLoads() {
        Page<SysUser> page = new Page<>();
        page.setCurrent(1);
        page.setSize(10);
        SysUser sysUser = new SysUser();
        sysUser.setAccount("os");
        IPage<SysUser> allUser = sysUserMapper.findUserBy(page, sysUser);
        System.out.println(allUser);
    }

    @Test
    void customTest() {
        System.out.println(redisUtils.hasKey("number"));
        System.out.println(redisUtils.get("number"));

        redisUtils.set("mykey","this is mykey");
        System.out.println(redisUtils.get("mykey"));
    }
}
