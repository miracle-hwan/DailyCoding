package com.miraclehwan.dagger2_test;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import javax.inject.Inject;
import javax.inject.Named;

public class MainActivity extends AppCompatActivity {

    @Inject
    @Named("default")
    SharedPreferences mDefaultSharedPrefs;

    @Inject
    @Named("secret")
    SharedPreferences mSecretSharedPrefs;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((DemoApplication) getApplication())
                .getApplicationComponent()
                .inject(this);

        mDefaultSharedPrefs.edit()
                .putString("status", "DefaultPref is success!")
                .apply();

        ((TextView) findViewById(R.id.tv_user_info)).setText(mDefaultSharedPrefs.getString("status", "null"));

        mSecretSharedPrefs.edit()
                .putString("status", "SecretPref is success!")
                .apply();

        ((TextView) findViewById(R.id.tv_access_token)).setText(mSecretSharedPrefs.getString("status", "null"));
    }
}
