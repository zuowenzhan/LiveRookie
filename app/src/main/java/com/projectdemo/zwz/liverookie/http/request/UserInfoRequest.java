package com.projectdemo.zwz.liverookie.http.request;


import com.google.gson.reflect.TypeToken;
import com.projectdemo.zwz.liverookie.http.data.UserInfo;
import com.projectdemo.zwz.liverookie.http.response.Response;

import java.lang.reflect.Type;


/**
 * @description: 用户信息请求
 *
 * @author: Andruby
 * @time: 2016/11/2 18:07
 */
public class UserInfoRequest   extends IRequest {

    public UserInfoRequest(int requestId,String userId ) {
        mRequestId = requestId;
        mParams.put("action","userInfo");
        mParams.put("userId",userId);
    }

    @Override
    public String getUrl() {
        return getHost() + "Live";
    }

    @Override
    public Type getParserType() {
        return new TypeToken<Response<UserInfo>>() {
        }.getType();
    }
}
