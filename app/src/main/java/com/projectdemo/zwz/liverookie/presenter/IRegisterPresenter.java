package com.projectdemo.zwz.liverookie.presenter;

import com.projectdemo.zwz.liverookie.base.BasePresenter;
import com.projectdemo.zwz.liverookie.base.BaseView;

/**
 *
 * 注册界面
 * Created by ylzx on 2017/6/26.
 */
public abstract class IRegisterPresenter implements BasePresenter {
    protected BaseView mBaseView;

    public IRegisterPresenter(BaseView baseView) {
        mBaseView = baseView;
    }

    public abstract void sendVerifyCode(String phoneNum);

    protected abstract boolean checkNormalRegister(String username, String password, String passwordVerify);

    protected abstract boolean checkPhoneRegister(String phoneNum, String verifyCode);

    public abstract void normalRegister(final String username, final String password, String passwordVerify);

    public abstract void phoneRegister(final String username, String verifyCode);

    public interface IRegisterView extends BaseView {

        /**
         * 注册成功
         */
        void onSuccess(String username);

        /**
         * 注册失败
         *
         * @param code 错误码
         * @param msg  错误信息
         */
        void onFailure(int code, String msg);

        void showPasswordError(String errorMsg);

        void showPhoneError(String errorMsg);

        void showRegistError(String errorMsg);

        void verifyCodeError(String errorMsg);

        void verifyCodeFailed(String errorMsg);

        void verifyCodeSuccess(int reaskDuration, int expireDuration);

    }

}
