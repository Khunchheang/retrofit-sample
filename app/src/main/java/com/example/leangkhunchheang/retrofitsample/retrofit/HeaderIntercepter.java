package com.example.leangkhunchheang.retrofitsample.retrofit;

import android.support.annotation.NonNull;

import java.io.IOException;

import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Ben on 5/8/2018.
 */

public class HeaderIntercepter implements Interceptor {
    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {

        String authToken = Credentials.basic("AndroidApp", "ayrYcsne2N87ZDrEyPQp7FEeY6TEPY");

        Request request = chain.request().newBuilder()
                .addHeader("Authorization", authToken)
                .header("Content-Type", "application/x-www-form-urlencoded")
                .build();
        return chain.proceed(request);
    }
}
