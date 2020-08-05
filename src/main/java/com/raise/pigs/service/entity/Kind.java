package com.raise.pigs.service.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 种类表
 * </p>
 *
 * @author osumg
 * @since 2020-08-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Kind implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long kindId;

    /**
     * 种类名称
     */
    private String kindName;

    /**
     * 种类价格
     */
    private BigDecimal kindPrice;

    /**
     * 猪圈主键
     */
    private Long pigstyId;

    /**
     * 饲料主键
     */
    private Long feedId;

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
