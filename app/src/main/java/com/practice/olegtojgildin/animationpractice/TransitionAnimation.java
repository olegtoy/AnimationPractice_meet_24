package com.practice.olegtojgildin.animationpractice;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.ChangeBounds;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.ViewGroup;
import android.view.animation.BounceInterpolator;
import android.widget.Button;

/**
 * Created by olegtojgildin on 24/03/2019.
 */

public class TransitionAnimation extends AppCompatActivity {
    private int scene = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.transition_activity);
        init();
    }

    private void init(){
        ViewGroup scene_root = findViewById(R.id.scene_root);
        LayoutTransition transition = scene_root.getLayoutTransition();
        transition.enableTransitionType(LayoutTransition.CHANGING);

        final Scene scene1 = Scene.getSceneForLayout(scene_root, R.layout.scene1, this);
        final Scene scene2 = Scene.getSceneForLayout(scene_root, R.layout.scene2, this);
        final Scene scene3 = Scene.getSceneForLayout(scene_root, R.layout.scene3, this);

        Button switchButton = findViewById(R.id.switchButton);
        switchButton.setOnClickListener(v -> {
            TransitionSet transitionSet = new TransitionSet();
            transitionSet.addTransition(new ChangeBounds());
            transitionSet.setOrdering(TransitionSet.ORDERING_TOGETHER);
            transitionSet.setDuration(1500);
            transitionSet.setInterpolator(new BounceInterpolator());
            switch (scene){
                case 1:
                    TransitionManager.go(scene2, transitionSet);
                    scene = 2;
                    break;
                case 2:
                    TransitionManager.go(scene3, transitionSet);
                    scene = 3;
                    break;
                default:
                    TransitionManager.go(scene1, transitionSet);
                    scene = 1;
                    break;

            }
        });
    }

    public static Intent newIntent(Context context) {
        return new Intent(context, TransitionAnimation.class);
    }
}
