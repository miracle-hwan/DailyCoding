package com.miraclehwan.dagger2_test.reference;

import com.miraclehwan.dagger2_test.UnitTestLog;

public class Starks implements House {
    @Override
    public void prepareForWar() {
        UnitTestLog.e(getClass().getSimpleName(), "prepared for war");
    }

    @Override
    public void reportForWar() {
        UnitTestLog.e(getClass().getSimpleName(), "reporting..");
    }
}
