package com.miraclehwan.layouttest;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.Button;

@SuppressLint("AppCompatCustomView")
public class MyViewGroup extends Button {


    public MyViewGroup(Context context) {
        super(context);
    }

    public MyViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Log.e("onMeasure", "widthMeasureSpec = " + widthMeasureSpec + "\n" +
                                "heightMeasureSpec = " + heightMeasureSpec);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        Log.e("onLayout", "changed = " + changed + "\n" +
                "left = " + left + "\n" +
                "top = " + top + "\n" +
                "right = " + right + "\n" +
                "bottom = " + bottom + "\n");
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Log.e("onDraw", "getMeasuredWidth = " + getMeasuredWidth() + "\n" +
                "getMeasuredHeight = " + getMeasuredHeight());
        super.onDraw(canvas);
    }
}
