package com.carpediem.homer.spannedtest;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import android.util.Log;
import android.util.Property;

import java.util.Random;

/**
 * Created by homer on 16-8-10.
 */
public class SparkSpan extends ReplacementSpan {
    private int mWidth;
    private Bitmap mBitmap;
    private Paint mPaint;
    private float mUpDistance;
    private float mPercent;
    public SparkSpan(Context context) {
        super();
        mPaint = new Paint();
        mBitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.sparkle);
    }

    public void setProgress(float percent) {
        mPercent = percent;
    }
    public float getProgress() {
        return mPercent;
    }

    @Override
    public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
        mWidth = (int)paint.measureText(text,start,end);
        return mWidth;
    }

    @Override
    public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
        Log.e("test","the size is start"+start+" end:"+end+" x:"+x+" top:"+top+" y:"+y+" bottom:"+bottom);
        mUpDistance = bottom;
        for (int i = start; i < end ; i++) {
            drawSparkle(canvas,x,top+mPercent*bottom,mWidth);
        }
        canvas.drawText(text, start, end, x, y, paint);
    }

    private void drawSparkle(Canvas canvas, float offset, float startY, float width) {
        Random random = new Random();
        for (int i = 0; i < 8; i++) {
            canvas.drawBitmap(getRandomSpark(random), (float) (offset + random.nextDouble() * width), (float) (startY - random
                    .nextGaussian() * Math.sqrt(mUpDistance)),mPaint);
        }
    }

    private Bitmap getRandomSpark(Random random) {
        int dstWidth = random.nextInt(12) + 1;
        return Bitmap.createScaledBitmap(mBitmap, dstWidth, dstWidth, false);
    }

    public static final Property<SparkSpan,Float> SPARK_SPAN_FLOAT_PROPERTY =
            new Property<SparkSpan, Float>(Float.class,"SPARK_SPAN_FLOAT_PROPERTY") {
                @Override
                public Float get(SparkSpan object) {
                    return object.getProgress();
                }

                @Override
                public void set(SparkSpan object, Float value) {
                    object.setProgress(value);
                }
            };
}
