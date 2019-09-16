package com.yaxon.wuliudriver.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Description: 登录返回实体
 * Created by jiangj on 2019/9/8.
 */

public class LoginBean implements Serializable {

    private int uid;
    private String sessionId;
    private int type;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
