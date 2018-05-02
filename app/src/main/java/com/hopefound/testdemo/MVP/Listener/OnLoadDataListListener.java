package com.hopefound.testdemo.MVP.Listener;

/**
 * Created by 王震 on 2018/4/20 0020.
 */

public interface OnLoadDataListListener <T>{
    void onSuccess(T data);
    void onFailure(Throwable e);
}
