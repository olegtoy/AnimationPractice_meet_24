package com.practice.olegtojgildin.animationpractice;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFragmentManager = getSupportFragmentManager();
        init();
    }

    public void init() {
        Button animationDrawble=findViewById(R.id.AnimationDrawableButton);
        animationDrawble.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AnimationDrawableFragment  fragment=new AnimationDrawableFragment();
                mFragmentManager.beginTransaction()
                        .add(fragment, "animation drawable")
                        .commitNow();
            }
        });

        Button animationBaseDrawble=findViewById(R.id.AnimationBaseButton);
        animationBaseDrawble.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AnimationBaseXMLFragment  fragment=new AnimationBaseXMLFragment();
                mFragmentManager.beginTransaction()
                        .add(fragment, "animation base drawable")
                        .commitNow();
            }
        });

        Button animationBaseCodeDrawble=findViewById(R.id.AnimationCodeBaseButton);
        animationBaseCodeDrawble.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AnimationBaseCodeFragment  fragment=new AnimationBaseCodeFragment();
                mFragmentManager.beginTransaction()
                        .add(fragment, "animation base code drawable")
                        .commitNow();
            }
        });

        Button interpolatorButton=findViewById(R.id.InterpolatorButton);
        interpolatorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               startActivity(InterpolatorAnimationActivity.getIntent(getApplicationContext()));
            }
        });

        Button transitionButton=findViewById(R.id.TransitionButton);
        transitionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(TransitionAnimation.newIntent(getApplicationContext()));
            }
        });
    }
}
