package com.hopefound.testdemo.entity;

/**
 * Created by 王震 on 2018/4/20 0020.
 */

public class HttpResult<T> {

    /**
     * data : []
     * requestTime : 2016-11-02 14:00:25
     * code : 1
     */

    private String requestTime;
    private int code;
    private T data;

    public String getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(String requestTime) {
        this.requestTime = requestTime;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
