package com.projectdemo.zwz.liverookie;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;

import com.projectdemo.zwz.liverookie.base.BaseActivity;
import com.projectdemo.zwz.liverookie.fragment.LiveMainFragment;
import com.projectdemo.zwz.liverookie.fragment.UserInfoFragment;

public class MainActivity extends BaseActivity {

    private FragmentTabHost mTabHost;

    private final Class mTabFangment[] = {LiveMainFragment.class, Fragment.class, UserInfoFragment.class};
    private int mTabIcons[] = {R.drawable.tab_live_selector, R.drawable.tab_room_selector, R.drawable.tab_me_selector};
    private String mTabNames[] = {"video", "publish", "user"};

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        mTabHost = obtainView(android.R.id.tabhost);

        mTabHost.setup(this, getSupportFragmentManager(), R.id.contentPanel);
    }

    @Override
    protected void initData() {
        int fragmentCount = mTabFangment.length;
        TabHost.TabSpec tabSpec;
        for (int i = 0; i < fragmentCount; i++) {
            tabSpec = mTabHost.newTabSpec(mTabNames[i]).setIndicator(getTabItemView(i));
            mTabHost.addTab(tabSpec, mTabFangment[i], null);
        }
    }


    private View getTabItemView(int index) {
        View view;
        if (index % 2 == 0) {
            view = LayoutInflater.from(this).inflate(R.layout.tab_button1, null);
        } else {
            view = LayoutInflater.from(this).inflate(R.layout.tab_button, null);
        }
        ImageView icon = (ImageView) view.findViewById(R.id.tab_icon);
        icon.setImageResource(mTabIcons[index]);
        return view;
    }
    @Override
    protected void setListener() {

    }

    public static void invoke(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }
}
