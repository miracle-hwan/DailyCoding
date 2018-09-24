package com.miraclehwan.rxjava2.network;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static final String BASE_URL = "https://api.github.com";

    private static RetrofitClient sInstance;
    private OkHttpClient client;

    public static RetrofitClient getInstance(){
        if (sInstance== null) {
            synchronized(RetrofitClient.class) {
                if (sInstance == null)
                    sInstance = new RetrofitClient();
            }
        }
        return sInstance;
    }

    private OkHttpClient getClient() {
        if (client == null){
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        }
        return client;
    }

    private Retrofit retrofit;
    public Api getApi(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(getClient())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return retrofit.create(Api.class);
    }
}
