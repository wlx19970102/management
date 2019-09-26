package com.manage.common.shiro;

import com.manage.common.Result;
import com.manage.common.util.CoreConst;
import com.manage.entity.Login;
import com.manage.entity.Permission;
import com.manage.entity.User;
import com.manage.exception.OperationException;
import com.manage.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;


/**
 * @author 王凌霄
 * @FileName management
 * @Date 2019/9/23 17:52
 */
public class MyAuthRealm extends AuthorizingRealm {

    private static final Logger log = LoggerFactory.getLogger(MyAuthRealm.class);
    @Autowired
    private UserService userService;

    /**
     * 用户信息认证是在用户进行登录的时候进行验证(不存redis)
     *
     * @param
     * @description 授权
     * @return  权限信息，包括角色以及权限
     * @throws AuthenticationException
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals)
            throws AuthenticationException {
        log.info("===============Shiro用户授权开始");
        if(principals == null){
            throw new AuthorizationException("principals should not be null");
        }
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        //如果身份认证的时候没有传入User对象，这里只能取到userName
        //也就是SimpleAuthenticationInfo构造的时候第一个参数传递需要User对象
        User user = (User) principals.getPrimaryPrincipal();
        // 查询用户用户权限，一个用户可能有多个权限
        Result permName = userService.findPermsByUserName(user.getLogin().getUsername());

        //查询当前用户所属角色名称
        Result roleName = userService.findRoleByUserName(user.getLogin().getUsername());
        authorizationInfo.setRoles((Set<String>) roleName);
        authorizationInfo.setStringPermissions((Set<String>) permName);
        log.info("===============Shiro授权成功");
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        log.info("===============Shiro用户认证开始");
        //UsernamePasswordToken token1=(UsernamePasswordToken) token;
        String username = (String)token.getPrincipal();
        System.out.println("AuthenticationInfo.   username:"+username);
        User user = userService.findUserByUserName(username);
        System.out.println("AuthenticationInfo .  user:"+user);
        if(user==null) {
            throw new OperationException("认证时,当前用户不存在！");
        }
        if (CoreConst.STATUS_INVALID.equals(user.getStatus())){
            // 帐号锁定
            throw new LockedAccountException("账号锁定!");
        }
        Login login = user.getLogin();
        System.out.println("AuthenticationInfo.   login:"+login);
        System.out.println("AuthenticationInfo.   login:"+login.getPassword());
        String name = getName();
        System.out.println(name);
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user,
                login.getPassword(),
                ByteSource.Util.bytes(login.getCredentialsSalt()),
                getName()
        );
        return authenticationInfo;
    }

}
