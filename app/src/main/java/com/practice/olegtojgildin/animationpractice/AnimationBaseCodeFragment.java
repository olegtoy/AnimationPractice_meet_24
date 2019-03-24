package com.practice.olegtojgildin.animationpractice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

/**
 * Created by olegtojgildin on 24/03/2019.
 */

public class AnimationBaseCodeFragment extends DialogFragment {
    ImageView imageView;
    Animation animation;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.base_code_animation, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imageView = view.findViewById(R.id.imageView3);

        animation = new AlphaAnimation(0.0f, 1.0f);
        animation.setDuration(2000);
        animation.setInterpolator(new AccelerateInterpolator());
    }

    @Override
    public void onResume() {
        super.onResume();
        imageView.startAnimation(animation);
    }
}
