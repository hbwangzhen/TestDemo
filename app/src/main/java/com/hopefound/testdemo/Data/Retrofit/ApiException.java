package com.hopefound.testdemo.Data.Retrofit;

import com.hopefound.testdemo.entity.HttpResult;

/**
 * Created by 王震 on 2018/4/20 0020.
 */

public class ApiException extends RuntimeException {

    public ApiException(HttpResult httpResult){
        this(getApiExceptionMessage(httpResult));
    }

    public ApiException(String detailMessage){
        super(detailMessage);
    }

    /**
     * deal the data of sevice return
     * don't need adjuge in activity
     */

    private static String getApiExceptionMessage(HttpResult httpResult){
        String message = "";
        switch (httpResult.getCode()){
            default:
                message = "net errer" + httpResult.getCode();
        }
        return message;
    }

}
