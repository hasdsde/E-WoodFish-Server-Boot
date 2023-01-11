package com.hasd.ewoodfishserverboot.common;

import lombok.Getter;
import lombok.Setter;

/**
 * @author : hasd
 * @version 1.0.0
 * @date : 2023/1/8 20:51
 **/
@Getter
@Setter
public class NormalException extends RuntimeException {
    private Integer code;
    private String Message;

    public NormalException() {
        super();
    }

    public NormalException(String msg) {
        super(msg);
    }

    public NormalException(Integer code, String msg) {
        super();
        this.code = code;
        this.Message = msg;
    }
}
