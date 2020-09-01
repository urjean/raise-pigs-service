package com.raise.pigs.service.vo.pigsty;

import com.raise.pigs.service.vo.BaseModify;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Max;

/**
 * <p>
 *
 * </p>
 *
 * @author osumg
 * @since 2020/8/31
 */
@Data
public class ModifyPigstyVO extends BaseModify {

    /**
     * 最大容量
     */
    @Range(min = 0, max = 99, message = "最大容量为0~99")
    private Integer maxCapacity;

    /**
     * 真实容量
     */
    @Range(min = 0, max = 99, message = "真实容量为0~99")
    private Integer realCapacity;
}
