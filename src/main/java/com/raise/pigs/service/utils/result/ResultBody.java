package com.raise.pigs.service.utils.result;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 统一返回体
 * </p>
 *
 * @author osumg
 * @since 2020/8/7
 */
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class ResultBody<T> {
    private int code;
    private String msg;
    private T data;

    public ResultBody(ResultEnum resultEnum) {
        this.code = resultEnum.getCode();
        this.msg = resultEnum.getMsg();
    }
}
