package com.projectdemo.zwz.liverookie.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseFragment extends Fragment {
	/**
	 * 图片加载
	 */
	protected View mRootView;
	protected Intent mBundleIntent;


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		if (getLayoutId() != 0) {
			mRootView = inflater.inflate(getLayoutId(), container, false);
		}
		initView(mRootView);
		setUserVisibleHint(true);
		setListener();
		initData();
		return mRootView;
	}

	@Override
	public void onHiddenChanged(boolean hidden) {
		if (hidden) {
			mBundleIntent = null;
		}
		super.onHiddenChanged(hidden);
	}

	@Override
	public void setUserVisibleHint(boolean isVisibleToUser) {
		// TODO Auto-generated method stub
		super.setUserVisibleHint(isVisibleToUser);
	}

	/**
	 * 此方法描述的是： 初始化所有数据的方法
	 */
	protected abstract void initData();

	/**
	 * 此方法描述的是： 获取布局
	 */
	protected abstract int getLayoutId();

	/**
	 * 此方法描述的是： 初始化界面
	 */
	protected abstract void initView(View rootView);

	/**
	 * 此方法描述的是： 初始化界面
	 */
	protected abstract void setListener();

	/**
	 * 重写ActionBar
	 */
	public void initActionBar(Activity activity) {

	}

	public void setBundleIntent(Intent intent) {
		mBundleIntent = intent;
	}

	public <T extends View> T obtainView(int resId) {
		return (T) mRootView.findViewById(resId);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();

	}

	/**
	 * description:按返回时的操作
	 */

	public void onBackPressed() {

	}

}
