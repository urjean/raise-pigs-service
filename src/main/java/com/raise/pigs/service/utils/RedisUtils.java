package com.raise.pigs.service.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * </p>
 *
 * @author osumg
 * @since 2020/9/2
 */
@Component
public class RedisUtils {
    /**
     * 1 StringRedisTemplate.opsForValue().* //操作String字符串类型
     * 2 StringRedisTemplate.delete(key/collection) //根据key/keys删除
     * 3 StringRedisTemplate.opsForList().*  //操作List类型
     * 4 StringRedisTemplate.opsForHash().*  //操作Hash类型
     * 5 StringRedisTemplate.opsForSet().*  //操作set类型
     * 6 StringRedisTemplate.opsForZSet().*  //操作有序set
     */
    @Autowired
    private StringRedisTemplate template;

    /**
     * 是否存在key
     * @param key
     * @return
     */
    public Boolean hasKey(String key) {
        return template.hasKey(key);
    }

    /**
     * 设置指定 key 的值
     * @param key
     * @param value
     */
    public void set(String key, String value) {
        template.opsForValue().set(key, value);
    }

    /**
     * 获取指定 key 的值
     * @param key
     * @return
     */
    public String get(String key) {
        return template.opsForValue().get(key);
    }


}
