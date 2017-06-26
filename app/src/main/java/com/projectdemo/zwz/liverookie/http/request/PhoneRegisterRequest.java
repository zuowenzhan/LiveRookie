package com.projectdemo.zwz.liverookie.http.request;

import com.google.gson.reflect.TypeToken;
import com.projectdemo.zwz.liverookie.http.response.Response;

import java.lang.reflect.Type;

/**
 * Created by ylzx on 2017/6/26.
 */
public class PhoneRegisterRequest extends IRequest {

    public PhoneRegisterRequest(int requestId, String mobile, String verifyCode) {
        mRequestId = requestId;
        mParams.put("action", "phoneRegister");
        mParams.put("mobile", mobile);
        mParams.put("verifyCode", verifyCode);
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