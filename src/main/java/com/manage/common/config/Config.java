package com.manage.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 王凌霄
 * @FileName management
 * @Date 2019/9/23 14:56
 */
@Component
@ConfigurationProperties("config")
public class Config {
    private Map<String,String> upload=new HashMap<>();

    public Map<String, String> getUpload() {
        return upload;
    }

    public Config setUpload(Map<String, String> upload) {
        this.upload = upload;
        return this;
    }

}
