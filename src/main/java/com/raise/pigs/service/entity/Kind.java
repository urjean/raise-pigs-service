package com.raise.pigs.service.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.raise.pigs.service.utils.LongToString;
import com.raise.pigs.service.utils.StringToLong;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 种类表
 * </p>
 *
 * @author osumg
 * @since 2020-08-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Kind implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @JsonSerialize(using = LongToString.class)
    @JsonDeserialize(using = StringToLong.class)
    private Long id;

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
    @JsonSerialize(using = LongToString.class)
    @JsonDeserialize(using = StringToLong.class)
    private Long pigstyId;

    /**
     * 饲料主键
     */
    @JsonSerialize(using = LongToString.class)
    @JsonDeserialize(using = StringToLong.class)
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
    @JsonSerialize(using = LongToString.class)
    @JsonDeserialize(using = StringToLong.class)
    private Long createBy;

    /**
     * 修改人
     */
    @JsonSerialize(using = LongToString.class)
    @JsonDeserialize(using = StringToLong.class)
    private Long updateBy;


}
