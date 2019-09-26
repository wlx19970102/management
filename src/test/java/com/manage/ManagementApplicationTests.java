package com.manage;

import com.alibaba.fastjson.JSONObject;
import com.manage.common.util.PathUtil;
import com.manage.entity.Login;
import com.manage.entity.User;
import com.mongodb.client.result.UpdateResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ManagementApplicationTests {

    @Autowired
    private MongoTemplate mongoTemplate;
    @Test
    public void contextLoads() {
    }
    @Test
    public  void uuid(){
        String s = UUID.randomUUID().toString();
        System.out.println(s);
        String system = PathUtil.getSystem();
        System.out.println(system);
    }


    private static RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
    @Test
    public  void  ddd(){

        String s = randomNumberGenerator.nextBytes().toHex();
        System.out.println(s);
    }


    @Test
    public void  finduserbyusername(){
        Login login = new Login();
        login.setUsername("dddddd");
        Query query = new Query(Criteria.where("login.username").is(login.getUsername()));
        List<User> users = mongoTemplate.find(query, User.class);
        System.out.println(users.get(0));
    }
    @Test
    public  void  userName(){
        User user = new User();
        Login login =new Login();
        user.setLogin(login);
        login.setUsername("sss");
        System.out.println(user.getLogin().getUsername());
    }

    @Test
    public void time(){
        //SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String  time = String.valueOf(System.currentTimeMillis());
        System.out.println(time);
        Login login = new Login();
        login.setLastLoginTime();
        System.out.println("st"+login.getLastLoginTime());


    }

    @Test
    public  void updatetime(){
        Login login =new Login();
        Query query = new Query(Criteria.where("login.username").is("prism"));
        Update update =new Update();
        login.setLastLoginTime();
        update.set("lastLoginTime",login.getLastLoginTime());
        UpdateResult updateResult = mongoTemplate.updateFirst(query, update, User.class);
    }
}
