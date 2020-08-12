package com.raise.pigs.service.utils.snowflake;

/**
 * <p>
 * id生成工具类
 * </p>
 *
 * @author osumg
 * @since 2020/8/10
 */
public class SnowflakeUtils {
    private static final IdWorker idWorker = new IdWorker(1, 1, 1);

    private SnowflakeUtils() {
    }

    public static Long createId() {
        return idWorker.nextId();
    }
}
