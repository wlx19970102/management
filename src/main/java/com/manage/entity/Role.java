package com.manage.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 王凌霄
 * @FileName management
 * @Date 2019/9/24 9:58
 * 角色
 */
public class Role   implements Serializable {

    /**
     * 角色id
     */
    private String roleId;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 角色描述
     */
    private String description;

    /**
     * 状态：1有效; 0无效
     */
    private Integer status;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 更新时间
     */
    private String updateTime;

    public String getRoleId() {
        return roleId;
    }

    public Role setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
        return this;
    }

    public String getName() {
        return name;
    }

    public Role setName(String name) {
        this.name = name == null ? null : name.trim();
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Role setDescription(String description) {
        this.description = description;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public Role setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public String getCreateTime() {
        return createTime;
    }

    public Role setCreateTime(String createTime) {
        this.createTime = createTime;
        return this;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public Role setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
        return this;
    }
}
