package com.manage.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author 王凌霄
 * @FileName management
 * @Date 2019/9/23 14:57
 */
@Component
@ConfigurationProperties("config.excelconfig")
public class ExcelConfig {
    private String picLink;

    public String getPicLink() {
        return picLink;
    }

    public ExcelConfig setPicLink(String picLink) {
        this.picLink = picLink;
        return this;
    }
}
