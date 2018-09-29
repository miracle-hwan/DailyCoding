package com.miraclehwan.rxjava2.operator.map;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import com.miraclehwan.rxjava2.operator.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class MapActivity extends BaseActivity {

    private List<ApiUser> getApiUserList(){
        List<ApiUser> apiUserList = new ArrayList<>();
        apiUserList.add(new ApiUser("apple kim"));
        apiUserList.add(new ApiUser("banana lee"));
        apiUserList.add(new ApiUser("book choi"));
        return apiUserList;
    }

    private Observable<List<ApiUser>> getObservable(){
        return Observable.create((ObservableOnSubscribe<List<ApiUser>>) emitter -> {
            emitter.onNext(getApiUserList());
            emitter.onComplete();
        });
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        singleMap();
        multiMap();
    }

    private void singleMap(){
        getObservable().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map((Function<List<ApiUser>, List<User>>) apiUsers -> {
                    List<User> convertApiUserToUserList = new ArrayList<>();
                    for (ApiUser apiUser : apiUsers) {
                        String[] apiUserName = apiUser.getUserName().split(" ");
                        convertApiUserToUserList.add(new User(apiUserName[0], apiUserName[1]));
                    }
                    return convertApiUserToUserList;
                })
                .subscribe(users -> {
                            for (User user : users) {
                                binding.tvResult.append(user.toString());
                                binding.tvResult.append("\n");
                            }
                        }, throwable -> Toast.makeText(this, "Error : " + throwable.getMessage(), Toast.LENGTH_SHORT).show(),
                        () -> Toast.makeText(this, "onComplete", Toast.LENGTH_SHORT).show());
    }

    private void multiMap(){
        getObservable().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map((Function<List<ApiUser>, List<User>>) apiUsers -> {
                    List<User> convertApiUserToUserList = new ArrayList<>();
                    for (ApiUser apiUser : apiUsers) {
                        String[] apiUserName = apiUser.getUserName().split(" ");
                        convertApiUserToUserList.add(new User(apiUserName[0], apiUserName[1]));
                    }
                    return convertApiUserToUserList;
                })
                .map((Function<List<User>, List<ApiUser>>) users -> {
                    List<ApiUser> convertUserListToApiUserList = new ArrayList<>();
                    for (User user : users){
                        convertUserListToApiUserList.add(new ApiUser(user.getFirstName() + user.getLastName()));
                    }
                    return convertUserListToApiUserList;
                })
                .subscribe(apiUsers -> {
                    for (ApiUser apiUser : apiUsers){
                        binding.tvResult.append(apiUser.toString());
                        binding.tvResult.append("\n");
                    }
                }, throwable -> Toast.makeText(this, "Error : " + throwable.getMessage(), Toast.LENGTH_SHORT).show(),
                        () -> Toast.makeText(this, "onComplete", Toast.LENGTH_SHORT).show());
    }
}
