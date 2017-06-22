package com.projectdemo.zwz.liverookie.model;


import com.projectdemo.zwz.liverookie.http.IDontObfuscate;

/**
 * @description: 礼物详情
 *
 * @author: Andruby
 * @time: 2016/11/4 14:12
 */
public class GiftInfo extends IDontObfuscate {
    private String giftId;//礼物id
    private String giftName;//礼物图片
    private String imageUrl;//礼物名称
    private String gifUrl;//礼物gif图片地址
    private float giftPrice;//礼物的单价
    private int giftType;//礼物的类型 1、免费 2、付费
    private int giftCount;//送出的礼物数

    private int limitTime = 10;//送出的礼物数
    private int CurrentTime;//送出的礼物数
    private int limitCount = 3;//送出的礼物数
    private int CurrentCount;//送出的礼物数
    private boolean isCountDown;//送出的礼物数

    public GiftInfo(String giftId, String giftName, float giftPrice, String gifUrl) {
        this.giftId = giftId;
        this.giftName = giftName;
        this.giftPrice = giftPrice;
        this.gifUrl = gifUrl;
    }

    public String getGiftId() {
        return giftId;
    }

    public void setGiftId(String giftId) {
        this.giftId = giftId;
    }

    public String getGiftName() {
        return giftName;
    }

    public void setGiftName(String giftName) {
        this.giftName = giftName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getGifUrl() {
        return gifUrl;
    }

    public void setGifUrl(String gifUrl) {
        this.gifUrl = gifUrl;
    }

    public float getGiftPrice() {
        return giftPrice;
    }

    public void setGiftPrice(float giftPrice) {
        this.giftPrice = giftPrice;
    }

    public int getGiftType() {
        return giftType;
    }

    public void setGiftType(int giftType) {
        this.giftType = giftType;
    }

    public int getGiftCount() {
        return giftCount;
    }

    public void setGiftCount(int giftCount) {
        this.giftCount = giftCount;
    }

    public int getLimitTime() {
        return limitTime;
    }

    public void setLimitTime(int limitTime) {
        this.limitTime = limitTime;
    }

    public int getLimitCount() {
        return limitCount;
    }

    public void setLimitCount(int limitCount) {
        this.limitCount = limitCount;
    }

    public int getCurrentTime() {
        return CurrentTime;
    }

    public void setCurrentTime(int currentTime) {
        CurrentTime = currentTime;
    }

    public boolean isCountDown() {
        return isCountDown;
    }

    public void setCountDown(boolean countDown) {
        isCountDown = countDown;
    }

    public int getCurrentCount() {
        return CurrentCount;
    }

    public void setCurrentCount(int currentCount) {
        CurrentCount = currentCount;
    }

    @Override
    public String toString() {
        return "GiftInfo{" +
                "giftId='" + giftId + '\'' +
                ", giftName='" + giftName + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", gifUrl='" + gifUrl + '\'' +
                ", giftPrice=" + giftPrice +
                ", giftCount=" + giftCount +
                ", giftType=" + giftType +
                '}';
    }
}
