package com.miraclehwan.dagger2_test.model;

import android.util.Log;

public class Kitchen {

    private Chef mChef;
    private String mOrder;

    public Kitchen(Chef mChef, String mOrder) {
        this.mChef = mChef;
        this.mOrder = mOrder;
    }

    @Override
    public String toString() {
        return "Kitchen{" +
                "mChef=" + mChef +
                ", mOrder='" + mOrder + '\'' +
                '}';
    }

    public boolean isOrder() {
        if (mChef != null && mOrder != null && mOrder.length() > 0) {
            Log.e("Kitchen", toString());
            return true;
        }
        return false;
    }
}
