package com.projectdemo.zwz.liverookie.http.request;


import com.google.gson.reflect.TypeToken;
import com.projectdemo.zwz.liverookie.http.data.UserInfo;
import com.projectdemo.zwz.liverookie.http.response.Response;

import java.lang.reflect.Type;

/**
 * @description: 登陆请求
 */
public class LoginRequest extends IRequest {

	public LoginRequest(int requestId, String userName, String password) {
		mRequestId = requestId;
		mParams.put("action", "login");
		mParams.put("userName", userName);
		mParams.put("password", password);
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
