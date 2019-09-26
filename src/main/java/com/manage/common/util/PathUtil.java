package com.manage.common.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author 王凌霄
 * @FileName management
 * @Date 2019/9/21 15:00
 */
@Configuration
public class PathUtil {
    //获取文件的分隔符，一般windows的为"\",文件储存时为"/"要替换
    private static String seperator = System.getProperty("file.separator");

    private static String winPath;

    private static String linuxPath;
    //图片
    private static String image;
    //文件
    private static String word;

    @Value("${file.uploadWindow}")
    public void setWinPath(String winPath) {
        PathUtil.winPath = winPath;
    }

    @Value("${file.uploadLinux}")
    public void setLinuxPath(String linuxPath) {
        PathUtil.linuxPath = linuxPath;
    }

    @Value("${file.image}")
    public void setImage(String image) {
        PathUtil.image = image;
    }

    @Value("${file.word}")
    public void setWord(String word) {
        PathUtil.word = word;
    }


    /**
     * 根据不同系统获取对应的文件路径
     *
     * @return
     */
    public static String getSystem() {
        String os = System.getProperty("os.name");
        String basePath = "";
        if (os.toLowerCase().startsWith("win")) {
            basePath = winPath;
        } else {
            basePath = linuxPath;
        }
        basePath = basePath.replace("/", seperator);
        return basePath;
    }


    public static String getImage() {
        return image.replace("/", seperator);
    }

    public static String getWord() {
        return word.replace("/", seperator);
    }
}