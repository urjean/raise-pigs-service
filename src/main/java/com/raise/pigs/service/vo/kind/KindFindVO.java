package com.raise.pigs.service.vo.kind;

import com.raise.pigs.service.vo.BasePage;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

/**
 * <p>
 * 种类查询vo
 * </p>
 *
 * @author osumg
 * @since 2020/8/31
 */
@Data
public class KindFindVO extends BasePage {

    /**
     * 种类名称
     */
    @Size(max = 20, message = "种类名称长度不超过20个字符")
    private String kindName;

    /**
     * 小的价格（用于价格区间查询）
     */
    @Min(value = 0, message = "价格不能小于零")
    private BigDecimal smallPrice;

    /**
     * 大的价格（用于价格区间查询）
     */
    @Min(value = 0, message = "价格不能小于零")
    private BigDecimal bigPrice;
}
