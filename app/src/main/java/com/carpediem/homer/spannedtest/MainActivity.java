package com.carpediem.homer.spannedtest;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.BlurMaskFilter;
import android.graphics.Color;
import android.graphics.EmbossMaskFilter;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.BulletSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.MaskFilterSpan;
import android.text.style.QuoteSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.ScaleXSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.util.Property;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private final static String CONTENT = "This is a demo for span";
    private final static String HEAD = "Actionbar";
    private TextView mTvTextView;
    private AccelerateDecelerateInterpolator mSmoothInterpolator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTvTextView = (TextView)findViewById(R.id.textview);
        findViewById(R.id.button).setOnClickListener(this);
        final SpannableString spannableString = new SpannableString(CONTENT);
        mTvTextView.setText(spannableString);
        mSmoothInterpolator = new AccelerateDecelerateInterpolator();
        setTitle(HEAD);
//        startActivity(new Intent(this,HTextActivity.class));
    }

    @Override
    public void onClick(View v) {
        Log.e("test","onClick");
        //        useQuoteSpan();
//        useAlignSpan();
//        useUnderlineSpan();
//        useStrikeSpan();
//        useSubscriptSpan();
//        useSupscriptSpan();
//        useBackgroundColorSpan();
//        useForegroundColorSpan();
//        useImageSpan();
//        useStyleSpan();
//        useTypefaceSpan();
//        useAbsolutSizeSpan();
//        useRelativeSizeSpan();
//        useScaleSpan();
//        useMaskFilterSpan();
//        useJumpUpSpan();
//        useMaskFilterSpan();
//        useWaveSpanGroupAnimation();
//        useFireWorkGroupAnimation();
//        useTypeWriterSpanGroup();
//        useBubbleSpan();
//        useRainBowSpan();
//        useLineSpan();
        useSparkleSpan();
//        useRectSpan();
//        animateColorSpan();
//        useLetterLineSpan();
    }
    private void useSparkleSpan() {
        final SpannableString spannableString = new SpannableString(CONTENT);
        SparkSpan span  = new SparkSpan(this);
        spannableString.setSpan(span,0,spannableString.length()-1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        mTvTextView.setText(spannableString);
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(span, SparkSpan.SPARK_SPAN_FLOAT_PROPERTY,
                0.0f, 1.0f);
        objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                //refresh
                mTvTextView.setText(spannableString);
            }
        });
        objectAnimator.setInterpolator(mSmoothInterpolator);
        objectAnimator.setDuration(600);
        objectAnimator.start();
    }
    private void useLineSpan() {
        final SpannableString spannableString = new SpannableString(CONTENT);
        LineSpan span  = new LineSpan();
        spannableString.setSpan(span,0,spannableString.length()-1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        mTvTextView.setText(spannableString);
    }
    private void useRainBowSpan() {
        final SpannableString spannableString = new SpannableString(CONTENT);
        RainBowSpan span  = new RainBowSpan();
        spannableString.setSpan(span,0,spannableString.length()-1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        mTvTextView.setText(spannableString);
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(span, RainBowSpan.RAIN_BOW_SPAN_FLOAT_PROPERTY, 0.0f, 1.0f);
        objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                //refresh
                mTvTextView.setText(spannableString);
            }
        });
        objectAnimator.setInterpolator(mSmoothInterpolator);
        objectAnimator.setDuration(600);
        objectAnimator.start();
    }
    private void useBulletSpan() {
        /**
         * public BulletSpan (int gapWidth, int color)
         * -gapWidth: gap in px between bullet and text
         * -color: bullet color (optionnal, default is transparent)
         */
        BulletSpan span = new BulletSpan(15,Color.RED);
        SpannableString spannableString = new SpannableString(CONTENT);
        spannableString.setSpan(span,0,1,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        mTvTextView.setText(spannableString);
    }
    private void useQuoteSpan() {
        QuoteSpan span = new QuoteSpan(Color.RED);
        SpannableString spannableString = new SpannableString(CONTENT);
        spannableString.setSpan(span,0,2,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        mTvTextView.setText(spannableString);
    }
    private void useAlignSpan() {
        AlignmentSpan.Standard span = new AlignmentSpan.Standard(Layout.Alignment.ALIGN_CENTER);
        SpannableString spannableString = new SpannableString(CONTENT);
        spannableString.setSpan(span,0,0,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        mTvTextView.setText(spannableString);
    }
    private void useUnderlineSpan() {
        UnderlineSpan span = new UnderlineSpan();
        SpannableString spannableString = new SpannableString(CONTENT);
        spannableString.setSpan(span,0,spannableString.length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        mTvTextView.setText(spannableString);
    }

    private void useStrikeSpan() {
        StrikethroughSpan span = new StrikethroughSpan();
        SpannableString spannableString = new SpannableString(CONTENT);
        spannableString.setSpan(span,0,spannableString.length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        mTvTextView.setText(spannableString);
    }

    /**
     * reduce TextPaint.baselineShift 来让字体整个下沉.
     */
    private void useSubscriptSpan() {
        SubscriptSpan span = new SubscriptSpan();
        SpannableString spannableString = new SpannableString(CONTENT);
        spannableString.setSpan(span,0,spannableString.length()/2,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        mTvTextView.setText(spannableString);
    }
    private void useSupscriptSpan() {
        SuperscriptSpan span = new SuperscriptSpan();
        SpannableString spannableString = new SpannableString(CONTENT);
        spannableString.setSpan(span,0,spannableString.length()/2,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        mTvTextView.setText(spannableString);
    }
    private void useBackgroundColorSpan() {
        BackgroundColorSpan span = new BackgroundColorSpan(Color.RED);
        SpannableString spannableString = new SpannableString(CONTENT);
        spannableString.setSpan(span,0,spannableString.length()/2,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        mTvTextView.setText(spannableString);
    }
    private void useForegroundColorSpan() {
        ForegroundColorSpan span = new ForegroundColorSpan(Color.RED);
        SpannableString spannableString = new SpannableString(CONTENT);
        spannableString.setSpan(span,0,spannableString.length()/2,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        mTvTextView.setText(spannableString);
    }
    private void useImageSpan() {
        ImageSpan span = new ImageSpan(this,R.mipmap.ic_launcher);
        SpannableString spannableString = new SpannableString(CONTENT);
        spannableString.setSpan(span,0,1,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        mTvTextView.setText(spannableString);
    }
    private void useStyleSpan() {
        StyleSpan span = new StyleSpan(Typeface.BOLD);
        SpannableString spannableString = new SpannableString(CONTENT);
        spannableString.setSpan(span,0,spannableString.length()/2,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        mTvTextView.setText(spannableString);
    }

    private void useTypefaceSpan() {
        TypefaceSpan span = new TypefaceSpan("serif");
        SpannableString spannableString = new SpannableString(CONTENT);
        spannableString.setSpan(span,0,spannableString.length()/2,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        mTvTextView.setText(spannableString);
    }

    private void useTextAppearanceSpan() {

    }

    private void useAbsolutSizeSpan() {
        AbsoluteSizeSpan span = new AbsoluteSizeSpan(24,true);
        SpannableString spannableString = new SpannableString(CONTENT);
        spannableString.setSpan(span,0,spannableString.length()/2,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        mTvTextView.setText(spannableString);
    }
    private void useRelativeSizeSpan() {
        RelativeSizeSpan span = new RelativeSizeSpan(2.0f);
        SpannableString spannableString = new SpannableString(CONTENT);
        spannableString.setSpan(span,0,spannableString.length()/2,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        mTvTextView.setText(spannableString);
    }
    private void useScaleSpan() {
        ScaleXSpan span = new ScaleXSpan(2.0f);
        SpannableString spannableString = new SpannableString(CONTENT);
        spannableString.setSpan(span,0,spannableString.length()/2,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        mTvTextView.setText(spannableString);
    }
    private void useMaskFilterSpan() {
        MaskFilterSpan span = new MaskFilterSpan(new BlurMaskFilter(2.0f, BlurMaskFilter.Blur.NORMAL));
        MaskFilterSpan span1 = new MaskFilterSpan(new EmbossMaskFilter(new float[]{1,1,1},0.4f,6,3.5f));

        SpannableString spannableString = new SpannableString(CONTENT);
        spannableString.setSpan(span1,0,3,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        mTvTextView.setText(spannableString);
    }

    private void animateColorSpan() {
        MutableForegroundColorSpan span = new MutableForegroundColorSpan(255, Color.BLUE);
        final SpannableString spannableString = new SpannableString(CONTENT);
        spannableString.setSpan(span, 0,4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ObjectAnimator objectAnimator = ObjectAnimator.ofInt(span, MUTABLE_FOREGROUND_COLOR_SPAN_FC_PROPERTY, Color.BLACK, Color.RED);
        objectAnimator.setEvaluator(new ArgbEvaluator());
        objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                //refresh
                mTvTextView.setText(spannableString);
            }
        });
        objectAnimator.setInterpolator(mSmoothInterpolator);
        objectAnimator.setDuration(600);
        objectAnimator.start();
    }

    private static final Property<MutableForegroundColorSpan, Integer> MUTABLE_FOREGROUND_COLOR_SPAN_FC_PROPERTY =
            new Property<MutableForegroundColorSpan, Integer>(Integer.class, "MUTABLE_FOREGROUND_COLOR_SPAN_FC_PROPERTY") {

                @Override
                public void set(MutableForegroundColorSpan alphaForegroundColorSpanGroup, Integer value) {
                    alphaForegroundColorSpanGroup.setForegroundColor(value);
                }

                @Override
                public Integer get(MutableForegroundColorSpan span) {
                    return span.getForegroundColor();
                }
            };


    private void useJumpUpSpan() {
        JumpUpSpan span = new JumpUpSpan(0.1f);
        SpannableString spannableString = new SpannableString(CONTENT);
        spannableString.setSpan(span,0,spannableString.length()/2,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        mTvTextView.setText(spannableString);
    }
    private void useWaveSpanGroupAnimation() {
        final WaveSpanGroup group = new WaveSpanGroup(0.5f);
        final SpannableString spannableString = new SpannableString(CONTENT);
        for (int index = 0;index<=spannableString.length()-1;index++) {
            JumpUpSpan span = new JumpUpSpan(0.0f);
            group.addSpan(span);
            spannableString.setSpan(span,index,index+1,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(group, WaveSpanGroup.WAVE_SPAN_PROPERTY, 0.0f, 1.0f);
        objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                //refresh
                mTvTextView.setText(spannableString);
            }
        });
        objectAnimator.setInterpolator(mSmoothInterpolator);
        objectAnimator.setDuration(600);
        objectAnimator.start();
    }
    private void useFireWorkGroupAnimation() {
        final FireWorkGroup group = new FireWorkGroup();
        final SpannableString spannableString = new SpannableString(HEAD);
        for(int index = 0 ; index < HEAD.length() ; index++) {
            MutableForegroundColorSpan span = new MutableForegroundColorSpan(0, Color.WHITE);
            group.addSpan(span);
            spannableString.setSpan(span, index, index + 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        group.init();
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(group, FireWorkGroup.FIREWORKS_GROUP_PROGRESS_PROPERTY, 0.0f, 1.0f);
        objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                //refresh
                setTitle(spannableString);
            }
        });
        objectAnimator.setDuration(2000);
        objectAnimator.start();
    }
    private void useBubbleSpan() {
        BubbleSpan span = new BubbleSpan();
        SpannableString spannableString = new SpannableString(CONTENT);
        spannableString.setSpan(span,0,spannableString.length()/2,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        mTvTextView.setText(spannableString);
    }
    private void useRectSpan() {
        RectSpan span = new RectSpan();
        SpannableString spannableString = new SpannableString(CONTENT);
        spannableString.setSpan(span,0,spannableString.length()/2,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        mTvTextView.setText(spannableString);
    }

    private void useLetterLineSpan() {
        LetterLineBackgroundSpan span = new LetterLineBackgroundSpan();
        SpannableString spannableString = new SpannableString(CONTENT);
        spannableString.setSpan(span,0,spannableString.length()/2,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        mTvTextView.setText(spannableString);
    }

    private void useTypeWriterSpanGroup() {
        final TypeWriterSpanGroup group = new TypeWriterSpanGroup(0);
        final SpannableString spannableString = new SpannableString(CONTENT);
        for(int index = 0 ; index < CONTENT.length() ; index++) {
            MutableForegroundColorSpan span = new MutableForegroundColorSpan(0, Color.BLACK);
            group.addSpan(span);
            spannableString.setSpan(span, index, index + 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(group, TYPE_WRITER_GROUP_ALPHA_PROPERTY, 0.0f, 1.0f);
        objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                //refresh
                mTvTextView.setText(spannableString);
            }
        });
        objectAnimator.setInterpolator(mSmoothInterpolator);
        objectAnimator.setDuration(5000);
        objectAnimator.start();
    }
    private static final class TypeWriterSpanGroup {

        private static final boolean DEBUG = false;
        private static final String TAG = "TypeWriterSpanGroup";

        private final float mAlpha;
        private final ArrayList<MutableForegroundColorSpan> mSpans;

        private TypeWriterSpanGroup(float alpha) {
            mAlpha = alpha;
            mSpans = new ArrayList<MutableForegroundColorSpan>();
        }

        public void addSpan(MutableForegroundColorSpan span) {
            span.setAlpha((int) (mAlpha * 255));
            mSpans.add(span);
        }

        public void setAlpha(float alpha) {
            int size = mSpans.size();
            float total = 1.0f * size * alpha;

            if(DEBUG) Log.d(TAG, "alpha " + alpha + " * 1.0f * size => " + total);

            for(int index = 0 ; index < size; index++) {
                MutableForegroundColorSpan span = mSpans.get(index);

                if(total >= 1.0f) {
                    span.setAlpha(255);
                    total -= 1.0f;
                } else {
                    span.setAlpha((int) (total * 255));
                    total = 0.0f;
                }

                if(DEBUG) Log.d(TAG, "alpha span(" + index + ") => " + alpha);
            }
        }

        public float getAlpha() {
            return mAlpha;
        }
    }
    private static final Property<TypeWriterSpanGroup, Float> TYPE_WRITER_GROUP_ALPHA_PROPERTY =
            new Property<TypeWriterSpanGroup, Float>(Float.class, "TYPE_WRITER_GROUP_ALPHA_PROPERTY") {

                @Override
                public void set(TypeWriterSpanGroup spanGroup, Float value) {
                    spanGroup.setAlpha(value);
                }

                @Override
                public Float get(TypeWriterSpanGroup spanGroup) {
                    return spanGroup.getAlpha();
                }
            };
}

