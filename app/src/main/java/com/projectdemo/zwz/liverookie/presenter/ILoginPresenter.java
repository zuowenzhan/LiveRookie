package com.projectdemo.zwz.liverookie.presenter;

import com.projectdemo.zwz.liverookie.base.BasePresenter;
import com.projectdemo.zwz.liverookie.base.BaseView;

/**
 * 登陆管理
 */
public abstract class ILoginPresenter implements BasePresenter {


    protected BaseView mBaseView;

    public ILoginPresenter(BaseView baseView) {
        mBaseView = baseView;
    }

    /**
     * 检查手机号，验证码合理性
     *
     * @param phone
     * @param verifyCode
     * @return
     */
    public abstract boolean checkPhoneLogin(String phone, String verifyCode);

    /**
     * 检查用户名密码合理性
     *
     * @param userName
     * @param password
     * @return
     */
    public abstract boolean checkUserNameLogin(String userName, String password);

    /**
     * 手机号码登陆
     *
     * @param phone
     * @param verifyCode
     */
    public abstract void phoneLogin(String phone, String verifyCode);

    /**
     * 用户名密码登陆
     *
     * @param userName
     * @param password
     */
    public abstract void usernameLogin(String userName, String password);

    /**
     * 发送验证码
     *
     * @param phoneNum
     */
    public abstract void sendVerifyCode(String phoneNum);

    public interface ILoginView extends BaseView {
        /**
         * 登陆成功
         */
        public void loginSuccess();

        /**
         * 登陆失败
         */
        public void loginFailed(int status, String msg);

        /**
         * 错误信息
         *
         * @param errorMsg
         */
        public void usernameError(String errorMsg);

        /**
         * 错误信息
         *
         * @param errorMsg
         */
        public void phoneError(String errorMsg);

        /**
         * 错误信息
         *
         * @param errorMsg
         */
        public void passwordError(String errorMsg);


        void verifyCodeError(String errorMsg);

        void verifyCodeFailed(String errorMsg);

        void verifyCodeSuccess(int reaskDuration, int expireDuration);

    }
}
