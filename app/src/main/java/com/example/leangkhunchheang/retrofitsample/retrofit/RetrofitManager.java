package com.example.leangkhunchheang.retrofitsample.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ben on 9/4/2017.
 */

public class RetrofitManager {

    private static Retrofit.Builder sInstance;

    private static Retrofit.Builder getInstance() {
        if (sInstance == null) {
            synchronized (RetrofitManager.class) {
                if (sInstance == null) {
                    sInstance = new Retrofit.Builder();
                }
            }
        }
        return sInstance;
    }

    private static Retrofit getRetrofit(String url) {
        return RetrofitManager.getInstance()
                .client(OKHttpManager.getInstance())
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static Retrofit getAPIManager(String api) {
        return RetrofitManager.getRetrofit(api);
    }
}
