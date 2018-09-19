package com.miraclehwan.searchhistorywithroom;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.widget.AppCompatAutoCompleteTextView;
import android.util.AttributeSet;
import android.util.Log;

public class MyAutoCompleteView extends AppCompatAutoCompleteTextView {

    public MyAutoCompleteView(Context context) {
        super(context);
    }

    public MyAutoCompleteView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyAutoCompleteView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean enoughToFilter() {
        return false;
    }

    @Override
    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(focused, direction, previouslyFocusedRect);
        if (focused) {
            performFiltering(getText(), 0);
        }
    }

    @Override
    public void showDropDown() {
        if (getText().length() != 0){
            dismissDropDown();
            return;
        }
        super.showDropDown();
    }
}
