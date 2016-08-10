package com.carpediem.homer.spannedtest;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.style.LineBackgroundSpan;
import android.text.style.ReplacementSpan;

/**
 * Created by homer on 16-8-9.
 */
public class LineSpan extends ReplacementSpan {
    private final Paint mPaint;
    private int mWidth;

    public LineSpan() {
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.BLUE);
        mPaint.setAntiAlias(true);
    }

    @Override
    public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
        //return text with relative to the Paint
        mWidth = (int) paint.measureText(text, start, end) +100;
        return mWidth;
    }

    @Override
    public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
        //draw the frame with custom Paint
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawRect(x-10, top-10, x + mWidth+10, bottom+10, paint);
        canvas.drawText(text, start, end, x, y, paint);
    }
}
