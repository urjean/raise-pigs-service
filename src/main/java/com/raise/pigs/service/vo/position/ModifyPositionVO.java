package com.raise.pigs.service.vo.position;

import com.raise.pigs.service.vo.BaseModify;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

/**
 * <p>
 *
 * </p>
 *
 * @author osumg
 * @since 2020/8/31
 */
@Data
public class ModifyPositionVO extends BaseModify {
    /**
     * 职位名
     */
    @Size(max = 40, message = "职位名长度不能超过40")
    private String positionName;

    /**
     * 薪资
     */
    @Min(value = 0, message = "薪资不能小于0")
    private BigDecimal salary;
}
