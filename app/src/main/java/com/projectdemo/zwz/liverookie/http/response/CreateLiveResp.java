package com.projectdemo.zwz.liverookie.http.response;


import com.projectdemo.zwz.liverookie.http.IDontObfuscate;

/**
 * @description: 创建直播返回

 */
public class CreateLiveResp  extends IDontObfuscate {
    private String pushUrl;

    public String getPushUrl() {
        return pushUrl;
    }

    public void setPushUrl(String pushUrl) {
        this.pushUrl = pushUrl;
    }
}
