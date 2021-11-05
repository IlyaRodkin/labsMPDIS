package com.example.lab4;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ObjectAnimator animation1;
    private ObjectAnimator animation2;
    private View button;
    private TextView text;
    private Random randon;
    private int width;
    private int height;
    private AnimatorSet set;
    private Animation animationRotateCenter, fadeInAnimation, fadeOutAnimation;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        animationRotateCenter = AnimationUtils.loadAnimation(this, R.anim.rotate);
        fadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fadein);
        fadeOutAnimation = AnimationUtils.loadAnimation(this, R.anim.fadeout);

        text = (TextView) findViewById(R.id.textView1);

        width = getWindowManager().getDefaultDisplay().getWidth();
        height = getWindowManager().getDefaultDisplay().getHeight();
        randon = new Random();
        set = createAnimation();
        set.start();
        set.addListener(new AnimatorListenerAdapter() {


            @Override
            public void onAnimationEnd(Animator animation) {
                int nextX = randon.nextInt(width);
                int nextY = randon.nextInt(height);
                animation1 = ObjectAnimator.ofFloat(button, "x", button.getX(), nextX);
                animation1.setDuration(1400);
                animation2 = ObjectAnimator.ofFloat(button, "y", button.getY(), nextY);
                animation2.setDuration(1400);
                set.playTogether(animation1, animation2);
                set.start();
            }
        });

    }


    public void onClick(View view) {

        text.setText(((Button) view).getText());

        if(view.getId() == R.id.rotate){
            text.startAnimation(animationRotateCenter);
        } else if(view.getId() == R.id.group){
            text.startAnimation(animationRotateCenter);
            button.startAnimation(animationRotateCenter);
        } else if(view.getId() == R.id.fade){
            text.startAnimation(fadeInAnimation);
            text.setVisibility(View.INVISIBLE);
        } else if(view.getId() == R.id.animate){
            text.startAnimation(fadeOutAnimation);
            text.setVisibility(View.VISIBLE);
        }

    }


    @TargetApi(Build.VERSION_CODES.HONEYCOMB)

    @SuppressLint("NewApi")

    private AnimatorSet createAnimation() {

        int nextX = randon.nextInt(width);
        int nextY = randon.nextInt(height);
        button = (View) findViewById(R.id.imageView1);
        animation1 = ObjectAnimator.ofFloat(button, "x", nextX);
        animation1.setDuration(1400);
        animation2 = ObjectAnimator.ofFloat(button, "y", nextY);
        animation2.setDuration(1400);
        AnimatorSet set = new AnimatorSet();
        set.playTogether(animation1, animation2);
        return set;

    }


}