package com.projectdemo.zwz.liverookie.fragment;

import android.os.Bundle;
import android.view.View;

import com.projectdemo.zwz.liverookie.R;
import com.projectdemo.zwz.liverookie.base.BaseFragment;

/**
 * Created by ylzx on 2017/6/26.
 */
public class LiveListFragment extends BaseFragment {
    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutId() {
        return  R.layout.fragment_live_list;
    }

    @Override
    protected void initView(View rootView) {

    }

    @Override
    protected void setListener() {

    }

    public static LiveListFragment newInstance(int listType) {
        LiveListFragment fragment = new LiveListFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("LISTTYPE", listType);
        fragment.setArguments(bundle);
        return fragment;
    }
}
