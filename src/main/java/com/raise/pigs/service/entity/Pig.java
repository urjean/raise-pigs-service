package com.raise.pigs.service.entity;

import java.time.LocalDate;
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
 * 猪表
 * </p>
 *
 * @author osumg
 * @since 2020-08-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Pig implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @JsonSerialize(using = LongToString.class)
    @JsonDeserialize(using = StringToLong.class)
    private Long id;

    /**
     * 编号
     */
    private Integer number;

    /**
     * 种类主键
     */
    @JsonSerialize(using = LongToString.class)
    @JsonDeserialize(using = StringToLong.class)
    private Long kindId;

    /**
     * 年龄（月）
     */
    private Integer age;

    /**
     * 性别（0：公；1：母）
     */
    private Integer gender;

    /**
     * 健康状态（0：不健康；1：健康）
     */
    private Integer status;

    /**
     * 检查情况（0：未检查；1：检查）
     */
    private Integer inspect;

    /**
     * 出售情况（0：未售出；1：售出）
     */
    private Integer sale;

    /**
     * 怀孕（0：否；1：是）
     */
    private Integer pregnant;

    /**
     * 预计生产日期
     */
    private LocalDate expectBirthDate;

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
