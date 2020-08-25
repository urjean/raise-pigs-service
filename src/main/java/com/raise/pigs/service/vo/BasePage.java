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
public class BasePage implements Serializable {
    /**
     * 每页显示大小
     */
    private long size;

    /**
     * 当前页码
     */
    private long current;

    /**
     * 最大页数
     */
    private long maxCurrent;

    /**
     * 数据总条数
     */
    private long total;
}
