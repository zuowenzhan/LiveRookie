package com.projectdemo.zwz.liverookie.http.request;

import com.google.gson.reflect.TypeToken;
import com.projectdemo.zwz.liverookie.http.response.ResList;
import com.projectdemo.zwz.liverookie.http.response.Response;
import com.projectdemo.zwz.liverookie.model.LiveInfo;

import java.lang.reflect.Type;

/**
 * 直播列表请求
 * Created by ylzx on 2017/6/27.
 */
public class LiveListRequest extends IRequest {

    public LiveListRequest(int requestId, String userId , int pageIndex, int pageSize) {
        mRequestId = requestId;
//		mParams.put("action","liveList");
        mParams.put("action","liveListTest");//测试加载更多
        mParams.put("userId",userId);
        mParams.put("pageIndex", pageIndex);
        mParams.put("pageSize", pageSize);
    }

    @Override
    public String getUrl() {
        return getHost() + "Live";
    }

    @Override
    public Type getParserType() {
        return new TypeToken<Response<ResList<LiveInfo>>>() {}.getType();
    }
}
