package com.manage.service;

import com.manage.common.Result;
import com.manage.entity.Login;
import com.manage.entity.User;

/**
 * @author 王凌霄
 * @FileName management
 * @Date 2019/9/20 10:06
 */
public interface UserService {

    /**
     * 注册
     * @param
     * @return
     */
    Result register(User user);

    /**
     * 根据用户名查看这个人有多少个权限
     * @param username
     * @return
     */
    Result findPermsByUserName(String username);

    /**
     * 根据用户名查看这个人有多少个角色
     * @param username
     * @return
     */
    Result  findRoleByUserName(String username);

    /**
     * 根据用户名查当前用户
     * @param username
     * @return
     */
    User findUserByUserName(String username);

    /**
     * 更新最后上线时间
     * @param user
     */
     void updateLastLoginTime(Login user);
}
