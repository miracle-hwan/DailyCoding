package com.miraclehwan.dagger2_test;

import android.os.Bundle;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.miraclehwan.dagger2_test.di.BurgerComponent;
import com.miraclehwan.dagger2_test.di.DaggerBurgerComponent;
import com.miraclehwan.dagger2_test.model.Burger;

import javax.inject.Inject;


public class MainActivity extends AppCompatActivity {

    @Inject
    Burger mBurger;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BurgerComponent burgerComponent = DaggerBurgerComponent.builder().build();

        burgerComponent.inject(this);

        ((TextView) findViewById(R.id.tv_access_token)).setText(mBurger.getWheatBun().getBun() + " / " + mBurger.getBeefPatty().getPatty());
    }
}
