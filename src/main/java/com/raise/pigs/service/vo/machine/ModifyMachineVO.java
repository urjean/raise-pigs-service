package com.raise.pigs.service.vo.machine;

import com.raise.pigs.service.vo.BaseModify;
import lombok.Data;

import javax.validation.constraints.Size;

/**
 * <p>
 *
 * </p>
 *
 * @author osumg
 * @since 2020/8/31
 */
@Data
public class ModifyMachineVO extends BaseModify {
    /**
     * 设备名称
     */
    @Size(max = 40, message = "设备名称长度不能超过40")
    private String machineName;

    /**
     * 用途
     */
    @Size(max = 100, message = "用途描述长度不能超过100")
    private String purpose;
}
