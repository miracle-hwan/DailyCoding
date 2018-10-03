package com.miraclehwan.rxjava2.subject;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.miraclehwan.rxjava2.BaseActivity;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;

public class BehaviorSubjectActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        BehaviorSubject<Integer> source = BehaviorSubject.create();

        source.subscribe(getFirstObserver());

        source.onNext(1);
        source.onNext(2);
        source.onNext(3);

        source.subscribe(getSecondObserver());

        source.onNext(4);
        source.onComplete();
    }

    private Observer<Integer> getFirstObserver(){
        return new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                binding.tvResult.append("FirstObserver(onSubscribe)");
                binding.tvResult.append("\n");
            }

            @Override
            public void onNext(Integer integer) {
                binding.tvResult.append("FirstObserver(onNext) : " + String.valueOf(integer));
                binding.tvResult.append("\n");
            }

            @Override
            public void onError(Throwable e) {
                binding.tvResult.append("FirstObserver(Error)");
                binding.tvResult.append("\n");
            }

            @Override
            public void onComplete() {
                binding.tvResult.append("FirstObserver(onComplete)");
                binding.tvResult.append("\n");
            }
        };
    }

    private Observer<Integer> getSecondObserver(){
        return new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                binding.tvResult.append("SecondObserver(onSubscribe)");
                binding.tvResult.append("\n");
            }

            @Override
            public void onNext(Integer integer) {
                binding.tvResult.append("SecondObserver(onNext) : " + String.valueOf(integer));
                binding.tvResult.append("\n");
            }

            @Override
            public void onError(Throwable e) {
                binding.tvResult.append("SecondObserver(Error)");
                binding.tvResult.append("\n");
            }

            @Override
            public void onComplete() {
                binding.tvResult.append("SecondObserver(onComplete)");
                binding.tvResult.append("\n");
            }
        };
    }
}
