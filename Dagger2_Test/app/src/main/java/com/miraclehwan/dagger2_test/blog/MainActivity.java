package com.miraclehwan.dagger2_test.blog;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.miraclehwan.dagger2_test.R;
import com.miraclehwan.dagger2_test.blog.adapter.RandomUserAdapter;
import com.miraclehwan.dagger2_test.blog.component.DaggerRandomUserComponent;
import com.miraclehwan.dagger2_test.blog.component.RandomUserComponent;
import com.miraclehwan.dagger2_test.blog.model.RandomUsers;
import com.miraclehwan.dagger2_test.blog.module.ContextModule;
import com.miraclehwan.dagger2_test.blog.network.RandomUsersApi;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RandomUserAdapter mAdapter;

    @Inject
    Picasso picasso;
    @Inject
    RandomUsersApi randomUsersApi;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Timber.plant(new Timber.DebugTree());

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        RandomUserComponent daggerRandomUserComponent = DaggerRandomUserComponent.builder()
                .contextModule(new ContextModule(this))
                .build();
        daggerRandomUserComponent.injectMainActivity(this);
        populateUsers();
    }

    private void populateUsers() {
        Call<RandomUsers> randomUsersCall = randomUsersApi.getRandomUsers(10);
        randomUsersCall.enqueue(new Callback<RandomUsers>() {
            @Override
            public void onResponse(Call<RandomUsers> call, @NonNull Response<RandomUsers> response) {
                if(response.isSuccessful()) {
                    mAdapter = new RandomUserAdapter(MainActivity.this, picasso);
                    mAdapter.setItems(response.body().getResults());
                    recyclerView.setAdapter(mAdapter);
                }else{
                    Timber.e(response.message());
                }
            }

            @Override
            public void onFailure(Call<RandomUsers> call, Throwable t) {
                Timber.e(t.getMessage());
            }
        });
    }
}
