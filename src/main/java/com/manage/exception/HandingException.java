package com.manage.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 王凌霄
 * @FileName management
 * @Date 2019/9/23 15:43
 * 异常处理
 *
 * 全局捕获异常类，只要作用在@RequestMapping上，所有的异常都会被捕获
 */
@ResponseBody
@ControllerAdvice
public class HandingException {
    @ExceptionHandler(value = Exception.class)
    public Map<String,Object> errorHandle(Exception e){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("code",-1);
        map.put("msg",e.getMessage());
        return map;
    }
}
