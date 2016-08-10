package com.carpediem.homer.spannedtest;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.text.style.ReplacementSpan;
import android.util.Log;
import android.util.Property;

/**
 * Created by homer on 16-8-9.
 */
public class RainBowSpan extends ReplacementSpan {
    private int mWidth;
    private float mProgress;
    private Matrix mMatrix;
    private LinearGradient mLinearGradient;
    private int dx;
    public RainBowSpan() {
        mMatrix = new Matrix();
        dx = DisplayUtil.dp2Px(7);
    }
    @Override
    public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
        mWidth = (int) paint.measureText(text, start, end);
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
        mLinearGradient = new LinearGradient(0,0,100,100,
                new int[] {0xFFFF2B22, 0xFFFF7F22, 0xFFEDFF22, 0xFF22FF22, 0xFF22F4FF, 0xFF2239FF, 0xFF5400F7},null, Shader.TileMode.MIRROR);
        float transitionX = mProgress * mWidth;
        mMatrix.setTranslate(transitionX,0);
        mLinearGradient.setLocalMatrix(mMatrix);
        paint.setShader(mLinearGradient);
//        paint.setColor(Color.BLUE);
        canvas.drawText(text, start, end, x, y, paint);
    }

    public static final Property<RainBowSpan,Float> RAIN_BOW_SPAN_FLOAT_PROPERTY =
                new Property<RainBowSpan, Float>(Float.class,"RAIN_BOW_SPAN_FLOAT_PROPERTY") {
        @Override
        public Float get(RainBowSpan object) {
            return object.getProgress();
        }

        @Override
        public void set(RainBowSpan object, Float value) {
            object.setProgress(value);
        }
    };
}
