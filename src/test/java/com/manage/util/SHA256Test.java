package com.manage.util;

import com.manage.ManagementApplication;
import com.manage.common.util.SHA256Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 王凌霄
 * @FileName management
 * @Date 2019/9/20 9:20
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SHA256Test {


    @Test
    public  void   ceshi(){
        System.out.println("ceshi!!");
    }
    @Test
    public  void  sha256(){
        String s = SHA256Util.sha256("admin", "dddd");
        System.out.println(s);
    }
}
