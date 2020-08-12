package com.raise.pigs.service.config.globalException;

import com.raise.pigs.service.utils.result.ResultEnum;
import com.raise.pigs.service.utils.result.ResultBody;
import com.raise.pigs.service.utils.result.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * >
 * 全局异常处理
 * </p>
 *
 * @author osumg
 * @since 2020/8/11
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(ServiceException.class)
    public ResultBody<Object> serviceExceptionHandler(ServiceException e) {
        logger.error(e.getMessage());
        return ResultUtils.error(e.getCode(), e.getMsg());
    }

    @ExceptionHandler(NullPointerException.class)
    public ResultBody<Object> nullExceptionHandler(NullPointerException e) {
        logger.error(e.getMessage());
        return ResultUtils.error(ResultEnum.PARAM_NOT_MATCH);
    }

    @ExceptionHandler(Exception.class)
    public ResultBody<Object> exceptionHandler(Exception e) {
        logger.error(e.getMessage());

        if (e instanceof NoHandlerFoundException) {
            return ResultUtils.error(ResultEnum.NO_HANDLER_FOUND);
        }
        return ResultUtils.error(ResultEnum.SERVICE_ERROR);
    }


}
