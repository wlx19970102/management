package com.manage.entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author 王凌霄
 * @FileName management
 * @Date 2019/9/20 9:51
 */
@Data
@Document(collection = "sy_user")
public class User implements Serializable {
    @Field("_id")
    private  String  id="";
    /**
     * 登录
     */
    private Login login = new Login();
    /**
     * 权限
     */
    private List<Permission> permissions =new ArrayList<>();

    /**
     * 角色
     */
    private Set<Role> role = new HashSet<>();

    /**
     * 用户状态：1有效; 0无效
     */
    private Integer status=null;

    public String getId() {
        return id;
    }

    public User setId() {
        this.id = ObjectId.get().toString();
        return this;
    }

    public Login getLogin() {
        return login;
    }

    public User setLogin(Login login) {
        this.login = login;
        return this;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public User setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
        return this;
    }

    public Set<Role> getRole() {
        return role;
    }

    public User setRole(Set<Role> role) {
        this.role = role;
        return this;
    }

    /**
     * 获取用户状态：1有效; 0无效
     *
     * @return status - 用户状态：1有效; 0无效
     */
    public Integer getStatus() {
        return status;
    }

    public User setStatus(Integer status) {
        this.status = status;
        return this;
    }
}
