package com.projectdemo.zwz.liverookie.http.data;

import android.content.Context;

import com.projectdemo.zwz.liverookie.http.IDontObfuscate;
import com.projectdemo.zwz.liverookie.util.LiveSharedPreferenceUtils;


/**
 * @description: 用户信息
 */
public class UserInfo extends IDontObfuscate {

    public String userId;
    public String nickname;
    public String headPic;
    public String sigId;
    public String sdkAppId;
    public String sdkAccountType;
    public int sex;

    public UserInfo() {
    }

    public UserInfo(String userId, String nickname, String headPic, int sex) {
        this.userId = userId;
        this.nickname = nickname;
        this.headPic = headPic;
        this.sex = sex;
    }

    public static void saveCache(Context context, String userId, String nickname, String headPic, String sigId) {
        LiveSharedPreferenceUtils.getInstance().putString(context, "userId", userId);
        LiveSharedPreferenceUtils.getInstance().putString(context, "nickname", nickname);
        LiveSharedPreferenceUtils.getInstance().putString(context, "headPic", headPic);
        LiveSharedPreferenceUtils.getInstance().putString(context, "sigId", sigId);
    }

    public static void saveCache(Context context ,UserInfo info){
        saveCache(context, info.userId, info.nickname, info.headPic, info.sigId);
    }

    public static UserInfo getCache(Context context) {
        UserInfo userInfo = new UserInfo();
        userInfo.userId = LiveSharedPreferenceUtils.getInstance().getString(context, "userId", "");
        userInfo.nickname = LiveSharedPreferenceUtils.getInstance().getString(context, "nickname", "");
        userInfo.headPic = LiveSharedPreferenceUtils.getInstance().getString(context, "headPic", "");
        userInfo.sigId = LiveSharedPreferenceUtils.getInstance().getString(context, "sigId", "");
        return userInfo;
    }

    public static void clearCache(Context context){
        LiveSharedPreferenceUtils.getInstance().clear(context);
    }
}
