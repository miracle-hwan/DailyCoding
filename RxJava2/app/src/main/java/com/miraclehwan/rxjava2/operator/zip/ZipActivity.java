package com.miraclehwan.rxjava2.operator.zip;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.miraclehwan.rxjava2.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.BiFunction;
import io.reactivex.schedulers.Schedulers;


public class ZipActivity extends BaseActivity {

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

    private Observable<List<User>> getFootballFansObservable(){
        return Observable.create(emitter -> {
            if (!emitter.isDisposed()){
                emitter.onNext(getUserListWhoLovesFootball());
                emitter.onComplete();
            }
        });
    }

    private Observable<String> getStringObservable(){
        return Observable.create(emitter -> {
            if (!emitter.isDisposed()){
                emitter.onNext("apple");
                emitter.onComplete();
            }
        });
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        sameObject();
        diffObject();
    }

    private void sameObject(){
        Observable.zip(getCricketFansObservable(), getFootballFansObservable(),
                new BiFunction<List<User>, List<User>, List<User>>() {
                    @Override
                    public List<User> apply(List<User> crickeFans, List<User> footballFans) throws Exception {
                        List<User> userWhoLovesBoth = new ArrayList<>();
                        for (User crickeFan : crickeFans){
                            for (User footballFan : footballFans){
                                if (crickeFan.getId() == footballFan.getId()){
                                    userWhoLovesBoth.add(crickeFan);
                                    break;
                                }
                            }
                        }
                        return userWhoLovesBoth;
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(users -> {
                    for (User user : users){
                        binding.tvResult.append(user.toString());
                        binding.tvResult.append("\n");
                    }},
                        throwable -> Toast.makeText(this, "Error - " + throwable.getMessage(), Toast.LENGTH_SHORT).show(),
                        () -> Toast.makeText(this, "Complete", Toast.LENGTH_SHORT).show());
    }

    private void diffObject(){
        Observable.zip(getCricketFansObservable(), getStringObservable(),
                new BiFunction<List<User>, String, User>() {
                    @Override
                    public User apply(List<User> crickeFans, String name) throws Exception {
                        for (User crickeFan : crickeFans){
                            if (crickeFan.getFirstName().equals(name)){
                                return crickeFan;
                            }
                        }
                        return null;
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(user -> {
                    binding.tvResult.append(user.toString());
                    binding.tvResult.append("\n");},
                        throwable -> Toast.makeText(this, "Error - " + throwable.getMessage(), Toast.LENGTH_SHORT).show(),
                        () -> Toast.makeText(this, "Complete", Toast.LENGTH_SHORT).show());
    }
}
