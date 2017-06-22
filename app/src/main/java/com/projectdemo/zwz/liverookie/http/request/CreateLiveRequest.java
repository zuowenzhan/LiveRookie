package com.projectdemo.zwz.liverookie.http.request;


import com.google.gson.reflect.TypeToken;
import com.projectdemo.zwz.liverookie.http.response.CreateLiveResp;
import com.projectdemo.zwz.liverookie.http.response.Response;

import java.lang.reflect.Type;


/**
 * @description: 创建直播接口请求
 */
public class CreateLiveRequest extends IRequest {

    public CreateLiveRequest(int requestId,String userId ,String groupId,String title, String liveCover,String location) {
        mRequestId = requestId;
        mParams.put("action","createLive");
        mParams.put("userId",userId);
        mParams.put("groupId",groupId);
        mParams.put("title", title);
        mParams.put("liveCover", liveCover);
        mParams.put("location", location);
    }

    @Override
    public String getUrl() {
        return getHost() + "Live";
    }

    @Override
    public Type getParserType() {
        return new TypeToken<Response<CreateLiveResp>>() {
        }.getType();
    }
}
