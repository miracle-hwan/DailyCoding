package com.miraclehwan.rxjava2.network;

import com.miraclehwan.rxjava2.model.User;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Api {

    @GET("/users/list")
    Observable<User> getUserList();
}
