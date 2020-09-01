package com.raise.pigs.service.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author osumg
 * @since 2020/8/25
 */
@Data
public class BasePage implements Serializable {
    /**
     * 每页显示大小
     */
    @NotNull(message = "每页大小不能为空")
    private Integer size;

    /**
     * 当前页码
     */
    @NotNull(message = "当前页码不能为空")
    private Integer current;
}
