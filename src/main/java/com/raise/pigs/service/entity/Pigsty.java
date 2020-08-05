package com.raise.pigs.service.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 猪圈表
 * </p>
 *
 * @author osumg
 * @since 2020-08-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Pigsty implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long pigstyId;

    /**
     * 编号
     */
    private Integer number;

    /**
     * 最大容量
     */
    private Integer maxCapacity;

    /**
     * 实际容量
     */
    private Integer realCapacity;

    /**
     * 清洁日期
     */
    private LocalDate cleanDate;

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
