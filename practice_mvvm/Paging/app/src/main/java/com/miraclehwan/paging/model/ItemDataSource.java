package com.miraclehwan.paging.model;

import android.arch.paging.PageKeyedDataSource;
import android.support.annotation.NonNull;
import android.util.Log;

import com.miraclehwan.paging.model.Item;
import com.miraclehwan.paging.model.StackApiResonse;
import com.miraclehwan.paging.network.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ItemDataSource extends PageKeyedDataSource<Integer, Item> {

    public static final int PAGE_SIZE = 10;
    private static final int FIRST_PAGE = 1;
    private static final String SITE_NAME = "stackoverflow";

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull final LoadInitialCallback<Integer, Item> callback) {
        Log.e(getClass().getName(), "loadInitial");
        RetrofitClient.getInstance()
                .getApi().getAnswers(FIRST_PAGE, PAGE_SIZE, SITE_NAME)
                .enqueue(new Callback<StackApiResonse>() {
                    @Override
                    public void onResponse(Call<StackApiResonse> call, Response<StackApiResonse> response) {
                        if (response.body() != null){
                            callback.onResult(response.body().items, null, FIRST_PAGE + 1);
                        }
                    }

                    @Override
                    public void onFailure(Call<StackApiResonse> call, Throwable t) {

                    }
                });
    }

    @Override
    public void loadBefore(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, Item> callback) {
        Log.e(getClass().getName(), "loadBefore");
        RetrofitClient.getInstance()
                .getApi().getAnswers(params.key, PAGE_SIZE, SITE_NAME)
                .enqueue(new Callback<StackApiResonse>() {
                    @Override
                    public void onResponse(Call<StackApiResonse> call, Response<StackApiResonse> response) {
                        Integer adjacentKey = (params.key > 1) ? params.key - 1 : null;
                        if (response.body() != null) {
                            callback.onResult(response.body().items, adjacentKey);
                        }
                    }

                    @Override
                    public void onFailure(Call<StackApiResonse> call, Throwable t) {

                    }
                });
    }

    @Override
    public void loadAfter(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, Item> callback) {
        Log.e(getClass().getName(), "loadInitial");
        RetrofitClient.getInstance()
                .getApi().getAnswers(params.key, PAGE_SIZE, SITE_NAME)
                .enqueue(new Callback<StackApiResonse>() {
                    @Override
                    public void onResponse(Call<StackApiResonse> call, Response<StackApiResonse> response) {
                        if (response.body() != null && response.body().hasMore){
                            callback.onResult(response.body().items, params.key + 1);
                        }
                    }

                    @Override
                    public void onFailure(Call<StackApiResonse> call, Throwable t) {

                    }
                });
    }
}