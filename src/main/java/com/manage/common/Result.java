package com.manage.common;

import com.manage.enums.StatusEnum;
import org.springframework.stereotype.Component;

/**
 * @author 王凌霄
 * @FileName management
 * @Date 2019/9/21 17:27
 * 封装json对象，所有返回结果都使用它
 */
@Component
public class Result {
    /**
     * 是否成功标志
     */
    private boolean success;
    /**
     * /成功时返回的数据
     */
    private Object data;
    /**
     *     错误信息
     */
    private StatusEnum statusEnum;
    private String msg;
    public Result() {

    }

    public  static  Result getNewInstance(){
        return new Result();
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public StatusEnum getStatusEnum() {
        return statusEnum;
    }

    public void setStatusEnum(StatusEnum errorMsg) {
        this.statusEnum = statusEnum;
    }

    public String getMsg() {
        return msg;
    }

    public Result setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public void seccess() {
        this.success=true;
        this.statusEnum=StatusEnum.SUCCESS;
    }

    public void error(){
        this.success=false;
        this.statusEnum=StatusEnum.ERROY;
    }

    /**
     *  成功时的构造器
     * @param
     * @param data
     */
    public Result success( Object data) {
        this.seccess();
        this.setData(data);
        return this;
    }

    /**
     *失败
     *
     *
     */

    public Result error (String msg) {
        this.error();
        this.msg=msg;
        return this;
    }

    public Result Object (Object o) {
       this.data=o;

        return this;
    }


}
