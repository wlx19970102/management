package com.manage.Controller;


import com.alibaba.fastjson.JSONObject;
import com.google.code.kaptcha.Constants;
import com.manage.common.Result;
import com.manage.common.util.CoreConst;
import com.manage.common.util.PasswordHelper;
import com.manage.entity.Login;
import com.manage.entity.User;
import com.manage.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 王凌霄
 * @FileName management
 * @Date 2019/9/19 17:18
 */

@RestController
public class HelloWorldController {

    @Autowired
    private UserService userService;
    private static final Logger log = LoggerFactory.getLogger(HelloWorldController.class);

    @Autowired
    private  Result result;

    @RequestMapping("/ht")
    public ModelAndView  hello(){

        return new ModelAndView("login1111");
    }
    @RequestMapping("/ll")
    public String dd(){
        return "dddddddddd";
    }

    @RequestMapping (value = "/toregister")
    @ResponseBody
    public  Result reg(HttpServletRequest request,  Login login , String verification){

        System.out.println("register.........."+login);
        //判断验证码
        String rightCode = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        if (StringUtils.isNotBlank(verification) && StringUtils.isNotBlank(rightCode) && verification.equals(rightCode)) {
            //验证码通过
        } else {
            return result.error("验证码错误！");
        }
        System.out.println(verification+"ddddddd"+rightCode);
        String username = login.getUsername();
        System.out.println("uiuuuuuuuuuuuuasdsa"+username);
        User UU = userService.findUserByUserName(username);

        if (UU != null ) {
            return result.error("用户名已存在");
        }
        login.setCreateTime();
        login.setLastLoginTime();
        login.setUpdateTime();
        User user1 = new User();
        user1.setId();
        user1.setLogin(login);
        user1.setStatus(CoreConst.STATUS_VALID);
        System.out.println("user0000000000000000000:"+user1);
        PasswordHelper.encryptPassword(user1);
        //注册
        Result register = userService.register(user1);
        System.out.println("注册成功");
        return register.success(user1);
    }
    @RequestMapping(value = "/tologin")
    @ResponseBody
    public Result login(HttpServletRequest request, Login login ,String verification, @RequestParam(value = "rememberMe", defaultValue = "0") Integer rememberMe) {
        log.info("正在登录");
        //判断验证码
        String rightCode = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        if (StringUtils.isNotBlank(verification) && StringUtils.isNotBlank(rightCode) && verification.equals(rightCode)) {
            //验证码通过
        } else {
            return result.error("验证码错误！");
        }
        String username = login.getUsername();
        String password = login.getPassword();
        Subject subject = SecurityUtils.getSubject();
        JSONObject json = new JSONObject();
        Session session = subject.getSession();
        String sessionId = (String) session.getId();
        json.put("sessionId", sessionId);
        if (!subject.isAuthenticated()) {
            // 把用户名和密码封装为 UsernamePasswordToken 对象
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            try {
                token.setRememberMe(false);
                subject.login(token);
            } catch (LockedAccountException e) {
                token.clear();
                return result.error("用户已经被锁定不能登录，请联系管理员！");
            } catch (AuthenticationException e) {
                token.clear();
                return result.error("用户名或者密码错误！");
            }
        }
        System.out.println(login);
        //更新最后登录时间
        userService.updateLastLoginTime(login);
        System.out.println("登录成功");
        return result.success("登录成功！");
    }
}
