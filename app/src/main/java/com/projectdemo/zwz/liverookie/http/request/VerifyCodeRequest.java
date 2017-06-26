package com.projectdemo.zwz.liverookie.http.request;

import com.google.gson.reflect.TypeToken;
import com.projectdemo.zwz.liverookie.http.response.Response;

import java.lang.reflect.Type;

/**
 * Created by ylzx on 2017/6/26.
 */
public class VerifyCodeRequest extends IRequest {

    public VerifyCodeRequest(int requestId, String mobile) {
        mRequestId = requestId;
        mParams.put("action", "verifyCode");
        mParams.put("mobile", mobile);
    }

    @Override
    public String getUrl() {
        return getHost() + "User";
    }

    @Override
    public Type getParserType() {
        return new TypeToken<Response>() {
        }.getType();
    }
}
