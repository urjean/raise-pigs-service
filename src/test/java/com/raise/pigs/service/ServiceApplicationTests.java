package com.raise.pigs.service;

import com.raise.pigs.service.utils.snowflake.SnowflakeUtils;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ServiceApplicationTests {

    @Test
    void contextLoads() {
        System.out.println(SnowflakeUtils.createId());
    }

}
