package com.manage.service.impl;

import com.manage.common.Result;
import com.manage.entity.Login;
import com.manage.entity.User;
import com.manage.service.UserService;
import com.mongodb.client.result.UpdateResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 王凌霄
 * @FileName management
 * @Date 2019/9/20 10:16
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private  MongoTemplate mongoTemplate;
    @Autowired
    private Result result;

    @Override
    public Result register(User user) {
        System.out.println("impl" + user.toString() + "dddddd" + user);
        User insert = mongoTemplate.save(user);
            if(insert != null){

                return  result.success(insert);
            }
        return result.error("注册失败");
    }

    @Override
    public Result findPermsByUserName(String username) {
        return null;
    }

    @Override
    public Result findRoleByUserName(String username) {
        return null;
    }

    @Override
    public User findUserByUserName(String username) {
        Query query = new Query(Criteria.where("login.username").is(username));
        List<User> users = mongoTemplate.find(query, User.class);
        if(users.size()>0){
            return users.get(0);
        }

        return null;
    }

    @Override
    public void updateLastLoginTime(Login login) {
        String username = login.getUsername();
        System.out.println("update:"+username);
        Query query = new Query(Criteria.where("login.username").is(username));
        Update update =new Update();
        login.setLastLoginTime();
        String lastLoginTime = login.getLastLoginTime();
        System.out.println("lasttime:"+lastLoginTime);
        update.set("lastLoginTime",lastLoginTime);
        UpdateResult updateResult = mongoTemplate.updateFirst(query, update, User.class);
        if (updateResult.wasAcknowledged()){
            System.out.println("sssss");
        }
    }
}
