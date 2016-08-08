package com.carpediem.homer.spannedtest;

import android.util.Log;
import android.util.Property;

import java.util.ArrayList;
import java.util.regex.Matcher;

/**
 * Created by homer on 16-8-2.
 */
public class WaveSpanGroup {
    private final float mPercent;
    private final ArrayList<JumpUpSpan> mSpams;

    public WaveSpanGroup(float percent) {
        percent = Math.max(0.0f,percent);
        percent = Math.min(1.0f,percent);
        mPercent = percent;
        mSpams = new ArrayList<>();
    }
    public void addSpan(JumpUpSpan span) {
        span.setPercent(mPercent);
        mSpams.add(span);
    }
    public void setProgress(float percent) {
        int size = mSpams.size();
        float total = 1.0f*size*percent;
        for (int index = 0;index < size;index++) {
            JumpUpSpan span = mSpams.get(index);
            if (total != size) {
                float distance = Math.min(4, Math.abs(index - total));
                float value = (4 - distance) / 4 * mPercent;
                span.setPercent((4 - distance) / 4 * mPercent);
            } else {
                span.setPercent(0);
            }
        }

    }
    public float getProgress() {
        return mPercent;
    }
    public final static Property<WaveSpanGroup,Float> WAVE_SPAN_PROPERTY =
            new Property<WaveSpanGroup, Float>(Float.class,"WAVE_SPAN_PROPERTY") {
                @Override
                public Float get(WaveSpanGroup object) {
                    return object.getProgress();
                }

                @Override
                public void set(WaveSpanGroup object, Float value) {
                    object.setProgress(value);
                }
            };
}
