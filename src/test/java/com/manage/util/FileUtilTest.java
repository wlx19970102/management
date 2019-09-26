package com.manage.util;

import io.lettuce.core.dynamic.annotation.Value;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author 王凌霄
 * @FileName management
 * @Date 2019/9/21 14:28
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FileUtilTest {





    /**
     * 得到图片扩展名
     */
    @Test
    public  void  getExtension(){
        String  fileName="askdjlaskdsa.jpg";
        fileName =fileName.substring(fileName.lastIndexOf("."));
        System.out.println(fileName);
    }

    @Test
    public void  getRandomName(){
        //随机获得5位数
        int  ran = new Random().nextInt(89999)+10000;
        System.out.println(ran);
        //在与当前时间拼接
        String nowtime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        System.out.println(nowtime);
        System.out.println(ran+nowtime);

    }
    @Test
    public  void  tt(){
        System.out.println("文件分隔符：" + System.getProperty("file.separator"));
    }

    @Test
    public  void getImgBasePath() {
        String s="/\"/";
        String os = System.getProperty("os.name");
        String basePath = "";
        if (os.toLowerCase().startsWith("win")) {

        } else {
            basePath = "";
        }
        basePath = basePath.replace("/", s);
        System.out.println();
    }

}
