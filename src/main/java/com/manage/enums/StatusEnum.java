package com.manage.enums;

/**
 * @author 王凌霄
 * @FileName management
 * @Date 2019/9/23 8:10
 */
public enum StatusEnum {
    SUCCESS(0, "成功"),ERROY(1,"失败");
    private int state;

    private String stateInfo;
    StatusEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }
    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }
}
