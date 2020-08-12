package com.raise.pigs.service.utils.result;

/**
 * <p>
 * 返回状态码
 * </p>
 *
 * @author osumg
 * @since 2020/8/7
 */
public enum ResultEnum {
    SUCCESS(0, "成功"),


    PARAM_NOT_MATCH(400, "参数错误"),
    NO_HANDLER_FOUND(404, "不支持的请求路径"),
    SERVICE_ERROR(500, "服务器内部错误"),

    PARAM_IS_INVALID(10001, "参数无效"),
    PARAM_IS_BLANK(10002, "参数为空"),
    PARAM_TYPE_BIND_ERROR(10003, "参数类型错误"),
    PARAM_NOT_COMPLETE(10004, "参数缺失");

    private final Integer code;
    private final String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
