package com.example.leangkhunchheang.retrofitsample;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.leangkhunchheang.retrofitsample.retrofit.helper.RetrofitHelper;
import com.example.leangkhunchheang.retrofitsample.retrofit.service.WikiSchoolService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String USERNAME = "010721854";
    private static final String PASSWORD = "010721854";
    private static final String GRANT_TYPE = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView = findViewById(R.id.hello);

        Call<TokenMdelResponse> call = WikiSchoolService.getWikiApiManager().registerUser(USERNAME, PASSWORD, GRANT_TYPE);
        call.enqueue(new Callback<TokenMdelResponse>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(Call<TokenMdelResponse> call, Response<TokenMdelResponse> response) {
                TokenMdelResponse tokenReponse = response.body();
                if (response.isSuccessful()) {
                    textView.setText(tokenReponse.getAccessToken() + "\n" + tokenReponse.getTokenType() + "\n" + tokenReponse.getRefreshToken() + "\n" + tokenReponse.getExpiresIn());
                }
            }

            @Override
            public void onFailure(Call<TokenMdelResponse> call, Throwable t) {

            }
        });
    }
}
