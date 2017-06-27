package com.projectdemo.zwz.liverookie.presenter;

import com.projectdemo.zwz.liverookie.http.AsyncHttp;
import com.projectdemo.zwz.liverookie.http.request.LiveListRequest;
import com.projectdemo.zwz.liverookie.http.request.RequestComm;
import com.projectdemo.zwz.liverookie.http.response.ResList;
import com.projectdemo.zwz.liverookie.http.response.Response;
import com.projectdemo.zwz.liverookie.model.LiveInfo;
import com.projectdemo.zwz.liverookie.util.AsimpleCache.ACache;
import com.projectdemo.zwz.liverookie.util.Constants;
import com.projectdemo.zwz.liverookie.util.LogDebugUtil;

import java.util.ArrayList;

/**
 * 直播列表管理
 * Created by ylzx on 2017/6/27.
 */
public class LiveListPresenter extends ILiveListPresenter {

    private static final String TAG = LiveListPresenter.class.getSimpleName();
    private boolean mHasMore;
    private boolean isLoading;
    private ArrayList<LiveInfo> mLiveInfoList = new ArrayList<>();

    private ILiveListView mLiveListView;
    public LiveListPresenter(ILiveListView liveListView) {
        super(liveListView);
        mLiveListView=liveListView;
    }

    /**
     * 获取缓存列表
     * @return
     */
    @Override
    public ArrayList<LiveInfo> getLiveListFormCache() {
        return mLiveInfoList;
    }

    @Override
    public boolean reloadLiveList() {
        LogDebugUtil.e(TAG, "fetchLiveList start");
        mLiveInfoList.clear();
        fetchLiveList(RequestComm.live_list, ACache.get(mBaseView.getContext()).getAsString("user_id"), 1, Constants.PAGESIZE);
        return true;
    }

    /**
     * 分页加载数据
     * @return
     */
    @Override
    public boolean loadDataMore() {
        if (mHasMore) {
            int pageIndex = mLiveInfoList.size() / Constants.PAGESIZE + 1;
            fetchLiveList(RequestComm.live_list_more, ACache.get(mBaseView.getContext()).getAsString("user_id"), pageIndex, Constants.PAGESIZE);
        }
        return true;
    }

    public boolean isLoading() {
        return isLoading;
    }

    public boolean isHasMore() {
        return mHasMore;
    }
    @Override
    public void start() {

    }

    @Override
    public void finish() {

    }

    /**
     * 获取直播列表
     *
     * @param type      1:拉取在线直播列表 2:拉取7天内录播列表 3:拉取在线直播和7天内录播列表，直播列表在前，录播列表在后
     * @param pageIndex 页数
     * @param pageSize  每页个数
     */
    public void fetchLiveList(final int type, final String userId, final int pageIndex, final int pageSize) {
        LiveListRequest request = new LiveListRequest(type, userId, pageIndex, pageSize);

        AsyncHttp.instance().postJson(request, new AsyncHttp.IHttpListener() {
            @Override
            public void onStart(int requestId) {
                isLoading = true;
            }

            @Override
            public void onSuccess(int requestId, Response response) {
                LogDebugUtil.e(TAG, "onSuccess");
                if (response.status == RequestComm.SUCCESS) {
                    ResList<LiveInfo> resList = (ResList<LiveInfo>) response.data;
                    if (resList != null) {
                        ArrayList<LiveInfo> result = (ArrayList<LiveInfo>) resList.items;
                        if (result != null && !result.isEmpty()) {
                            mLiveInfoList.addAll(result);
                            mHasMore = (mLiveInfoList.size() >= pageIndex * Constants.PAGESIZE);
                            if (mLiveListView != null) {
                                mLiveListView.onLiveList(0, mLiveInfoList, pageIndex == 1);
                            }
                        } else {
                            mHasMore = false;
                            if (mLiveListView != null) {
                                mLiveListView.onLiveList(0, mLiveInfoList, pageIndex == 1);
                            }
                        }
                    } else {
                        if (mLiveListView != null) {
                            mLiveListView.onLiveList(1, null, true);
                        }
                    }
                } else {
                    if (mLiveListView != null) {
                        mLiveListView.onLiveList(1, null, true);
                    }
                }
                isLoading = false;
            }

            @Override
            public void onFailure(int requestId, int httpStatus, Throwable error) {
                LogDebugUtil.e(TAG, "onFailure");
                if (mLiveListView != null) {
                    mLiveListView.onLiveList(1, null, false);
                }
                isLoading = false;
            }
        });
    }
}
