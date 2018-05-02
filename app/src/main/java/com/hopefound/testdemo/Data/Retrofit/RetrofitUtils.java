package com.hopefound.testdemo.Data.Retrofit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 王震 on 2018/4/20 0020.
 * boxed a retrofit abstract class useing okhttp3
 */

public abstract class RetrofitUtils {
    private static Retrofit mRetrofit;
    private static OkHttpClient mOkHttpClient;

    /**
     * get retrofit
     * @return
     */
    protected static Retrofit getRetrofit(){
        if (null == mRetrofit){
            if (null == mOkHttpClient){
                mOkHttpClient = OkHttpUtils.getOkHttpClient();
            }

            mRetrofit = new Retrofit.Builder()
                    .baseUrl("123/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .client(mOkHttpClient)
                    .build();
        }
        return mRetrofit;
    }
}
