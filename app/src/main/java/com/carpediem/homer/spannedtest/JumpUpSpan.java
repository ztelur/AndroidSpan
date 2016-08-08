package com.carpediem.homer.spannedtest;

import android.os.Parcel;
import android.text.ParcelableSpan;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import android.text.style.SubscriptSpan;
import android.util.Log;

/**
 * Created by homer on 16-8-2.
 */
public class JumpUpSpan extends SubscriptSpan {
    private float mBaselineShift = 1.0f;
    public JumpUpSpan(float percent) {
        super();
        setPercent(percent);
    }
    public void setPercent(float percent) {
        percent = Math.min(1.0f,percent);
        percent = Math.max(0.0f,percent);
        mBaselineShift = percent;
    }
    @Override
    public void updateMeasureState(TextPaint p) {
        p.baselineShift += (int)(p.ascent() * mBaselineShift);
    }

    @Override
    public void updateDrawState(TextPaint tp) {
        tp.baselineShift += (int)(tp.ascent() * mBaselineShift);
    }
}
