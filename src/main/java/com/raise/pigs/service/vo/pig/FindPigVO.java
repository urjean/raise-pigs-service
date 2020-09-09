package com.raise.pigs.service.vo.pig;

import com.raise.pigs.service.vo.BasePage;
import lombok.Data;

import javax.validation.constraints.Min;
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
public class FindPigVO extends BasePage {

    /**
     * 编号
     */
    private Integer number;

    /**
     * 种类id
     */
    private Long kindId;

    /**
     * 年龄区间（小）
     */
    @Min(value = 0, message = "年龄必须大于0")
    private Integer smallAge;

    /**
     * 年龄区间（小）
     */
    @Min(value = 0, message = "年龄必须大于0")
    private Integer bigAge;

}
