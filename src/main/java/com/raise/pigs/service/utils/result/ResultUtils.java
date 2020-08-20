package com.raise.pigs.service.utils.result;

/**
 * <p>
 * 返回体工具类
 * </p>
 *
 * @author osumg
 * @since 2020/8/7
 */
public class ResultUtils {
    private ResultUtils() {
    }

    public static <T> ResultBody<T> success(T data) {
        ResultBody<T> result = new ResultBody<>(ResultEnum.SUCCESS);
        result.setData(data);
        return result;
    }

    public static <T> ResultBody<T> successNoData() {
        return new ResultBody<>(ResultEnum.SUCCESS);
    }

    public static <T> ResultBody<T> error(ResultEnum resultEnum) {
        ResultBody<T> result = new ResultBody<>();
        result.setCode(resultEnum.getCode());
        result.setMsg(resultEnum.getMsg());
        return result;
    }

    public static <T> ResultBody<T> error(Integer code, String msg) {
        ResultBody<T> result = new ResultBody<>();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
