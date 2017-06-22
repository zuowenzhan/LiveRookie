package com.projectdemo.zwz.liverookie.base;

import android.app.ActionBar;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.widget.Toast;

/**
 * Created by ylzx on
 *界面抽取
 * 包括标题、网络、图片加载
 */
public abstract class BaseActivity extends FragmentActivity{


    protected Context mContext;
    protected Handler mHandler = new Handler();

    /**
     * 图片加载
     */
    public ActionBar actionBar;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        setBeforeLayout();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        mContext=this;

        initView();
        initData();

    }
    protected void setBeforeLayout(){}



    /**
     * 此方法描述的是： 初始化所有view
     */
    protected abstract void initView();

    /**
     * 此方法描述的是： 初始化所有数据的方法
     */
    protected abstract void initData();



    @Override
    protected void onResume() {
        super.onResume();
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
