package com.manage.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 王凌霄
 * @FileName management
 * @Date 2019/9/25 16:13
 */
@Controller
public class HomeController {

    @RequestMapping(value={"/","/index"})
    public String index(HttpServletRequest request){
        return "index/index";
    }

    /**
     * 跳转注册
     * @return
     */
    @RequestMapping("/register")
    public String register(){
        return "system/register";
    }

    /**
     * 跳转登陆
     * @return
     */
    @RequestMapping("/login")
    public String login( ){
        return "system/login";
    }
}
