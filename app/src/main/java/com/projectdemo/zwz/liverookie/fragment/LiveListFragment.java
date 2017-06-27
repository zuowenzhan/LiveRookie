package com.projectdemo.zwz.liverookie.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import com.projectdemo.zwz.liverookie.R;
import com.projectdemo.zwz.liverookie.adapter.LiveListAdapter;
import com.projectdemo.zwz.liverookie.base.BaseFragment;
import com.projectdemo.zwz.liverookie.model.LiveInfo;
import com.projectdemo.zwz.liverookie.presenter.ILiveListPresenter;
import com.projectdemo.zwz.liverookie.presenter.LiveListPresenter;
import com.projectdemo.zwz.liverookie.ui.list.ListFootView;
import com.projectdemo.zwz.liverookie.ui.listload.ProgressBarHelper;
import com.projectdemo.zwz.liverookie.util.Constants;
import com.projectdemo.zwz.liverookie.util.LogDebugUtil;
import com.projectdemo.zwz.liverookie.util.ToastUtils;

import java.util.ArrayList;

/**
 * Created by ylzx on 2017/6/26.
 */
public class LiveListFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener, ILiveListPresenter.ILiveListView
        , ProgressBarHelper.ProgressBarClickListener, AbsListView.OnScrollListener {
    public static final int START_LIVE_PLAY = 100;
    private static final String TAG = "LiveListFragment";
    private ListView mVideoListView;
    private LiveListAdapter mVideoListViewAdapter;
    private SwipeRefreshLayout mSwipeRefreshLayout;

    //避免连击
    private long mLastClickTime = 0;
    private int mListType;
    private LiveListPresenter mLiveListPresenter;
    protected ProgressBarHelper pbHelp;

    ListFootView mListFootView;

    public LiveListFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        mListType = arguments.getInt("LISTTYPE", 0);
    }

    public static LiveListFragment newInstance(int listType) {
        LiveListFragment fragment = new LiveListFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("LISTTYPE", listType);
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_live_list;
    }

    @Override
    protected void initView(View view) {
        mSwipeRefreshLayout = obtainView(R.id.swipe_refresh_layout_list);
        mSwipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light, android.R.color.holo_orange_light, android.R.color.holo_red_light);
        mSwipeRefreshLayout.setOnRefreshListener(this);

        mLiveListPresenter = new LiveListPresenter(this);
        mVideoListView = obtainView(R.id.live_list);
        mVideoListViewAdapter = new LiveListAdapter(getActivity(),
                new ArrayList<LiveInfo>());
        mVideoListView.setAdapter(mVideoListViewAdapter);
        pbHelp = new ProgressBarHelper(getActivity(), obtainView(R.id.ll_data_loading));

        mListFootView = new ListFootView(mContext);
        mVideoListView.addFooterView(mListFootView);

    }

    @Override
    protected void initData() {
        refreshListView();
    }

    @Override
    protected void setListener(View view) {
        mVideoListView.setOnScrollListener(this);
        mVideoListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                if (0 == mLastClickTime || System.currentTimeMillis() - mLastClickTime > 1000) {
                    LiveInfo item = mVideoListViewAdapter.getItem(i);
                    if (item == null) {
                        Log.e(TAG, "live list item is null at position:" + i);
                        return;
                    }
                    startLivePlay(item);
                }
                mLastClickTime = System.currentTimeMillis();

            }
        });
        pbHelp.setProgressBarClickListener(this);
    }

    @Override
    public void onRefresh() {
        refreshListView();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        LogDebugUtil.e(TAG, "onHiddenChanged:" + hidden + ",mListType:" + mListType);
        if (!hidden) {
            refreshListView();
        }
    }

    /**
     * 刷新直播列表
     */
    private void refreshListView() {
        if (mLiveListPresenter.reloadLiveList()) {
            mSwipeRefreshLayout.post(new Runnable() {
                @Override
                public void run() {
                    mSwipeRefreshLayout.setRefreshing(true);
                }
            });
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (START_LIVE_PLAY == requestCode) {
            if (0 != resultCode) {
                //观看直播返回错误信息后，刷新列表，但是不显示动画
                mLiveListPresenter.reloadLiveList();
            } else {
                if (data == null) {
                    return;
                }
                //更新列表项的观看人数和点赞数
                String userId = data.getStringExtra(Constants.PUSHER_ID);
                for (int i = 0; i < mVideoListViewAdapter.getCount(); i++) {
                    LiveInfo info = mVideoListViewAdapter.getItem(i);
                    if (info != null && info.userId.equalsIgnoreCase(userId)) {
                        info.viewCount = (int) data.getLongExtra(Constants.MEMBER_COUNT, info.viewCount);
                        info.likeCount = (int) data.getLongExtra(Constants.HEART_COUNT, info.likeCount);
                        mVideoListViewAdapter.notifyDataSetChanged();
                        break;
                    }
                }
            }
        }
    }

    /**
     * 开始播放视频
     *
     * @param item 视频数据
     */
    private void startLivePlay(final LiveInfo item) {
//        Intent intent = new Intent(getActivity(), LivePlayerActivity.class);
//        intent.putExtra(Constants.PUSHER_ID, TextUtils.isEmpty(item.userId) ? item.userInfo.userId : item.userId);
//        intent.putExtra(Constants.PLAY_URL, item.playUrl);
//        intent.putExtra(Constants.PUSHER_NAME, item.userInfo.nickname == null ? item.userId : item.userInfo.nickname);
//        intent.putExtra(Constants.PUSHER_AVATAR, item.userInfo.headPic);
//        intent.putExtra(Constants.HEART_COUNT, "" + item.likeCount);
//        intent.putExtra(Constants.MEMBER_COUNT, "" + item.viewCount);
//        intent.putExtra(Constants.GROUP_ID, item.groupId);
//        intent.putExtra(Constants.PLAY_TYPE, item.type == 0);
//        intent.putExtra(Constants.FILE_ID, item.fileId);
//        intent.putExtra(Constants.COVER_PIC, item.userInfo.frontcover);
//        intent.putExtra(Constants.LIVEID, item.liveId);
//        startActivityForResult(intent, START_LIVE_PLAY);
    }

    @Override
    public void onLiveList(int retCode, ArrayList<LiveInfo> result, boolean refresh) {
        if (retCode == 0) {
            mVideoListViewAdapter.clear();
            if (result != null && result.size() > 0) {
                mVideoListViewAdapter.addAll(result);
                pbHelp.goneLoading();
            } else {
                pbHelp.showNoData();
            }
            if (refresh) {
                mVideoListViewAdapter.notifyDataSetChanged();
            }
        }  else {
            ToastUtils.showShort(mContext, "刷新列表失败");
            pbHelp.showNetError();
        }
        mSwipeRefreshLayout.setRefreshing(false);
        if (!mLiveListPresenter.isHasMore()) {
            mListFootView.setLoadDone();
        }
    }

    private int visibleLast;

    @Override
    public void onScrollStateChanged(AbsListView absListView, int scrollState) {
        int itemsLastIndex = mVideoListViewAdapter.getCount();
        if (itemsLastIndex < 0) {
            return;
        }
        int lastIndex = itemsLastIndex;
        LogDebugUtil.e(TAG, "visibleLast:" + visibleLast + ",lastIndex:" + lastIndex);
        //列表滑动停止时候
        //并且当前最后显示的条数大于 相等列表总数，然后加载更多

        if (scrollState == ListView.OnScrollListener.SCROLL_STATE_IDLE &&
                visibleLast >= lastIndex && !mLiveListPresenter.isLoading()) {
            mLiveListPresenter.loadDataMore();
        }
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        visibleLast = firstVisibleItem + visibleItemCount - 1;
        //1是foot view。
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void dismissLoading() {

    }

    @Override
    public void showMsg(String msg) {
        ToastUtils.showShort(mContext, msg);
    }

    @Override
    public void showMsg(int msg) {
        ToastUtils.showShort(mContext, msg);
    }

    @Override
    public void clickRefresh() {
        refreshListView();
    }
}
