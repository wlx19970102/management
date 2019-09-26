package com.manage.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * @author 王凌霄
 * @FileName management
 * @Date 2019/9/21 11:59
 * 自定义异常类
 */
@Setter
@Getter
public class CustomException  {

    private long code;
    private String msg;

    public CustomException(Long code, String msg){
        this.code = code;
        this.msg = msg;
    }


}
