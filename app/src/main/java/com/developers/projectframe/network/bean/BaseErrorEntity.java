package com.developers.projectframe.network.bean;

/**
 * @Author yinzh
 * @Date 2020/3/21 10:30
 * @Description
 */
public class BaseErrorEntity {
    public BaseErrorEntity error;

    private String code;
    private String message;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
