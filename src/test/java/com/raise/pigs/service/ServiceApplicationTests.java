package com.raise.pigs.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.raise.pigs.service.entity.SysUser;
import com.raise.pigs.service.mapper.SysUserMapper;
import com.raise.pigs.service.utils.snowflake.SnowflakeUtils;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

@SpringBootTest
class ServiceApplicationTests {

    @Autowired
    private SysUserMapper sysUserMapper;

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
        HashMap<Object, Object> map = new HashMap<>();
        Integer a = (Integer) map.get("dsajkdfj");
        System.out.println(a);
    }
}
