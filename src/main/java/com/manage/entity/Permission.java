package com.manage.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 王凌霄
 * @FileName management
 * @Date 2019/9/23 18:20
 * 权限
 */
public class Permission  implements Serializable {

    /**
     * 权限id
     */
    private String permissionId;

    /**
     * 权限名称
     */
    private String name;

    /**
     * 权限描述
     */
    private String description;

    /**
     * 权限访问路径
     */
    private String url;

    /**
     * 父级权限id
     */
    private Integer parentId;

    /**
     * 状态：1有效; 0无效
     */
    private Integer status;

    private Date createTime;

    private Date updateTime;

    public String getPermissionId() {
        return permissionId;
    }

    public Permission setPermissionId(String permissionId) {
        this.permissionId = permissionId == null ? null : permissionId.trim();
        return this;
    }

    public String getName() {
        return name;
    }

    public Permission setName(String name) {
        this.name = name == null ? null : name.trim();
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Permission setDescription(String description) {
        this.permissionId = permissionId == null ? null : permissionId.trim();
        return this;
    }

    public String getUrl() {
        return url;
    }

    public Permission setUrl(String url) {
        this.url = url == null ? null : url.trim();
        return this;
    }

    public Integer getParentId() {
        return parentId;
    }

    public Permission setParentId(Integer parentId) {
        this.parentId = parentId;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public Permission setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Permission setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public Permission setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }
}
