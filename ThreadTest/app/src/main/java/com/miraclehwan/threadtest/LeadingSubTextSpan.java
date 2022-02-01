package com.miraclehwan.threadtest;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.style.LeadingMarginSpan;

public abstract class LeadingSubTextSpan implements LeadingMarginSpan {
    int leading = 10; //얼마만큼 들여쓰기 할 건지
    private int margin = 0;

    public LeadingSubTextSpan(int leading) {
        this.leading = leading;
    }

    public abstract boolean isSubText(String text); //여백 줘야 하는 줄인지 체크하는 메소드

    @Override
    public int getLeadingMargin(boolean b) {
        return margin;
    }

    @Override
    public void drawLeadingMargin(Canvas c, Paint p, int x, int dir, int top, int baseline, int bottom, CharSequence text, int start, int end, boolean isFirst, Layout layout) {
        int m = 0;
        if (start > 0) {
            String t = text.toString().substring(start - 1);
            if (t.startsWith("\n") && isSubText(t)) {
                m = leading;
            }
        }
        margin = m;
    }
}
