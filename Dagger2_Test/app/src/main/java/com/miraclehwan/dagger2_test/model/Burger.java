package com.miraclehwan.dagger2_test.model;

public class Burger {

    private WheatBun mWheatBun;
    private BeefPatty mBeefPatty;

    public Burger(WheatBun mWheatBun, BeefPatty mBeefPatty) {
        this.mWheatBun = mWheatBun;
        this.mBeefPatty = mBeefPatty;
    }

    public WheatBun getWheatBun() {
        return mWheatBun;
    }

    public BeefPatty getBeefPatty() {
        return mBeefPatty;
    }
}
