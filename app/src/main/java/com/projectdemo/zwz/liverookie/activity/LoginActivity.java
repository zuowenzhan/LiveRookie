package com.projectdemo.zwz.liverookie.activity;

import android.content.Context;
import android.content.Intent;

import com.projectdemo.zwz.liverookie.R;
import com.projectdemo.zwz.liverookie.base.BaseActivity;

public class LoginActivity extends BaseActivity {


    @Override
    protected void initView() {
      setContentView(R.layout.activity_login);
    }

    @Override
    protected void initData() {

    }


    public static void invoke(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);
    }
}
