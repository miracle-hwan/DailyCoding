package com.miraclehwan.paging.network;

import com.miraclehwan.paging.model.StackApiResonse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {
    @GET("answers")
    Call<StackApiResonse> getAnswers(@Query("page") int page, @Query("pagesize") int pagesize, @Query("site") String site);
}
