package com.miraclehwan.dagger2_test.model;

import androidx.annotation.NonNull;

public class Chef {

    private String mFirstName, mLastName;

    public Chef(String mFirstName, String mLastName) {
        this.mFirstName = mFirstName;
        this.mLastName = mLastName;
    }

    @Override
    public String toString() {
        return "Chef{" +
                "mFirstName='" + mFirstName + '\'' +
                ", mLastName='" + mLastName + '\'' +
                '}';
    }
}
