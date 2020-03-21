package com.developers.projectframe.base.event;

/**
 * @Author yinzh
 * @Date 2020/3/21 10:31
 * @Description EventBus 对应事件TAG
 */
public class MessageEvent <T> {

    public static final int NO_CODE = -1;

    public static final int SWITCH_PAGE = 16;
    public static final int TOKEN_EXPIRED = 17; //token过期
    public static final int INIT_APP = 19;
    public static final int SIGN_IN = 20; //登录
    public static final int SIGN_OUT = 21; //退出
    public static final int REFRESH_LIVE_STATUS = 22; //刷新预约状态
    public static final int REFRESH_FREETOPIC_STATUS = 23; //刷新题库状态


    /**
     * 更新Adapter item状态：高亮、半圈
     */

    private T mMessage;
    private int mCode;

    public MessageEvent(T message) {
        mMessage = message;
        mCode = NO_CODE;
    }

    public MessageEvent(T message, int code) {
        mMessage = message;
        mCode = code;
    }

    public MessageEvent(int code) {
        mMessage = null;
        mCode = code;
    }

    public T getMessageBody() {
        return mMessage;
    }

    public int getType() {
        return mCode;
    }
}
