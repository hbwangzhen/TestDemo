package com.hopefound.testdemo.Data.Retrofit;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by 王震 on 2018/4/20 0020.
 * okHttp 配置请求头
 */

public class OkHttpUtils {
    private static OkHttpClient mOkHttpClient;

    public static OkHttpClient getOkHttpClient(){
        if (null == mOkHttpClient){
            mOkHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(mTokenInterceptor)
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .writeTimeout(30,TimeUnit.SECONDS)
                    .readTimeout(30,TimeUnit.SECONDS)
                    .build();
        }
        return mOkHttpClient;
    }

    /**
     * 响应头拦截器
     * 添加同意的请求头
     * 主要用于加密传输 和设备数据传输
     */

    private static final Interceptor mTokenInterceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request originalRequest = chain.request();
            Request authorised = originalRequest.newBuilder()
                    .header("token","123")
                    .build();
            return chain.proceed(authorised);
        }
    };
}
