package com.practice.olegtojgildin.animationpractice;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by olegtojgildin on 24/03/2019.
 */

public class AnimationDrawableFragment extends DialogFragment {
    private AnimationDrawable animation;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.animation_drawable_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView imageView = view.findViewById(R.id.image_view);
        imageView.setBackgroundResource(R.drawable.animation_drawable);
        animation = (AnimationDrawable) imageView.getBackground();
    }

    @Override
    public void onResume() {
        super.onResume();
        animation.start();
    }

    @Override
    public void onPause() {
        super.onPause();
        animation.stop();
    }
}
