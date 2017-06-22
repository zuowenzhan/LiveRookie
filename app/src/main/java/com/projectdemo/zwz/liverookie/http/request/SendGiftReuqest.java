package com.projectdemo.zwz.liverookie.http.request;


import com.google.gson.reflect.TypeToken;
import com.projectdemo.zwz.liverookie.http.response.Response;

import java.lang.reflect.Type;

/**
 * @description: 发送礼物请求
 *
 * @author: Andruby
 * @time: 2016/11/2 18:07
 */
public class SendGiftReuqest extends IRequest {

    public SendGiftReuqest(int requestId,String userId ,String  liveId,String giftId,int count) {
        mRequestId = requestId;
        mParams.put("action","sendGift");
        mParams.put("userId",userId);
        mParams.put("liveId", liveId);
        mParams.put("giftId", giftId);
        mParams.put("giftCount", count);
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
