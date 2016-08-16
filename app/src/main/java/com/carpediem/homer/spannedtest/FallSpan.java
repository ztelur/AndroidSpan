package com.carpediem.homer.spannedtest;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.text.style.ReplacementSpan;
import android.util.Log;
import android.util.Property;

/**
 * Created by homer on 16-8-12.
 */
public class FallSpan extends ReplacementSpan {
    private float mYOffset = 10;
    private int mWidth;
    private float mProgress = 0.1f;
    @Override
    public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
        mWidth = (int)paint.measureText(text,start,end);
        return mWidth;
    }
    public void setProgress(float progress) {
        mProgress = progress;
    }
    public float getProgress() {
        return mProgress;
    }
    @Override
    public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
        float charx = x;
        for(int i = start ; i<end; i++) {
            String charAt = extractText(text, i, i + 1);
            float charWidth = paint.measureText(charAt);
            float centerX = charx + (charWidth / 2);
            float angle;
            if (mProgress <=0.5) {
                angle = mProgress * (200 / 0.5f);
            } else {
                angle = 200 - (mProgress - 0.5f) * (20 / 0.2f);  // when to 0.7f angle to 180
                angle = Math.max(180,angle);
            }

            canvas.save();
            Log.e("test","the center is"+centerX);
            canvas.rotate(angle,centerX,bottom - mYOffset);

            if (mProgress > 0.75f) {
                float percent = (1.0f - mProgress)/(1.0f - 0.75f);
                canvas.translate(0,- (1- percent) * mYOffset);
                int alpha = (int)(percent * 255);
                paint.setAlpha(alpha);
            }
            canvas.drawText(extractText(text,i,i+1),charx,y,paint);
            canvas.restore();
            charx += charWidth;
        }
    }
    private String extractText(CharSequence text, int start, int end) {
        return text.subSequence(start, end).toString();
    }
    public final static Property<FallSpan,Float> FALL_SPAN_FLOAT_PROPERTY =
            new Property<FallSpan, Float>(Float.class,"FALL_SPAN_FLOAT_PROPERTY") {
                @Override
                public Float get(FallSpan object) {
                    return object.getProgress();
                }

                @Override
                public void set(FallSpan object, Float value) {
                    object.setProgress(value);
                }
            };
}
