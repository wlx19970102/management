package com.manage.exception;



/**
 * @author 王凌霄
 * @FileName management
 * @Date 2019/9/21 11:39
 * 错误信息
 */

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;


public class OperationException  extends RuntimeException{

    public OperationException(String message) {
        super(message);
    }
}
