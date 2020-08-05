package com.raise.pigs.service.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 饲料表
 * </p>
 *
 * @author osumg
 * @since 2020-08-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Feed implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long feedId;

    /**
     * 饲料名称
     */
    private String feedName;

    /**
     * 数量
     */
    private Integer quantity;

    /**
     * 生产日期
     */
    private LocalDate produceDate;

    /**
     * 有效期（月）
     */
    private Integer validMonth;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 创建人
     */
    private Long createBy;

    /**
     * 修改人
     */
    private Long updateBy;


}
