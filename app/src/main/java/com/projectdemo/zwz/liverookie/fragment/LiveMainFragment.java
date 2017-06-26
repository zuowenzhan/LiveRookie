package com.projectdemo.zwz.liverookie.fragment;

import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.projectdemo.zwz.liverookie.R;
import com.projectdemo.zwz.liverookie.base.BaseActivity;
import com.projectdemo.zwz.liverookie.base.BaseFragment;
import com.projectdemo.zwz.liverookie.presenter.LiveMainPresenter;
import com.projectdemo.zwz.liverookie.ui.pagersliding.PagerSlidingTabStrip;

/**
 * Created by ylzx on 2017/6/26.
 */
public class LiveMainFragment extends BaseFragment {


    private LiveMainPresenter mMainPresenter;
    private ViewPager mViewPager;
    private PagerSlidingTabStrip mTabStrip;

    @Override
    protected void initData() {
        mMainPresenter = new LiveMainPresenter((BaseActivity) getActivity());
        mViewPager.setAdapter(mMainPresenter.getAdapter());
        mTabStrip.setViewPager(mViewPager);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_live_main;
    }

    @Override
    protected void initView(View rootView) {
        mViewPager = obtainView(R.id.viewpager);
        mTabStrip = obtainView(R.id.tab_strip);

        mTabStrip.setTextColorResource(R.color.white);
        mTabStrip.setIndicatorColorResource(R.color.white);
        mTabStrip.setDividerColor(Color.TRANSPARENT);
        mTabStrip.setTextSelectedColorResource(R.color.white);
        mTabStrip.setTextSize(getResources().getDimensionPixelSize(R.dimen.h6));
        mTabStrip.setTextSelectedSize(getResources().getDimensionPixelSize(R.dimen.h10));
        mTabStrip.setUnderlineHeight(1);
    }

    @Override
    protected void setListener() {

    }
}
