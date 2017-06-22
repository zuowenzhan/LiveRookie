package com.projectdemo.zwz.liverookie.util;

/**
 * @description: 静态函数
 *
 * @author: Andruby
 * @time: 2016/12/17 10:23
 */
public class Constants {

    /**
     * 腾讯云服务配置专区（请自主替换）发布使用
     */
    //云通信服务相关配置
    public static int IMSDK_ACCOUNT_TYPE = 8151;
    public static int IMSDK_APPID = 1400017195;

    //COS存储服务相关配置
    public static final String COS_BUCKET = "xiaolive";
    public static final String COS_APPID = "1251373822";

    //业务Server的Http配置
    //    public static final String SVR_POST_URL = "http://192.168.0.106:8093/interface.php";
    //    public static final String SVR_POST_URL = "http://192.168.31.92:8093/interface.php";
    public static final String SVR_POST_URL = "http://192.168.31.92:8094/Api/Live";


    /**
     * 常量字符串
     */
    public static final String USER_INFO = "user_info";
    public static final String USER_ID = "user_id";
    public static final String USER_SIG = "user_sig";
    public static final String USER_NICK = "user_nick";
    public static final String USER_SIGN = "user_sign";
    public static final String USER_HEADPIC = "user_headpic";
    public static final String USER_COVER = "user_cover";
    public static final String USER_LOC = "user_location";
    public static final String SVR_RETURN_CODE = "status";
    public static final String SVR_RETURN_MSG = "returnMsg";
    public static final String SVR_RETURN_DATA = "returnData";

    //主播退出广播字段
    public static final String EXIT_APP = "EXIT_APP";

    public static final int USER_INFO_MAXLEN = 20;
    public static final int TV_TITLE_MAX_LEN = 30;
    public static final int NICKNAME_MAX_LEN = 20;

    //直播类型
    public static final int RECORD_TYPE_CAMERA = 991;
    public static final int RECORD_TYPE_SCREEN = 992;


    //码率
    public static final int BITRATE_SLOW = 900;
    public static final int BITRATE_NORMAL = 1200;
    public static final int BITRATE_FAST = 1600;

    //直播端右下角listview显示type
    public static final int TEXT_TYPE = 0;
    public static final int MEMBER_ENTER = 1;
    public static final int MEMBER_EXIT = 2;
    public static final int PRAISE = 3;

    public static final int LOCATION_PERMISSION_REQ_CODE = 1;
    public static final int WRITE_PERMISSION_REQ_CODE = 2;

    public static final String PUBLISH_URL = "publish_url";
    public static final String ROOM_ID = "room_id";
    public static final String ROOM_TITLE = "room_title";
    public static final String COVER_PIC = "cover_pic";
    public static final String BITRATE = "bitrate";
    public static final String GROUP_ID = "group_id";
    public static final String PLAY_URL = "play_url";
    public static final String PLAY_TYPE = "play_type";
    public static final String PUSHER_AVATAR = "pusher_avatar";
    public static final String PUSHER_ID = "pusher_id";
    public static final String PUSHER_NAME = "pusher_name";
    public static final String MEMBER_COUNT = "member_count";
    public static final String HEART_COUNT = "heart_count";
    public static final String FILE_ID = "file_id";
    public static final String ACTIVITY_RESULT = "activity_result";
    public static final String LIVEID = "live_id";

    public static final String CMD_KEY = "userAction";
    public static final String DANMU_TEXT = "actionParam";

    public static final String NOTIFY_QUERY_USERINFO_RESULT = "notify_query_userinfo_result";

    /**
     * IM 互动消息类型
     */
    public static final int IMCMD_PAILN_TEXT = 1;   // 文本消息
    public static final int IMCMD_ENTER_LIVE = 2;   // 用户加入直播
    public static final int IMCMD_EXIT_LIVE = 3;   // 用户退出直播
    public static final int IMCMD_PRAISE = 4;   // 点赞消息
    public static final int IMCMD_DANMU = 5;   // 弹幕消息


    //ERROR CODE TYPE
    public static final int ERROR_GROUP_NOT_EXIT = 10010;
    public static final int ERROR_QALSDK_NOT_INIT = 6013;
    public static final int ERROR_JOIN_GROUP_ERROR = 10015;
    public static final int SERVER_NOT_RESPONSE_CREATE_ROOM = 1002;
    public static final int NO_LOGIN_CACHE = 1265;


    /**
     * 用户可见的错误提示语
     */
    public static final String ERROR_MSG_NET_DISCONNECTED = "网络异常，请检查网络";

    //直播端错误信息
    public static final String ERROR_MSG_CREATE_GROUP_FAILED = "创建直播房间失败,Error:";
    public static final String ERROR_MSG_GET_PUSH_URL_FAILED = "拉取直播推流地址失败,Error:";
    public static final String ERROR_MSG_OPEN_CAMERA_FAIL = "无法打开摄像头，需要摄像头权限";
    public static final String ERROR_MSG_OPEN_MIC_FAIL = "无法打开麦克风，需要麦克风权限";
    public static final String ERROR_MSG_RECORD_PERMISSION_FAIL = "无法进行录屏,需要录屏权限";
    public static final String ERROR_MSG_NO_LOGIN_CACHE = "您的帐号已在其它地方登陆";

    //播放端错误信息
    public static final String ERROR_MSG_GROUP_NOT_EXIT = "直播已结束，加入失败";
    public static final String ERROR_MSG_JOIN_GROUP_FAILED = "加入房间失败，Error:";
    public static final String ERROR_MSG_LIVE_STOPPED = "直播已结束";
    public static final String ERROR_MSG_NOT_QCLOUD_LINK = "非腾讯云链接，若要放开限制请联系腾讯云商务团队";
    public static final String ERROR_RTMP_PLAY_FAILED = "视频流播放失败，Error:";

    public static final String TIPS_MSG_STOP_PUSH = "当前正在直播，是否退出直播？";

    //网络类型
    public static final int NETTYPE_WIFI = 0;
    public static final int NETTYPE_NONE = 1;
    public static final int NETTYPE_2G = 2;
    public static final int NETTYPE_3G = 3;
    public static final int NETTYPE_4G = 4;
}
