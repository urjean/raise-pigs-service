package com.raise.pigs.service.utils;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.raise.pigs.service.config.auth.JwtTokenUtils;

import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author osumg
 * @since 2020/8/31
 */
public class WrapperUtils {
    private WrapperUtils() {
    }

    public static <T> void setUpdateTimeAndCreator(UpdateWrapper<T> wrapper, String authorization) {
        wrapper.set("update_time", LocalDateTime.now())
                .set("update_by", JwtTokenUtils.getUserId(authorization));
    }

}
