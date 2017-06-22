package com.projectdemo.zwz.liverookie.activity;

import android.content.Intent;
import android.os.Message;
import android.view.WindowManager;

import com.projectdemo.zwz.liverookie.base.BaseActivity;


/**
 *欢迎页面
 */
public class SplashActivity extends BaseActivity {

	private static final String TAG = SplashActivity.class.getSimpleName();
//	private static final int START_LOGIN = 2873;
//	private final MyHandler mHandler = new MyHandler(this);

	private long sleepTime=2000;
	@Override
	protected void initView() {
//		setContentView(R.layout.activity_splash);
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
//		msg.arg1 = START_LOGIN;
//		mHandler.sendMessageDelayed(msg, 1000);

	}
	private void jumpToLoginActivity() {
		LoginActivity.invoke(this);
		finish();
	}

//	private static class MyHandler extends Handler {
//		private final WeakReference<SplashActivity> mActivity;
//
//		public MyHandler(SplashActivity activity) {
//			mActivity = new WeakReference<>(activity);
//		}
//
//		@Override
//		public void handleMessage(Message msg) {
//			SplashActivity activity = mActivity.get();
//			if (activity != null) {
//				activity.jumpToLoginActivity();
//			}
//		}
//	}
@Override
protected void onStart() {
	super.onStart();


	new Thread(new Runnable() {
		@Override
		public void run() {


				try {

					Thread.sleep(sleepTime);

					jumpToLoginActivity();

				} catch (InterruptedException e) {

				}


		}
	}).start();

}


}
