package com.miraclehwan.dagger2_test;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.miraclehwan.dagger2_test.di.DaggerMyComponent;
import com.miraclehwan.dagger2_test.di.MyComponent;
import com.miraclehwan.dagger2_test.model.Kitchen;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    Kitchen mKitchen;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyComponent myComponent = DaggerMyComponent.create();
        myComponent.inject(this);

        isOrder();
    }

    private void isOrder() {
        boolean isOrder = mKitchen.isOrder();
        if (isOrder) {
            Log.e("isOrder", "order successful");
        } else {
            Log.e("isOrder", "order failed");
        }
    }
}
