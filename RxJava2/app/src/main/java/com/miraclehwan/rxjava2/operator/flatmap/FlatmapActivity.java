package com.miraclehwan.rxjava2.operator.flatmap;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import com.miraclehwan.rxjava2.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class FlatmapActivity extends BaseActivity {

    private List<Integer> numList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        numList = new ArrayList<>(50000);
        for (int i = 0; i < 50000; i++) {
            numList.add(i);
        }

        getNumListObservable()
                .flatMap(integers -> Observable.fromIterable(integers))
                .filter(integer -> (integer % 2) == 0)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integer -> {
                    Log.e("miraclehwan", String.valueOf(integer));
                    binding.tvResult.append(String.valueOf(integer));
                    binding.tvResult.append("\n");
                    },
                        throwable -> Toast.makeText(this, "Error - " + throwable.getMessage(), Toast.LENGTH_SHORT).show(),
                        () -> Toast.makeText(this, "onComplete", Toast.LENGTH_SHORT).show());
    }

    private Observable<List<Integer>> getNumListObservable(){
        return Observable.create(emitter -> {
            if (!emitter.isDisposed()){
                emitter.onNext(numList);
                emitter.onComplete();
            }
        });
    }
}
