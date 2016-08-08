package com.carpediem.homer.spannedtest;

import android.util.Property;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by homer on 16-8-8.
 */
public class FireWorkGroup {
    private final float mProgress;
    private final ArrayList<MutableForegroundColorSpan> mSpans;
    private final ArrayList<Integer> mSpanIndexes;

    public FireWorkGroup() {
        mProgress = 0;
        mSpans  = new ArrayList<>();
        mSpanIndexes = new ArrayList<>();
    }

    public void addSpan(MutableForegroundColorSpan span) {
        span.setAlpha(0);
        mSpanIndexes.add(mSpans.size());
        mSpans.add(span);
    }
    public void init() {
        Collections.shuffle(mSpans);
    }
    public void setProgress(float progress) {
        int size = mSpans.size();
        float total  = 1.0f * size * progress;
        for (int index = 0 ; index < size ; index++) {
            MutableForegroundColorSpan span = mSpans.get(index);
            if (total > 1.0f) {
                span.setAlpha(255);
                total -= 1.0f;
            } else {
                span.setAlpha((int)(total * 255));
                total = 0.0f;
            }
        }
    }
    public float getProgress() {
        return mProgress;
    }
    public static final Property<FireWorkGroup, Float> FIREWORKS_GROUP_PROGRESS_PROPERTY =
            new Property<FireWorkGroup, Float>(Float.class, "FIREWORKS_GROUP_PROGRESS_PROPERTY") {

                @Override
                public void set(FireWorkGroup spanGroup, Float value) {
                    spanGroup.setProgress(value);
                }

                @Override
                public Float get(FireWorkGroup spanGroup) {
                    return spanGroup.getProgress();
                }
            };
}
