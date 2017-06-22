package com.projectdemo.zwz.liverookie.http.request;


import com.google.gson.Gson;
import com.projectdemo.zwz.liverookie.http.IDontObfuscate;

import java.lang.reflect.Type;


/**
 * @description: 网络请求基本类
 *
 * @author: Andruby
 * @time: 2016/11/19 18:07
 */
public abstract class IRequest extends IDontObfuscate {

	private boolean DEBUG = false;


//	public static final String HOST_DEBUG = "http://192.168.31.92:8088/Api/";
	public static final String HOST_DEBUG = "http://192.168.31.92:8094/Api/";
	public static final String HOST_PUBLIC = "http://liveteach.zdapk.cn/Api/";


	protected RequestParams mParams = new RequestParams();
	public int mRequestId = 0;
	protected int mDraw = 0;
	protected final static Gson mGson = new Gson();

	public IRequest() {
	}

	/**
	 * 接口请求参数
	 *
	 */
	public RequestParams getParams() {
		return mParams;
	}

	/**
	 * http直接post数据
	 *
	 */
	public String getPostData() {
		return null;
	}

	/**
	 * 设置接口请求唯一标识
	 *
	 */
	public void setRequestId(int requestId) {
		mRequestId = requestId;
	}

	/**
	 * 返回请求接口唯一标识
	 *
	 */
	public int getRequestId() {
		return mRequestId;
	}

	/**
	 * @return
	 * @throws
	 * @Description:当前接口的url地址
	 * @Title:getUrl
	 * @return:String
	 * @Create: 2015年11月19日 下午11:53:21
	 * @Author : zhm
	 */
	public abstract String getUrl();

	/**
	 * 获取解析类型
	 *
	 */
	public abstract Type getParserType();

	/**
	 * @return
	 * @throws
	 * @Description:返回服务器接口地址
	 */
	protected String getHost() {
		return DEBUG ? HOST_DEBUG : HOST_PUBLIC;
	}


	@Override
	public String toString() {
		return "IRequest [DEBUG=" + DEBUG
				+ ", mParams=" + mParams + ", mRequestId=" + mRequestId
				+ ", mDraw=" + mDraw + "]";
	}

	public boolean isCache() {
		return false;
	}


}