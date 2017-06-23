package com.projectdemo.zwz.liverookie.presenter;

import com.projectdemo.zwz.liverookie.base.BaseView;

/**
 * Created by ylzx on 2017/6/23.
 *登录逻辑处理
 *
 */
public class LoginPresenter extends ILoginPresenter {



    public LoginPresenter(BaseView baseView) {
        super(baseView);
    }

    @Override
    public boolean checkPhoneLogin(String phone, String verifyCode) {
        return false;
    }

    @Override
    public boolean checkUserNameLogin(String userName, String password) {
        return false;
    }

    @Override
    public void phoneLogin(String phone, String verifyCode) {

    }

    @Override
    public void usernameLogin(String userName, String password) {

    }

    @Override
    public void sendVerifyCode(String phoneNum) {

    }

    @Override
    public void start() {

    }

    @Override
    public void finish() {

    }
}
