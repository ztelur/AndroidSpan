package com.carpediem.homer.spannedtest;

import android.graphics.Color;
import android.os.Parcel;
import android.text.TextPaint;
import android.text.style.ForegroundColorSpan;

/**
 * Created by homer on 16-7-29.
 */
public class TestSpan extends ForegroundColorSpan {
    private int  mAlpha = 255;
    private int mForegroundColor;
    public TestSpan(int alpha,int color) {
        super(color);
        mAlpha = alpha;
        mForegroundColor = color;
    }

    public TestSpan(Parcel src) {
        super(src);
        mForegroundColor = src.readInt();
        mAlpha = src.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeInt(mForegroundColor);
        dest.writeInt(mAlpha);
    }

    @Override
    public void updateDrawState(TextPaint ds) {
        ds.setColor(getForegroundColor());
    }

    public void setForegroundColor(int foregroundColor) {
        mForegroundColor = foregroundColor;
    }
    public int getAlpha() {
        return mAlpha;
    }
    public void setAlpha(int alpha) {
        mAlpha = alpha;
    }
    @Override
    public int getForegroundColor() {
        return Color.argb(mAlpha,Color.red(mForegroundColor),
                Color.green(mForegroundColor),
                Color.blue(mForegroundColor));
    }
}
