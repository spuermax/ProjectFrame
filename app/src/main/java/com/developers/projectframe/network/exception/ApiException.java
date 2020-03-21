package com.developers.projectframe.network.exception;

import android.text.TextUtils;

import com.developers.projectframe.base.event.MessageEvent;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.greenrobot.eventbus.EventBus;

import okhttp3.ResponseBody;

/**
 * @Author yinzh
 * @Date 2020/3/21 10:19
 * @Description 根据自己业务做处理
 */
public class ApiException extends Exception {
    private String code;
    private String displayMessage;
    private ResponseBody errorBody;

    /**
     * TOKEN失效
     */
    private static final String TOKEN_EXPIRED = "401";
    /**
     * error
     */
    private static final String ERROR_EXPIRED = "500";


    public ApiException(String code, String displayMessage) {
        this.code = code;
        this.displayMessage = displayMessage;

        setErrorType();
    }

    public ApiException(String code, String displayMessage, ResponseBody body) {
        super(displayMessage);
        this.code = code;
        this.displayMessage = displayMessage;
        this.errorBody = body;

        setErrorType();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDisplayMessage() {
        try {
            JsonObject errorResult = new Gson().fromJson(errorBody.string(), JsonObject.class);
            return errorResult.get("message") != null ? errorResult.get("message").getAsString() : "";
        } catch (Exception e) {
            e.printStackTrace();
            return displayMessage;
        }
    }

    public void setDisplayMessage(String displayMessage) {
        this.displayMessage = displayMessage;
    }


    /**
     * 处理不同异常
     */
    private void setErrorType() {
        switch (code) {
            case TOKEN_EXPIRED:
                EventBus.getDefault().post(new MessageEvent<>(MessageEvent.TOKEN_EXPIRED));
                break;
            case ERROR_EXPIRED:
                try {
                    JsonObject errorResult = new Gson().fromJson(errorBody.string(), JsonObject.class);
                    String message = errorResult.get("message") != null ? errorResult.get("message").getAsString() : "";
                    displayMessage = message;

                    if (!TextUtils.isEmpty(message) && (message.startsWith("API Token 已过期") || message.startsWith("API Token不正确！"))) {
                        EventBus.getDefault().post(new MessageEvent<>(MessageEvent.TOKEN_EXPIRED));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            default:
                break;
        }
    }
}

