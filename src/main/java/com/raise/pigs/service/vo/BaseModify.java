package com.raise.pigs.service.vo;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.raise.pigs.service.utils.LongToString;
import com.raise.pigs.service.utils.StringToLong;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * <p>
 *
 * </p>
 *
 * @author osumg
 * @since 2020/8/31
 */
@Data
public class BaseModify {
    /**
     * id不能为空
     */
    @NotNull(message = "id不能为空")
    @JsonSerialize(using = LongToString.class)
    @JsonDeserialize(using = StringToLong.class)
    private Long id;
}
