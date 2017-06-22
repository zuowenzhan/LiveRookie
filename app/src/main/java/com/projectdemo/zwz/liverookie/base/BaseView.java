package com.projectdemo.zwz.liverookie.base;

import android.content.Context;

/**
 * MVP中View的基本接口
 */
public interface BaseView<T> {


	/**
	 * @description: 网络加载或耗时加载时界面显示
	 */
	void showLoading();

	/**
	 * @description: 网络加载或耗时加载完成时界面显示
	 */
	void dismissLoading();

	/**
	 * @description: 消息提示，如Toast，Dialog等
	 */
	void showMsg(String msg);
	void showMsg(int msg);

	/**
	 * @description: 获取Context
	 */
	Context getContext();


}
