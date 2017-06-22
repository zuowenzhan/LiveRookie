package com.projectdemo.zwz.liverookie.http.request;


import com.google.gson.reflect.TypeToken;
import com.projectdemo.zwz.liverookie.http.response.Response;
import com.projectdemo.zwz.liverookie.http.response.UploadResp;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Type;


/**
 * @description: 图片上传请求
 *
 * @author: Andruby
 * @time: 2016/11/2 18:07
 */
public class UploadPicRequest  extends IRequest {

    public UploadPicRequest(int requestId, String userId, String type, File file) throws FileNotFoundException {
        mRequestId = requestId;
        mParams.put("userId",userId);
        mParams.put("type",type);
        mParams.put("file",file);
    }

    @Override
    public String getUrl() {
        return getHost() + "Image/upload";
    }

    @Override
    public Type getParserType() {
        return new TypeToken<Response<UploadResp>>() {}.getType();
    }
}