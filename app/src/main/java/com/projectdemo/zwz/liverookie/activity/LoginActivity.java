package com.projectdemo.zwz.liverookie.activity;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.projectdemo.zwz.liverookie.MainActivity;
import com.projectdemo.zwz.liverookie.R;
import com.projectdemo.zwz.liverookie.base.BaseActivity;
import com.projectdemo.zwz.liverookie.presenter.ILoginPresenter;
import com.projectdemo.zwz.liverookie.presenter.LoginPresenter;
import com.projectdemo.zwz.liverookie.util.AsimpleCache.ACache;
import com.projectdemo.zwz.liverookie.util.AsimpleCache.CacheConstants;
import com.projectdemo.zwz.liverookie.util.OtherUtils;

import java.lang.ref.WeakReference;

public class LoginActivity extends BaseActivity implements ILoginPresenter.ILoginView, View.OnClickListener {

    //共用控件
    private ProgressBar progressBar;
    private EditText etPassword;
    private EditText etLogin;
    private Button btnLogin;
    private Button btnPhoneLogin;
    private TextInputLayout tilLogin, tilPassword;
    private Button btnRegister;

    //手机验证登陆控件
    private TextView tvVerifyCode;


    private boolean isPhoneLogin = false;

    private LoginPresenter mLoginPresenter;
    @Override
    protected void initView() {

        mLoginPresenter = new LoginPresenter(this);

        etLogin = obtainView(R.id.et_login_username);
        etPassword = obtainView(R.id.et_password);
        btnRegister = obtainView(R.id.btn_register);
        btnPhoneLogin = obtainView(R.id.btn_phone_login);
        btnLogin = obtainView(R.id.btn_login);
        progressBar = obtainView(R.id.progressbar);
        tilLogin = obtainView(R.id.tl_login_name);
        tilPassword = obtainView(R.id.til_password);
        tvVerifyCode = obtainView(R.id.btn_verify_code);
        userNameLoginViewInit();
    }

    @Override
    protected void initData() {
        //获取存储
        etLogin.setText(ACache.get(this).getAsString(CacheConstants.LOGIN_USERNAME));
        etPassword.setText(ACache.get(this).getAsString(CacheConstants.LOGIN_PASSWORD));

    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void onResume() {
        super.onResume();

        //设置登录回调,resume设置回调避免被registerActivity冲掉
        mLoginPresenter.setIMLoginListener();
    }
    @Override
    protected void onPause() {
        super.onPause();
        //删除登录回调
        mLoginPresenter.removeIMLoginListener();
    }
    public static void invoke(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);
    }


    public void showLoginError(String errorString) {
        etLogin.setError(errorString);
        showOnLoading(false);
    }

    public void showPasswordError(String errorString) {
        etPassword.setError(errorString);
        showOnLoading(false);
    }


    @Override
    public void loginSuccess() {
        //登录成功
        dismissLoading();
        MainActivity.invoke(this);
        finish();
    }

    @Override
    public void loginFailed(int status, String msg) {
        dismissLoading();
        showMsg("登陆失败:" + msg);
    }

    @Override
    public void usernameError(String errorMsg) {
        etLogin.setError(errorMsg);
    }

    @Override
    public void phoneError(String errorMsg) {
        etLogin.setError(errorMsg);
    }

    @Override
    public void passwordError(String errorMsg) {
        etPassword.setError(errorMsg);
    }

    @Override
    public void verifyCodeError(String errorMsg) {
        showMsg("验证码错误");
    }

    @Override
    public void verifyCodeFailed(String errorMsg) {
        showMsg("获取验证码失败");
    }

    @Override
    public void verifyCodeSuccess(int reaskDuration, int expireDuration) {
        showMsg("注册短信下发,验证码" + expireDuration / 60 + "分钟内有效");
        OtherUtils.startTimer(new WeakReference<>(tvVerifyCode), "验证码", reaskDuration, 1);
    }

    @Override
    public void showLoading() {
        showOnLoading(true);
    }

    @Override
    public void dismissLoading() {
        showOnLoading(false);
    }

    @Override
    public void showMsg(String msg) {
        showToast(msg);
    }

    @Override
    public void showMsg(int msg) {
        showToast(msg);
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }



    /**
     * 手机验证码登录
     */
    private void phoneLoginViewinit() {

        isPhoneLogin = true;
        tvVerifyCode.setVisibility(View.VISIBLE);

        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(250);
        tvVerifyCode.setAnimation(alphaAnimation);

        //设定点击优先级于最前（避免被EditText遮挡的情况）
        tvVerifyCode.bringToFront();

        etLogin.setInputType(EditorInfo.TYPE_CLASS_PHONE);

        btnPhoneLogin.setText(getString(R.string.activity_login_normal_login));

        tilLogin.setHint(getString(R.string.activity_login_phone_num));

        tilPassword.setHint(getString(R.string.activity_login_verify_code_edit));


        tvVerifyCode.setOnClickListener( this);

        btnPhoneLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //转换为用户名登录界面
                userNameLoginViewInit();
            }
        });

        btnLogin.setOnClickListener(this);

    }

    /**
     * 用户名密码登录界面init
     */
    public void userNameLoginViewInit() {


        isPhoneLogin = false;
        tvVerifyCode.setVisibility(View.GONE);

        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(250);
        tvVerifyCode.setAnimation(alphaAnimation);

        etLogin.setInputType(EditorInfo.TYPE_CLASS_TEXT);

        etLogin.setText("");
        etPassword.setText("");

        btnPhoneLogin.setText(getString(R.string.activity_login_phone_login));

        tilLogin.setHint(getString(R.string.activity_login_username));

        tilPassword.setHint(getString(R.string.activity_login_password));


        btnRegister.setOnClickListener(this);

        btnPhoneLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //转换为手机登录界面
                phoneLoginViewinit();
            }
        });

        btnLogin.setOnClickListener(this);
    }

    /**
     * trigger loading模式
     *
     * @param active
     */
    public void showOnLoading(boolean active) {
        if (active) {
            progressBar.setVisibility(View.VISIBLE);
            btnLogin.setVisibility(View.INVISIBLE);
            etLogin.setEnabled(false);
            etPassword.setEnabled(false);
            btnPhoneLogin.setClickable(false);
            btnPhoneLogin.setTextColor(getResources().getColor(R.color.colorLightTransparentGray));
            btnRegister.setClickable(false);
        } else {
            progressBar.setVisibility(View.GONE);
            btnLogin.setVisibility(View.VISIBLE);
            etLogin.setEnabled(true);
            etPassword.setEnabled(true);
            btnPhoneLogin.setClickable(true);
            btnPhoneLogin.setTextColor(getResources().getColor(R.color.colorTransparentGray));
            btnRegister.setClickable(true);
            btnRegister.setTextColor(getResources().getColor(R.color.colorTransparentGray));
        }

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                if (isPhoneLogin) {
                    //手机登录逻辑
                    mLoginPresenter.phoneLogin(etLogin.getText().toString(), etPassword.getText().toString());
                } else {
                    //调用normal登录逻辑
                    mLoginPresenter.usernameLogin(etLogin.getText().toString(), etPassword.getText().toString());
                }

                break;
            case R.id.btn_verify_code:
                mLoginPresenter.sendVerifyCode(etLogin.getText().toString());
                break;
            case R.id.btn_register:
                RegisterActivity.invoke(this);
                break;
        }
    }
}
