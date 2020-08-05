package com.raise.pigs.service.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 员工表
 * </p>
 *
 * @author osumg
 * @since 2020-08-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Staff implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long staffId;

    /**
     * 员工姓名
     */
    private String staffName;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 员工性别（0：男；1：女）
     */
    private Boolean gender;

    /**
     * 出生日期
     */
    private LocalDate birthday;

    /**
     * 职位主键
     */
    private Long positionId;

    /**
     * 个人薪资调整
     */
    private BigDecimal adjustSalary;

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
