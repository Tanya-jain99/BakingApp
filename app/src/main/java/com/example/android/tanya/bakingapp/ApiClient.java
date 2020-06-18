package com.example.android.tanya.bakingapp;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
   private static  ApiClient instance;
    private static final String BASE_URL = "https://d17h27t6h515a5.cloudfront.net/";
    public Retrofit base;

    public static ApiClient getInstance() {
        if (instance == null)
            instance = new ApiClient();

        return instance;
    }

    private ApiClient() {
        base = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    public Api getRecipie(){
        return base.create(Api.class);
    }
}
