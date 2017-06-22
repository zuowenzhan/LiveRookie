package com.projectdemo.zwz.liverookie.base;

import android.app.Application;
import android.util.Log;

import com.projectdemo.zwz.liverookie.util.LogUitils;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.rtmp.TXLiveBase;
import com.tencent.rtmp.TXLivePusher;
import com.zhy.autolayout.config.AutoLayoutConifg;

import java.util.Locale;

/**
 * Created by ylzx on 2017/6/22.
 */
public class MyApplication extends Application {



    private static final String BUGLY_APPID = "1400012894";

    private static MyApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;

        //屏幕适配
        AutoLayoutConifg.getInstance().useDeviceSize();



        initSDK();
    }

    public static MyApplication getApplication() {
        return instance;
    }

    /**
     * 初始化SDK，包括Bugly，IMSDK，RTMPSDK等
     */
    public void initSDK() {


        //注册crash上报 bugly组件
        int[] sdkVer = TXLivePusher.getSDKVersion(); //这里调用TXLivePlayer.getSDKVersion()也是可以的
        if (sdkVer != null && sdkVer.length >= 3) {
            if (sdkVer[0] > 0 && sdkVer[1] > 0) {
                //启动bugly组件，bugly组件为腾讯提供的用于crash上报和分析的开放组件，如果您不需要该组件，可以自行移除
                CrashReport.UserStrategy strategy = new CrashReport.UserStrategy(getApplicationContext());
                strategy.setAppVersion(String.format(Locale.US, "%d.%d.%d",sdkVer[0],sdkVer[1],sdkVer[2]));
                CrashReport.initCrashReport(getApplicationContext(), BUGLY_APPID, true, strategy);
            }
        }

//        IMInitMgr.init(getApplicationContext());

        //设置rtmpsdk log回调，将log保存到文件
        TXLiveBase.getInstance().listener = new LogUitils(getApplicationContext());

        //初始化httpengine
//        HttpEngine.getInstance().initContext(getApplicationContext());

        Log.w("LogUitils", "app init sdk");
    }


}
