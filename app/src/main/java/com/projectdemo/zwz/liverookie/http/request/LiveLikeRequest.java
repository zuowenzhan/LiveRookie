package com.projectdemo.zwz.liverookie.http.request;


import com.google.gson.reflect.TypeToken;
import com.projectdemo.zwz.liverookie.http.response.Response;

import java.lang.reflect.Type;

/**
 * @description: 直播喜欢请求
 *
 * @author: Andruby
 * @time: 2016/11/2 18:07
 */
public class LiveLikeRequest extends IRequest {

    public LiveLikeRequest(int requestId, String userId, String liveId) {
        mRequestId = requestId;
        mParams.put("action","liveLike");
        mParams.put("userId",userId);
        mParams.put("liveId",liveId);
    }

    @Override
    public String getUrl() {
        return getHost() + "Live";
    }

    @Override
    public Type getParserType() {
        return new TypeToken<Response>() {}.getType();
    }
}