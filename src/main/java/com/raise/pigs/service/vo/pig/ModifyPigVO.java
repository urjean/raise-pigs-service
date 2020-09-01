package com.raise.pigs.service.vo.pig;

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
public class ModifyPigVO extends BaseModify {
    @Min(value = 0, message = "年龄输入有误")
    private Integer age;
}
