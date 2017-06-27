package com.projectdemo.zwz.liverookie.model;

/**
 * 直播信息
 * Created by ylzx on 2017/6/27.
 */
public class LiveInfo {
    public String userId;
    public String groupId;
    public String liveId;
    public int createTime;
    public int      type;
    public int viewCount;
    public int likeCount;
    public String   title;
    public String playUrl;
    public String fileId;
    public String liveCover;

    //TCLiveUserInfo
    public TCLiveUserInfo userInfo;


    public class TCLiveUserInfo {
        public String userId;
        public String nickname;
        public String headPic;
        public String frontcover;
        public String location;
    }
}
