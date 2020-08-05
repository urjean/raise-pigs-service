package com.raise.pigs.service.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 采购记录
 * </p>
 *
 * @author osumg
 * @since 2020-08-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Purchase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long purchaseId;

    /**
     * 采购类型
     */
    private Integer type;

    /**
     * 类型主键
     */
    private Long typeId;

    /**
     * 数量
     */
    private Integer quantity;

    /**
     * 单价
     */
    private BigDecimal unitPrice;

    /**
     * 总价
     */
    private BigDecimal totalPrice;

    /**
     * 采购日期
     */
    private LocalDate purchaseDate;

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
