package com.projectdemo.zwz.liverookie.presenter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.projectdemo.zwz.liverookie.base.BaseActivity;
import com.projectdemo.zwz.liverookie.fragment.LiveListFragment;

/**
 * Created by ylzx on 2017/6/26.
 */
public class LiveMainPresenter {

    private static final int TYPE_LIST = 0;
    private static final int TYPE_DOYEN = 1;

    public static final String[] TITLE = new String[]{"最新", "最热", "达人", "美女",};
    public static final int[] TYPE = new int[]{TYPE_LIST, TYPE_LIST, TYPE_DOYEN, TYPE_LIST};

    private static final String TAG = LiveMainPresenter.class.getName();

    private BaseActivity mContext;

    public LiveMainPresenter(BaseActivity context) {
        mContext = context;
    }

    public FragmentStatePagerAdapter getAdapter() {
        return new LiveMainPresenter.PagerAdapter(mContext.getSupportFragmentManager());
    }


    class PagerAdapter extends FragmentStatePagerAdapter {

        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (TYPE[position] == TYPE_LIST) {
                return LiveListFragment.newInstance(TYPE[position]);
            } else {
                return LiveListFragment.newInstance(TYPE[position]);
            }
        }

        @Override
        public int getCount() {
            return TITLE.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return TITLE[position];
        }
    }
}
