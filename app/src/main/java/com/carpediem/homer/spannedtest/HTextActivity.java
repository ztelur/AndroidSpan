package com.carpediem.homer.spannedtest;

import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.TextView;

public class HTextActivity extends AppCompatActivity implements View.OnClickListener{
    private final static String CONTENT = "This is a demo for span";
    private final static String HEAD = "Actionbar";
    private TextView mTvTextView;
    private AccelerateDecelerateInterpolator mSmoothInterpolator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_htext);
        mTvTextView = (TextView)findViewById(R.id.textview);
        findViewById(R.id.button).setOnClickListener(this);
        final SpannableString spannableString = new SpannableString(CONTENT);
        mTvTextView.setText(spannableString);
        mSmoothInterpolator = new AccelerateDecelerateInterpolator();

    }


    @Override
    public void onClick(View v) {
        useRainBowSpan();
    }
    private void useRainBowSpan() {
        final SpannableString spannableString = new SpannableString(CONTENT);
        BubbleSpan span  = new BubbleSpan();
        spannableString.setSpan(span,0,spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        mTvTextView.setText(spannableString);
    }
}
