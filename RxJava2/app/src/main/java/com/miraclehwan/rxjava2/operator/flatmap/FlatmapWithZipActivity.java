package com.miraclehwan.rxjava2.operator.flatmap;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Pair;
import android.widget.Toast;

import com.miraclehwan.rxjava2.BaseActivity;
import com.miraclehwan.rxjava2.operator.zip.User;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class FlatmapWithZipActivity extends BaseActivity {

    public static List<User> getUserListWhoLovesCricket() {
        List<User> userList = new ArrayList<>();
        userList.add(new User(1, "apple", "kim"));
        userList.add(new User(2, "banana", "lee"));
        userList.add(new User(3, "book", "choi"));
        return userList;
    }

    public static List<User> getUserListWhoLovesFootball() {
        List<User> userList = new ArrayList<>();
        userList.add(new User(1, "apple", "kim"));
        userList.add(new User(3, "book", "choi"));
        return userList;
    }

    private Observable<List<User>> getCricketFansObservable(){
        return Observable.create(emitter -> {
            if (!emitter.isDisposed()){
                emitter.onNext(getUserListWhoLovesCricket());
                emitter.onComplete();
            }
        });
    }

    private Observable<User> getFootballFansObservable(String lastName){
        return Observable.create(emitter -> {
            if (!emitter.isDisposed()){
                List<User> userList = getUserListWhoLovesFootball();
                for (User user : userList){
                    if (user.getLastName().equals(lastName)){
                        emitter.onNext(user);
                        emitter.onComplete();
                        break;
                    }
                }
            }
        });
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getCricketFansObservable()
                .flatMap(cricketFans -> Observable.fromIterable(cricketFans))
                .flatMap(cricketFan ->
                    Observable.zip(getFootballFansObservable(cricketFan.lastName),
                            Observable.just(cricketFan),
                            (userWhoLovesFootball, user) -> new Pair<>(userWhoLovesFootball, user)))
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(listUserPair -> {
                            binding.tvResult.append(listUserPair.first.toString());
                            binding.tvResult.append(listUserPair.second.toString());
                            binding.tvResult.append("\n");},
                        throwable -> Toast.makeText(this, "Error - " + throwable.getMessage(), Toast.LENGTH_SHORT).show(),
                        () -> Toast.makeText(this, "Complete", Toast.LENGTH_SHORT).show());
    }
}
