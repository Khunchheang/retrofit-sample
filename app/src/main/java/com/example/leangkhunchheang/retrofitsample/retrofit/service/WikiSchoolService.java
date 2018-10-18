package com.example.leangkhunchheang.retrofitsample.retrofit.service;

import com.example.leangkhunchheang.retrofitsample.TokenMdelResponse;
import com.example.leangkhunchheang.retrofitsample.retrofit.RetrofitManager;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public class WikiSchoolService {

    private static final String WikiSchool_API = "http://api-testing.wikischool.asia:65522/api/";

    public interface WikiSchoolManager {

        @FormUrlEncoded
        @POST("token")
        Call<TokenMdelResponse> registerUser(
                @Field("username") String username,
                @Field("password") String password,
                @Field("grant_type") String grantType
        );
    }

    public static WikiSchoolManager getWikiApiManager() {
        return RetrofitManager.getAPIManager(WikiSchool_API).create(WikiSchoolManager.class);
    }

}
