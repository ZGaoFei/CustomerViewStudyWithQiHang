package com.example.zhaogaofei.customerviewstudywithqihang.one_animator;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zhaogaofei.customerviewstudywithqihang.R;

public class AnimatorSetActivity extends AppCompatActivity {
    private ImageView ivAdd;
    private ImageView ivShare;
    private ImageView ivCode;
    private ImageView ivData;
    private ImageView ivMy;
    private ImageView ivTime;

    private boolean isShowed;

    private TextView tvStart;
    private ImageView imageView;
    private ImageView ivCopy;

    public static void start(Context context) {
        Intent intent = new Intent(context, AnimatorSetActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator_set);
        ivAdd = findViewById(R.id.iv_add);
        ivShare = findViewById(R.id.iv_share);
        ivCode = findViewById(R.id.iv_code);
        ivData = findViewById(R.id.iv_data);
        ivMy = findViewById(R.id.iv_my);
        ivTime = findViewById(R.id.iv_time);

        ivAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isShowed) {
                    isShowed = true;

                    doAnimateOpen(ivShare, 0, 5, 400);
                    doAnimateOpen(ivCode, 1, 5, 400);
                    doAnimateOpen(ivData, 2, 5, 400);
                    doAnimateOpen(ivMy, 3, 5, 400);
                    doAnimateOpen(ivTime, 4, 5, 400);
                } else {
                    isShowed = false;

                    doAnimateClose(ivShare, 0, 5, 400);
                    doAnimateClose(ivCode, 1, 5, 400);
                    doAnimateClose(ivData, 2, 5, 400);
                    doAnimateClose(ivMy, 3, 5, 400);
                    doAnimateClose(ivTime, 4, 5, 400);
                }
            }
        });

        tvStart = findViewById(R.id.tv_start_set);
        imageView = findViewById(R.id.iv_set);
        ivCopy = findViewById(R.id.iv_set_copy);
        tvStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // build();

                delayAnimator3();
            }
        });
    }

    private void doAnimateOpen(View view, int index, int total, int radius) {
        if (view.getVisibility() != View.VISIBLE) {
            view.setVisibility(View.VISIBLE);
        }
        double degree = Math.toRadians(90) / (total - 1) * index;
        int translationX = -(int) (radius * Math.sin(degree));
        int translationY = -(int) (radius * Math.cos(degree));

        AnimatorSet set = new AnimatorSet();
        //包含平移、缩放和透明度动画
        set.playTogether(
                ObjectAnimator.ofFloat(view, "translationX", 0, translationX),
                ObjectAnimator.ofFloat(view, "translationY", 0, translationY),
                ObjectAnimator.ofFloat(view, "scaleX", 0f, 1f),
                ObjectAnimator.ofFloat(view, "scaleY", 0f, 1f),
                ObjectAnimator.ofFloat(view, "alpha", 0f, 1));
        //动画周期为500ms
        set.setDuration(1 * 100).start();
    }

    private void doAnimateClose(final View view, int index, int total,
                                int radius) {
        if (view.getVisibility() != View.VISIBLE) {
            view.setVisibility(View.VISIBLE);
        }
        double degree = Math.PI * index / ((total - 1) * 2);
        int translationX = -(int) (radius * Math.sin(degree));
        int translationY = -(int) (radius * Math.cos(degree));
        AnimatorSet set = new AnimatorSet();
        //包含平移、缩放和透明度动画
        set.playTogether(
                ObjectAnimator.ofFloat(view, "translationX", translationX, 0),
                ObjectAnimator.ofFloat(view, "translationY", translationY, 0),
                ObjectAnimator.ofFloat(view, "scaleX", 1f, 0f),
                ObjectAnimator.ofFloat(view, "scaleY", 1f, 0f),
                ObjectAnimator.ofFloat(view, "alpha", 1f, 0f));

        set.setDuration(1 * 500).start();
    }

    private void build() {
        AnimatorSet set = new AnimatorSet();
        set.play(ObjectAnimator.ofFloat(imageView, "translationY", 0, 200))
                .with(ObjectAnimator.ofFloat(imageView, "translationX", 0, 200))
                .before(ObjectAnimator.ofFloat(imageView, "translationY", 200, 0))
                .after(ObjectAnimator.ofFloat(imageView, "translationX", 200, 0));
        set.setDuration(2000);
        set.start();

        set.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

    // =======验证set的setStartDelay()方法
    private void delayAnimator1() {
        ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(imageView, "translationY", 0, 200);
        objectAnimator1.setStartDelay(2000);
        ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(ivCopy, "translationY", 0, 200);

        AnimatorSet set = new AnimatorSet();
        set.play(objectAnimator1).with(objectAnimator2);
        set.setDuration(2000);
        set.setStartDelay(2000);
        set.start();
    }

    private void delayAnimator2() {
        ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(imageView, "translationY", 0, 200);
        ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(ivCopy, "translationY", 0, 200);
        objectAnimator2.setStartDelay(2000);

        AnimatorSet set = new AnimatorSet();
        set.play(objectAnimator1).with(objectAnimator2);
        set.setDuration(2000);
        set.setStartDelay(2000);
        set.start();
    }

    private void delayAnimator3() {
        ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(imageView, "translationY", 0, 200);
        objectAnimator1.setStartDelay(2000);
        ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(ivCopy, "translationY", 0, 200);
        objectAnimator2.setStartDelay(2000);

        AnimatorSet set = new AnimatorSet();
        set.play(objectAnimator1).with(objectAnimator2);
        set.setDuration(2000);
        set.setStartDelay(2000);
        set.start();
    }
}
