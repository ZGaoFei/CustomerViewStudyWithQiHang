package com.example.zhaogaofei.customerviewstudywithqihang.one_animator;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.IntEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zhaogaofei.customerviewstudywithqihang.R;
import com.example.zhaogaofei.customerviewstudywithqihang.Utils;
import com.example.zhaogaofei.customerviewstudywithqihang.one_animator.customer.CustomerInterpolator;

public class ValueAnimatorActivity extends AppCompatActivity {
    private TextView tvStart;
    private TextView tvCancel;
    private ImageView imageView;

    private ValueAnimator animator;

    private int positionX;
    private int positionY;
    private int screenWidth;
    private int screenHeight;
    private int viewWidth;
    private int viewHeight;

    public static void start(Context context) {
        Intent intent = new Intent(context, ValueAnimatorActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value_animator);

        tvStart = findViewById(R.id.tv_start_value_animator);
        tvCancel = findViewById(R.id.tv_cancel_value_animator);
        imageView = findViewById(R.id.image_view_value_animator);

        screenWidth = Utils.getScreenWidth(this);
        screenHeight = Utils.getScreenHeight(this);
        viewWidth = Utils.dip2px(this, 250);
        viewHeight = Utils.dip2px(this, 200);

        tvStart.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                // valueAnimator();

                // valueAnimator2();

                // startToAllScreen();

                changeColor();
            }
        });

        tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // animator.cancel();

                startToDefault();
            }
        });
    }

    private void valueAnimator() {
        final int defaultLocation = Utils.dip2px(this, 40);
        int resultLocation = Utils.dip2px(this, 200);
        animator = ValueAnimator.ofInt(defaultLocation, resultLocation);
        animator.setDuration(2000);
        // animator.setRepeatCount(2);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setRepeatMode(ValueAnimator.REVERSE);
        // animator.setEvaluator(new CustomerEvaluator());
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int value = (int) animation.getAnimatedValue();
                Log.e("zgf", "===value====" + value);

                // 垂直往下运行
                imageView.layout(0, value, imageView.getWidth(), value + imageView.getHeight());
                // 水平运行
                // imageView.layout(value, defaultLocation, value + imageView.getWidth(), defaultLocation + imageView.getHeight());
            }
        });

        animator.setStartDelay(1000);
        animator.start();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void valueAnimator2() {
        animator = ValueAnimator.ofArgb(0xaaaaaa, 0xffffff);
//        animator.setRepeatCount(2);
        animator.setDuration(2000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int value = (int) animation.getAnimatedValue();
                Log.e("zgf", "===value=====" + value);

                tvStart.setBackgroundColor(Color.argb(Color.alpha(value), Color.red(value), Color.green(value), Color.blue(value)));
            }
        });
        animator.start();
    }

    // 添加监听事件的方式
    private void setAnimatorListener() {
        animator = ValueAnimator.ofFloat(0f, 100f);
        animator.setDuration(2000);
        animator.setRepeatCount(2);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setRepeatMode(ValueAnimator.REVERSE);

        animator.addListener(new Animator.AnimatorListener() {
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

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            animator.addPauseListener(new Animator.AnimatorPauseListener() {
                @Override
                public void onAnimationPause(Animator animation) {

                }

                @Override
                public void onAnimationResume(Animator animation) {

                }
            });
        }

        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationCancel(Animator animation) {
                super.onAnimationCancel(animation);
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                super.onAnimationRepeat(animation);
            }

            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
            }

            @Override
            public void onAnimationPause(Animator animation) {
                super.onAnimationPause(animation);
            }

            @Override
            public void onAnimationResume(Animator animation) {
                super.onAnimationResume(animation);
            }
        });

        animator.start();
    }

    // 展开全屏效果
    private void startToAllScreen() {
        // getPosition();

        ValueAnimator valueAnimator = ValueAnimator.ofInt(0, 100);
        valueAnimator.setDuration(2000);
        valueAnimator.setInterpolator(new CustomerInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            private IntEvaluator mEvaluator = new IntEvaluator();

            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int currentValue = (int) animation.getAnimatedValue();
                // Log.e("zgf", "====currentValue=======" + currentValue);
                float fraction = currentValue / 100f;
                ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) imageView.getLayoutParams();
                params.width = mEvaluator.evaluate(fraction, viewWidth, screenWidth);
                params.height = mEvaluator.evaluate(fraction, viewHeight, screenHeight);
                params.leftMargin = mEvaluator.evaluate(fraction, positionX, 0);
                params.topMargin = mEvaluator.evaluate(fraction, positionY, 0);
                imageView.setLayoutParams(params);
            }
        });
        valueAnimator.start();
    }

    // 缩小回原大小
    private void startToDefault() {
        // getPosition();

        ValueAnimator valueAnimator = ValueAnimator.ofInt(0, 100);
        valueAnimator.setDuration(2000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            private IntEvaluator mEvaluator = new IntEvaluator();

            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int currentValue = (int) animation.getAnimatedValue();
                float fraction = currentValue / 100f;
                ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) imageView.getLayoutParams();
                params.width = mEvaluator.evaluate(fraction, screenWidth, viewWidth);
                params.height = mEvaluator.evaluate(fraction, screenHeight, viewHeight);
                params.leftMargin = mEvaluator.evaluate(fraction, 0, positionX);
                params.topMargin = mEvaluator.evaluate(fraction, 0, positionY);
                imageView.setLayoutParams(params);
            }
        });
        valueAnimator.start();
    }

    private void getPosition() {
        int[] position = new int[2];
        imageView.getLocationInWindow(position);
        positionX = position[0];
        positionY = position[1];
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void changeColor() {
        ValueAnimator valueAnimator = ValueAnimator.ofArgb(0xffffff00, 0xff0000ff);
        // ValueAnimator valueAnimator = ValueAnimator.ofInt(0xff000000, 0xffffffff);
        valueAnimator.setDuration(2000);
        // valueAnimator.setEvaluator(new ArgbEvaluator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int animatedValue = (int) animation.getAnimatedValue();
                tvStart.setBackgroundColor(animatedValue);
            }
        });
        valueAnimator.start();

    }

    // xml动画
    private void xmlToAnimator() {
        Animator animator = AnimatorInflater.loadAnimator(this, R.animator.values_animator);
        animator.start();
    }
}
