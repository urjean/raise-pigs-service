package com.raise.pigs.service.config.globalException;

import com.raise.pigs.service.utils.result.ResultEnum;

/**
 * <p>
 * 业务异常类
 * </p>
 *
 * @author osumg
 * @since 2020/8/11
 */
public class ServiceException extends RuntimeException {
    private Integer code;
    private String msg;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ServiceException() {
        super();
    }

    public ServiceException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
        this.msg = resultEnum.getMsg();
    }

    public ServiceException(String msg) {
        super(msg);
        this.code = -1;
        this.msg = msg;
    }

    public ServiceException(Integer code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }
}
