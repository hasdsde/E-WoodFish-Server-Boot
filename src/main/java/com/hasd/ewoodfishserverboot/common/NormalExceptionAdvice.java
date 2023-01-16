package com.hasd.ewoodfishserverboot.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author : hasd
 * @version 1.0.0
 * @date : 2023/1/8 20:55
 **/
@ControllerAdvice
public class NormalExceptionAdvice {
    @ResponseBody
    @ExceptionHandler(NormalException.class)
    public Result handleNormalException(NormalException n) {
        if (n.getCode() == null) {
            n.setCode(500);
        }
        return Result.error(n.getCode(), "异常:" + n.getMessage());
    }
}
