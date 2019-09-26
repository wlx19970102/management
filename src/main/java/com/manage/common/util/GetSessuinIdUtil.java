package com.manage.common.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

/**
 * @author 王凌霄
 * @FileName management
 * @Date 2019/9/24 17:00
 */

public class GetSessuinIdUtil {

    public static JSONObject getSessionId(){
        Subject subject = SecurityUtils.getSubject();
        JSONObject json = new JSONObject();
        Session session = subject.getSession();
        String sessionId = (String) session.getId();
        json.put("sessionId", sessionId);
        return json;
    }
}
