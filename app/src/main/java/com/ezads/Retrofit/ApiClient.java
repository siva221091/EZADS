package com.ezads.Retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

  //  public static final String BASE_URL = "http://10.0.2.2:9001";
    public static final String BASE_URL = "http://13.126.74.228:9001";
    private static Retrofit retrofit = null;


    public static Retrofit getRetrofitClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }


}
