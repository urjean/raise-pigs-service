package com.raise.pigs.service.vo.kind;

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
public class KindModifyVO extends BaseModify {

    @Size(max = 20, message = "种类名称长度不超过20个字符")
    private String kindName;

    @Min(value = 0, message = "价格不能小于零")
    private BigDecimal kindPrice;
}
