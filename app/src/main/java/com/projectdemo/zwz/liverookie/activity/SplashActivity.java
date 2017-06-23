package com.projectdemo.zwz.liverookie.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.view.WindowManager;

import com.projectdemo.zwz.liverookie.base.BaseActivity;

import java.lang.ref.WeakReference;


/**
 *欢迎页面
 */
public class SplashActivity extends BaseActivity {


	private static final String TAG = SplashActivity.class.getSimpleName();
	private static final int START_LOGIN = 2873;
	private final MyHandler mHandler = new MyHandler(this);


	@Override
	protected void initView() {

	}

	@Override
	protected void initData() {


		if (!isTaskRoot()
				&& getIntent().hasCategory(Intent.CATEGORY_LAUNCHER)
				&& getIntent().getAction() != null
				&& getIntent().getAction().equals(Intent.ACTION_MAIN)) {
			finish();
			return;
		}
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		Message msg = Message.obtain();
		msg.arg1 = START_LOGIN;
		mHandler.sendMessageDelayed(msg, 1000);


	}


	@Override
	public void onBackPressed() {

	}

	private void jumpToLoginActivity() {
		LoginActivity.invoke(this);
		finish();
	}

	private static class MyHandler extends Handler {
		private final WeakReference<SplashActivity> mActivity;

		public MyHandler(SplashActivity activity) {
			mActivity = new WeakReference<>(activity);
		}

		@Override
		public void handleMessage(Message msg) {
			SplashActivity activity = mActivity.get();
			if (activity != null) {
				activity.jumpToLoginActivity();
			}
		}
	}
}