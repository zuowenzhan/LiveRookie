package com.projectdemo.zwz.liverookie.base;

import android.app.ActionBar;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;


/**
 * @Description:界面的抽取，包括标题、网络、图片加载
 */
public abstract class BaseActivity extends FragmentActivity {
    protected Context mContext;
    protected Handler mHandler = new Handler();
    /**
     * 图片加载
     */
    public ActionBar actionBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBeforeLayout();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        mContext=this;

        initView();
        initData();

    }

    protected void setBeforeLayout(){}


    /**
     * 此方法描述的是： 初始化所有view
     *
     * @author: Andruby
     * @version: 2014-3-12 下午3:17:28
     */
    protected abstract void initView();

    /**
     * 此方法描述的是： 初始化所有数据的方法
     *
     * @author: Andruby
     * @version: 2014-3-12 下午3:17:46
     */
    protected abstract void initData();



    @Override
    protected void onResume() {
        super.onResume();
    }


    public <T extends View> T obtainView(int resId) {
        return (T) findViewById(resId);
    }

    /**
     * 显示toast
     *
     * @param resId
     */
    public void showToast(final int resId) {
        showToast(getString(resId));
    }

    /**
     * 显示toast
     *
     * @param resStr
     * @return Toast对象，便于控制toast的显示与关闭
     */
    public Toast showToast(final String resStr) {

        if (TextUtils.isEmpty(resStr)) {
            return null;
        }

        Toast toast = null;

        mHandler.post(new Runnable() {
            @Override
            public void run() {
                Toast toast = Toast.makeText(BaseActivity.this, resStr,
                        Toast.LENGTH_SHORT);
                toast.show();
            }
        });
        return toast;
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
