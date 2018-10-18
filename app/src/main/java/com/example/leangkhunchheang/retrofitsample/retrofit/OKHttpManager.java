package com.example.leangkhunchheang.retrofitsample.retrofit;

import java.util.concurrent.TimeUnit;

import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by Ben on 9/4/2017.
 */

public class OKHttpManager {
    private static OkHttpClient sInstance;

    public static OkHttpClient getInstance() {
        if (sInstance == null) {
            synchronized (OKHttpManager.class) {
                if (sInstance == null) {
                    ConnectionPool connectionPool = new ConnectionPool(10, 10, TimeUnit.MILLISECONDS);
                    HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
                    logging.setLevel(HttpLoggingInterceptor.Level.BASIC);
                    sInstance = new OkHttpClient().newBuilder()
                            .readTimeout(30, TimeUnit.SECONDS)
                            .writeTimeout(30, TimeUnit.SECONDS)
                            .connectTimeout(30, TimeUnit.SECONDS)
                            .retryOnConnectionFailure(true)
                            .connectionPool(connectionPool)
                            /*.addInterceptor(logging)
                            .cache(new Cache(AppApplication.getContext().getCacheDir(), 10 * 1024 * 1024)) // 10 MB*/
                            .addInterceptor(new HeaderIntercepter())
                            .build();
                }
            }
        }
        return sInstance;
    }
}
