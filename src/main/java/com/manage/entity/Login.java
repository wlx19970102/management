package com.manage.entity;

import lombok.Data;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.springframework.data.annotation.Transient;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author 王凌霄
 * @FileName management
 * @Date 2019/9/20 9:52
 * 登录
 */
@Data
public class Login implements Serializable {
    /**
     * 随机生成树
     */
    private static RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();

    /**
     * 登录账号
     */
    private String username;
    /**
     * 登录密码
     */
    private String password;
    /**
     * 盐
     */
    private String salt;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 更新时间
     */
    private String updateTime;

    /**
     * 最后登录时间
     */
    private String lastLoginTime;

    /**
     * 登录ip
     */
    @Transient
    private String loginIpAddress;


    public String getUsername() {
        return username;
    }

    public Login setUsername(String username) {
        this.username = username == null ? null : username.trim();
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Login setPassword(String password) {
        this.password = password == null ? null : password.trim();
        return this;
    }

    /**
     *
     * 重写获取盐值方法，自定义realm使用
     * Gets credentials salt.
     *
     * @return the credentials salt
     */
    public String getCredentialsSalt() {
        return username + "nbclass.com" + salt;
    }

    public String getSalt() {
        return salt;
    }

    public Login setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
        return this;
    }

    public String getCreateTime() {
        return createTime;
    }

    public Login setCreateTime(String createTime) {
        this.createTime =createTime;
        return this;
    }
    public Login setCreateTime( ) {
        this.createTime =new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        return this;
    }
    public String getUpdateTime() {
        return updateTime;
    }

    public Login setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
        return this;
    }
    public Login setUpdateTime( ) {
        this.updateTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        return this;
    }

    public String getLastLoginTime() {
        return lastLoginTime;
    }

    public Login setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
        return this;
    }
    public Login setLastLoginTime( ) {
        this.lastLoginTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        return this;
    }

    public String getLoginIpAddress() {
        return loginIpAddress;
    }

    public Login setLoginIpAddress(String loginIpAddress) {
        this.loginIpAddress = loginIpAddress;
        return this;
    }
}
