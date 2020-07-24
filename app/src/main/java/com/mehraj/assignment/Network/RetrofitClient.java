package com.mehraj.assignment.Network;

import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    API myAPI;
    retrofit2.Retrofit retrofit;
    public RetrofitClient() {

      this.retrofit = new retrofit2.Retrofit.Builder()
                .baseUrl(API_URLS.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    public API getAPIClient() {
        this.myAPI = retrofit.create(API.class);
        return myAPI;
    }






}
