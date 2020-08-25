package com.raise.pigs.service.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author osumg
 * @since 2020/8/25
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysUserVo implements Serializable {
    /**
     * 账号
     */
    private String account;

    /**
     * 每页显示大小
     */
    private Integer size;

    /**
     * 当前页码
     */
    private Integer current;
}
