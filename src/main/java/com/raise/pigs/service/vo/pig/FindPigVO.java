package com.raise.pigs.service.vo.pig;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.raise.pigs.service.utils.LongToString;
import com.raise.pigs.service.utils.StringToLong;
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
     * id
     */
    @JsonSerialize(using = LongToString.class)
    @JsonDeserialize(using = StringToLong.class)
    private Long id;

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
