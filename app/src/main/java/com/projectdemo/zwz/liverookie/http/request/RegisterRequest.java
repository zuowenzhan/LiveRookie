package com.projectdemo.zwz.liverookie.http.request;


import com.google.gson.reflect.TypeToken;
import com.projectdemo.zwz.liverookie.http.data.UserInfo;
import com.projectdemo.zwz.liverookie.http.response.Response;

import java.lang.reflect.Type;

/**
 * @description: 注册接口请求
 *
 * @author: Andruby
 * @time: 2016/11/2 18:07
 */
public class RegisterRequest extends IRequest {

	public RegisterRequest(int requestId, String userName, String password) {
		mRequestId = requestId;
		mParams.put("action", "register");
		mParams.put("userName", userName);
		mParams.put("password", password);
		mParams.put("rePassword", password);
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
