package com.practice.olegtojgildin.animationpractice;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

/**
 * Created by olegtojgildin on 24/03/2019.
 */

public class AnimationBaseXMLFragment extends DialogFragment {
    ImageView imageView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.base_animation_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imageView = view.findViewById(R.id.imageView2);

    }

    @Override
    public void onResume() {
        super.onResume();
        imageView.startAnimation(AnimationUtils.loadAnimation(getContext(),R.anim.base));

    }

    @Override
    public void onPause() {
        super.onPause();
    }
}
