package com.raise.pigs.service.controller;

import com.raise.pigs.service.config.globalException.ServiceException;
import com.raise.pigs.service.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *
 * </p>
 *
 * @author osumg
 * @since 2020/8/21
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private RedisUtils redisUtils;

    @GetMapping("/s")
    public String getS() {
        return "test-s";
    }

    @GetMapping("/get/{key}")
    public String getRedis(@PathVariable String key) {
        return redisUtils.get(key);
    }

    @PostMapping("/set")
    public void setRedis(String key, String value) {
        redisUtils.set(key, value);
    }

}
