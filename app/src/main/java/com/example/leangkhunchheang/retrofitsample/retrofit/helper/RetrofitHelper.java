package com.example.leangkhunchheang.retrofitsample.retrofit.helper;

import android.net.Uri;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class RetrofitHelper {

    public static MultipartBody.Part fileRequest(Uri uri, String field) {
        File file = null;
        if (uri != null) {
            file = new File(uri.getPath());
        }

        RequestBody imageFile;
        MultipartBody.Part body = null;
        MediaType mediaType = MediaType.parse("image/*");
        if (file != null) {
            imageFile = RequestBody.create(mediaType, file);
            body = MultipartBody.Part.createFormData(field, file.getName(), imageFile);
        }

        return body;
    }

    public static RequestBody textRequestBody(String text) {
        MediaType mediaType1 = MediaType.parse("text/plain");
        return RequestBody.create(mediaType1, text);
    }
}

