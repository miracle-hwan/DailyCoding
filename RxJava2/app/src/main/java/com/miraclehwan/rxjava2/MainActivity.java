package com.miraclehwan.rxjava2;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.miraclehwan.rxjava2.databinding.ActivityMainBinding;
import com.miraclehwan.rxjava2.model.User;
import com.miraclehwan.rxjava2.network.RetrofitClient;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        networkRxJava();
    }

    private void simpleRxJava(){
        Observable<String> simpleObservable =
                Observable.create(emitter -> {
                    emitter.onNext("Hello RxJava !!");;
                    emitter.onComplete();
                });

        simpleObservable
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String s) {
                        binding.tvText.setText(s);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        Log.e("miraclehwan", "onComplete");
                    }
                });
    }

    private void networkRxJava(){
        RetrofitClient.getInstance().getApi()
                .getUserList()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        user -> binding.tvText.setText(user.toString()),
                        throwable -> Toast.makeText(this, "Error!!!!\n=>" + throwable.toString(), Toast.LENGTH_SHORT).show()
                );
    }
}
