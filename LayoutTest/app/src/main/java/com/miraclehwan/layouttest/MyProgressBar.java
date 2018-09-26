package com.miraclehwan.layouttest;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class MyProgressBar extends View {

    private int currentValue;
    private int maxValue;
    private int lineColor;

    public MyProgressBar(Context context) {
        super(context);
    }

    public MyProgressBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.MyProgressBar, 0, 0);

        currentValue = typedArray.getInteger(R.styleable.MyProgressBar_currentValue, 0);
        maxValue = typedArray.getInteger(R.styleable.MyProgressBar_maxValue, 0);
        lineColor = typedArray.getInteger(R.styleable.MyProgressBar_lineColor, 000000);
    }

    public int getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(int currentValue) {
        this.currentValue = currentValue;
        invalidate();
        requestLayout();
    }

    public int getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
        invalidate();
        requestLayout();
    }

    public int getLineColor() {
        return lineColor;
    }

    public void setLineColor(int lineColor) {
        this.lineColor = lineColor;
        invalidate();
        requestLayout();
    }

    Handler drawHandler = new Handler();

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = getMeasuredWidth();
        int height = getMeasuredHeight();

        Paint circlePaint = new Paint();
        circlePaint.setColor(lineColor);
        circlePaint.setStrokeWidth(10);
        circlePaint.setAntiAlias(false);
        circlePaint.setStyle(Paint.Style.STROKE);

        canvas.drawArc(new RectF(0, 0, width, height),
                -90,
                ((float) currentValue / (float) maxValue*360),
                false,
                circlePaint);

        Paint textPaint = new Paint();
        textPaint.setColor(Color.BLACK);
        textPaint.setTextSize(100);
        textPaint.setTextAlign(Paint.Align.CENTER);

        if(System.currentTimeMillis() / 1000 % 2 == 0) {
            canvas.drawText(this.currentValue + " / " + this.maxValue,
                    width / 2,
                    height / 2,
                    textPaint);
        }

        drawHandler.postDelayed(() -> invalidate(), 1000);
    }
}
