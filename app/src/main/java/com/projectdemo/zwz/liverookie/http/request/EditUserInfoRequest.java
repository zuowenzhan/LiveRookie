package com.projectdemo.zwz.liverookie.http.request;


import com.google.gson.reflect.TypeToken;
import com.projectdemo.zwz.liverookie.http.data.UserInfo;
import com.projectdemo.zwz.liverookie.http.response.Response;

import java.lang.reflect.Type;

/**
 * @description: 更新用户信息
 *
 * @author: Andruby
 * @time: 2016/11/2 18:07
 */
public class EditUserInfoRequest  extends IRequest {

    public EditUserInfoRequest(int requestId, String userId, String headPicId,String nickname,String sex) {
        mRequestId = requestId;
        mParams.put("action", "EditUserInfo");
        mParams.put("userId", userId);
        mParams.put("headPic", headPicId);
        mParams.put("nickname", nickname);
        mParams.put("sex", sex);
    }

    @Override
    public String getUrl() {
        return getHost() + "User";
    }

    @Override
    public Type getParserType() {
        return new TypeToken<Response<UserInfo>>() {
        }.getType();
    }
}
