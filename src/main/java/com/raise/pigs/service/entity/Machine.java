package com.raise.pigs.service.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 设备表
 * </p>
 *
 * @author osumg
 * @since 2020-08-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Machine implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long machineId;

    /**
     * 设备名称
     */
    private String machineName;

    /**
     * 用途
     */
    private String purpose;

    /**
     * 状态（0：报废；1：完好；2：待维修）
     */
    private Boolean status;

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
