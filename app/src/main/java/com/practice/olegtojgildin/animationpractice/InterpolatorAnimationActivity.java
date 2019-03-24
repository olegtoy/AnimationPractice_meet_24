package com.practice.olegtojgildin.animationpractice;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.animation.AnimationSet;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

/**
 * Created by olegtojgildin on 24/03/2019.
 */

public class InterpolatorAnimationActivity extends AppCompatActivity {
    private ImageView image1;
    private ImageView image2;
    private ImageView image3;
    private ImageView image4;
    private ImageView image5;
    private ValueAnimator rotateAnimator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.interpolator_activityy);
        init();
    }

    private void init() {
        image1 = findViewById(R.id.image1);
        image1.setImageDrawable(getResources().getDrawable(R.drawable.and1, getTheme()));

        image2 = findViewById(R.id.image2);
        image2.setImageDrawable(getResources().getDrawable(R.drawable.and2, getTheme()));

        image4 = findViewById(R.id.image3);
        image4.setImageDrawable(getResources().getDrawable(R.drawable.and3, getTheme()));

        image3 = findViewById(R.id.image4);
        image3.setImageDrawable(getResources().getDrawable(R.drawable.and4, getTheme()));

        image5 = findViewById(R.id.image4);
        image5.setImageDrawable(getResources().getDrawable(R.drawable.and3, getTheme()));


        float startPosition = image1.getX();
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        float endPosition = size.x - image1.getPaddingRight() - 160;

        rotateAnimator = ValueAnimator.ofFloat(0, 3600);
        rotateAnimator.addUpdateListener((animator) -> {
            image1.setRotation((float) animator.getAnimatedValue());
            image2.setRotation((float) animator.getAnimatedValue());
            image4.setRotation((float) animator.getAnimatedValue());
            image3.setRotation((float) animator.getAnimatedValue());
            image5.setRotation((float) animator.getAnimatedValue());
        });
        rotateAnimator.setDuration(5000);
        rotateAnimator.start();

        ValueAnimator image1Animator = ValueAnimator.ofFloat(startPosition, endPosition);
        image1Animator.addUpdateListener((animator) -> {
            image1.setX((float) animator.getAnimatedValue());
            image1.setY((float) (Math.sin((float) animator.getAnimatedValue() / 50) * 50));
        });
        image1Animator.setDuration(5000);
        image1Animator.start();

        ValueAnimator image2PositionAnimator = ValueAnimator.ofFloat(startPosition, endPosition);
        image2PositionAnimator.addUpdateListener((animator) -> {
            image2.setX((float) animator.getAnimatedValue());
        });
        image2PositionAnimator.setDuration(5000);
        image2PositionAnimator.setInterpolator(new LinearOutSlowInInterpolator());
        image2PositionAnimator.start();

        ValueAnimator image3Animator = ValueAnimator.ofFloat(startPosition, endPosition);
        image3Animator.addUpdateListener((animator) -> {
            image4.setX((float) animator.getAnimatedValue());
        });
        image3Animator.setDuration(5000);
        image3Animator.setInterpolator(new BounceInterpolator());
        image3Animator.start();

        ValueAnimator image4Animator = ValueAnimator.ofFloat(startPosition, endPosition);
        image4Animator.addUpdateListener((animator) -> {
            image3.setX((float) animator.getAnimatedValue());
        });
        image4Animator.setDuration(5000);
        image4Animator.setInterpolator(new AnticipateInterpolator());
        image4Animator.start();

        ValueAnimator image5Animator = ValueAnimator.ofFloat(startPosition, endPosition);
        image5Animator.addUpdateListener((animator) -> {
            image5.setX((float) animator.getAnimatedValue());
        });
        image5Animator.setDuration(5000);
        image5Animator.setInterpolator(new AnticipateInterpolator());
        image5Animator.start();

    }

    public static Intent getIntent(Context context) {
        return new Intent(context, InterpolatorAnimationActivity.class);
    }
}
