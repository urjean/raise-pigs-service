package com.raise.pigs.service.vo.sale;

import com.raise.pigs.service.vo.BaseModify;
import lombok.Data;

import javax.validation.constraints.Min;

/**
 * <p>
 *
 * </p>
 *
 * @author osumg
 * @since 2020/8/31
 */
@Data
public class ModifySaleVO extends BaseModify {

    /**
     * 销售数量
     */
    @Min(value = 0, message = "销售数量不能小于0")
    private Integer saleQuantity;

}
