package com.projectdemo.zwz.liverookie.presenter;

import com.projectdemo.zwz.liverookie.http.AsyncHttp;
import com.projectdemo.zwz.liverookie.http.data.UserInfo;
import com.projectdemo.zwz.liverookie.http.request.PhoneRegisterRequest;
import com.projectdemo.zwz.liverookie.http.request.RegisterRequest;
import com.projectdemo.zwz.liverookie.http.request.RequestComm;
import com.projectdemo.zwz.liverookie.http.request.VerifyCodeRequest;
import com.projectdemo.zwz.liverookie.http.response.Response;
import com.projectdemo.zwz.liverookie.util.OtherUtils;

/**
 *
 * 注册信息管理
 * Created by ylzx on 2017/6/26.
 */
public class RegisterPresenter extends IRegisterPresenter {

    public static final String TAG = RegisterPresenter.class.getSimpleName();
    private IRegisterView mIRegisterView;

    public RegisterPresenter(IRegisterView iRegisterView) {
        super(iRegisterView);
        mIRegisterView = iRegisterView;
    }
    @Override
    public void sendVerifyCode(String phoneNum) {
        if (OtherUtils.isPhoneNumValid(phoneNum)) {
            if (OtherUtils.isNetworkAvailable(mIRegisterView.getContext())) {
                VerifyCodeRequest req = new VerifyCodeRequest(1000, phoneNum);
                AsyncHttp.instance().postJson(req, new AsyncHttp.IHttpListener() {
                    @Override
                    public void onStart(int requestId) {
                        mIRegisterView.showLoading();
                    }

                    @Override
                    public void onSuccess(int requestId, Response response) {
                        if (response.status == RequestComm.SUCCESS) {
                            UserInfo userInfo = (UserInfo) response.data;
                            if (null != mIRegisterView) {
                                mIRegisterView.verifyCodeSuccess(60, 60);
                            }
                        } else {
                            mIRegisterView.verifyCodeFailed("获取台验证码失败");
                        }
                        mIRegisterView.dismissLoading();
                    }

                    @Override
                    public void onFailure(int requestId, int httpStatus, Throwable error) {
                        if (null != mIRegisterView) {
                            mIRegisterView.verifyCodeFailed("获取台验证码失败");
                        }
                        mIRegisterView.dismissLoading();
                    }
                });
            } else {
                mIRegisterView.showMsg("当前无网络连接");
            }
        } else {
            mIRegisterView.showRegistError("手机号码不符合规范");
        }
    }

    @Override
    protected boolean checkNormalRegister(String username, String password, String passwordVerify) {
        if (OtherUtils.isUsernameVaild(username)) {
            if (OtherUtils.isPasswordValid(password)) {
                if (password.equals(passwordVerify)) {
                    if (OtherUtils.isNetworkAvailable(mIRegisterView.getContext())) {
                        return true;
                    } else {
                        mIRegisterView.showMsg("当前无网络连接");
                    }
                } else {
                    mIRegisterView.showPasswordError("两次输入密码不一致");
                }
            } else {
                mIRegisterView.showPasswordError("密码长度应为6-16位");
            }
        } else {
            mIRegisterView.showRegistError("用户名不符合规范");
        }
        return false;
    }

    @Override
    protected boolean checkPhoneRegister(String phoneNum, String verifyCode) {
        if (OtherUtils.isPhoneNumValid(phoneNum)) {
            if (OtherUtils.isVerifyCodeValid(verifyCode)) {
                if (OtherUtils.isNetworkAvailable(mIRegisterView.getContext())) {
                    return true;
                } else {
                    mIRegisterView.showMsg("当前无网络连接");
                }
            } else {
                mIRegisterView.showPasswordError("验证码格式错误");
            }
        } else {
            mIRegisterView.showPhoneError("手机号码不符合规范");
        }
        return false;
    }

    @Override
    public void normalRegister(final String username, String password, String passwordVerify) {
        if (checkNormalRegister(username, password, passwordVerify)) {
            RegisterRequest req = new RegisterRequest(RequestComm.register, username, password);
            AsyncHttp.instance().postJson(req, new AsyncHttp.IHttpListener() {
                @Override
                public void onStart(int requestId) {
                    mIRegisterView.showLoading();
                }

                @Override
                public void onSuccess(int requestId, Response response) {
                    if (response.status == RequestComm.SUCCESS) {
                        UserInfo userInfo = (UserInfo) response.data;
                        if (null != mIRegisterView) {
                            mIRegisterView.onSuccess(username);
                        }
                    } else {
                        mIRegisterView.onFailure(response.status, response.msg);
                    }
                    mIRegisterView.dismissLoading();
                }

                @Override
                public void onFailure(int requestId, int httpStatus, Throwable error) {
                    if (null != mIRegisterView) {
                        mIRegisterView.onFailure(httpStatus, error.getMessage());
                    }
                    mIRegisterView.dismissLoading();
                }
            });
        }
    }

    @Override
    public void phoneRegister(String username, String verifyCode) {
        if (checkPhoneRegister(username, verifyCode)) {
            PhoneRegisterRequest req = new PhoneRegisterRequest(RequestComm.register, username, verifyCode);
            AsyncHttp.instance().postJson(req, new AsyncHttp.IHttpListener() {
                @Override
                public void onStart(int requestId) {
                    mIRegisterView.showLoading();
                }

                @Override
                public void onSuccess(int requestId, Response response) {
                    if (response.status == RequestComm.SUCCESS) {
                        if (null != mIRegisterView) {
                            mIRegisterView.onSuccess(null);
                        }
                    } else {
                        mIRegisterView.verifyCodeError("验证码不正确");
                    }
                    mIRegisterView.dismissLoading();
                }

                @Override
                public void onFailure(int requestId, int httpStatus, Throwable error) {
                    if (null != mIRegisterView) {
                        mIRegisterView.onFailure(httpStatus, "网络异常");
                    }
                    mIRegisterView.dismissLoading();
                }
            });
        }
    }

    @Override
    public void start() {

    }

    @Override
    public void finish() {

    }
}
