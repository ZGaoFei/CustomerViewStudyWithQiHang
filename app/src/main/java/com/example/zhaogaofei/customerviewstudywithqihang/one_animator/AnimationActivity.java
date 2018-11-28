package com.example.zhaogaofei.customerviewstudywithqihang.one_animator;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.example.zhaogaofei.customerviewstudywithqihang.R;
import com.example.zhaogaofei.customerviewstudywithqihang.one_animator.customer.CustomerInterpolator;

public class AnimationActivity extends AppCompatActivity {
    private TextView tvAlpha;
    private TextView tvScale;
    private TextView tvTranslate;
    private TextView tvRotate;
    private TextView tvSet;
    private ImageView imageView;
    private Switch switchView;
    private boolean isChecked = false;

    public static void start(Context context) {
        Intent intent = new Intent(context, AnimationActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        tvAlpha = findViewById(R.id.tv_alpha);
        tvScale = findViewById(R.id.tv_scale);
        tvTranslate = findViewById(R.id.tv_translate);
        tvRotate = findViewById(R.id.tv_rotate);
        tvSet = findViewById(R.id.tv_set);
        imageView = findViewById(R.id.iv_animation);
        switchView = findViewById(R.id.switch_animation);

        tvAlpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isChecked) {
                    startAlphaWithCode();
                } else {
                    startAlpha();
                }
            }
        });
        tvScale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isChecked) {
                    startScaleWithCode();
                } else {
                    startScale();
                }
            }
        });
        tvTranslate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isChecked) {
                    startTranslateWithCode();
                } else {
                    startTranslate();
                }
            }
        });
        tvRotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isChecked) {
                    startRotateWithCode();
                } else {
                    startRotate();
                }
            }
        });
        tvSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isChecked) {
                    startSetAnimation();
                } else {
                    startSetAnimationWithCode();
                }
            }
        });
        switchView.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                AnimationActivity.this.isChecked = isChecked;
            }
        });
    }

    private void startAlpha() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.alpha_animation);
        imageView.startAnimation(animation);
    }

    private void startAlphaWithCode() {
        AlphaAnimation animation = new AlphaAnimation(1.0f, 0.1f);
        animation.setDuration(2000);
        animation.setFillAfter(true);
        animation.setRepeatCount(3);
        animation.setRepeatMode(Animation.RESTART);
        animation.setInterpolator(new AccelerateInterpolator());
        imageView.startAnimation(animation);
    }

    private void startScale() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.scale_animation);
        imageView.startAnimation(animation);
    }

    private void startScaleWithCode() {
        // ScaleAnimation animation = new ScaleAnimation(1.0F, 0.5F, 1.0F, 0.5F);
        // 设置锚点
        // ScaleAnimation animation = new ScaleAnimation(1.0F, 0.5F, 1.0F, 0.5F, 0.5F, 0.5F);
        // 设置锚点类型
        ScaleAnimation animation = new ScaleAnimation(1.0F, 0.5F, 1.0F, 0.5F, Animation.RELATIVE_TO_SELF, 0.5F, Animation.RELATIVE_TO_SELF, 0.5F);
        animation.setDuration(2000);
        animation.setFillAfter(true);
        animation.setRepeatCount(3);
        animation.setRepeatMode(Animation.RESTART);
        animation.setInterpolator(new AccelerateInterpolator());
        imageView.startAnimation(animation);
    }

    private void startTranslate() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.translate_animation);
        animation.setInterpolator(new CustomerInterpolator());
        imageView.startAnimation(animation);
    }

    private void startTranslateWithCode() {
        // TranslateAnimation animation = new TranslateAnimation(0, 100, 0, 100);
        TranslateAnimation animation = new TranslateAnimation(Animation.ABSOLUTE,0, Animation.ABSOLUTE, 200, Animation.ABSOLUTE, 0, Animation.ABSOLUTE, 200);
        animation.setDuration(2000);
        animation.setFillAfter(true);
        animation.setRepeatCount(3);
        animation.setRepeatMode(Animation.RESTART);
        animation.setInterpolator(new AccelerateInterpolator());
        imageView.startAnimation(animation);
    }

    private void startRotate() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.rotate_animation);
        imageView.startAnimation(animation);
    }

    private void startRotateWithCode() {
        // RotateAnimation animation = new RotateAnimation(0, 360);
        // RotateAnimation animation = new RotateAnimation(0, 360, 50f, 50f);
        RotateAnimation animation = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        animation.setDuration(2000);
        animation.setFillAfter(true);
        animation.setRepeatCount(3);
        animation.setRepeatMode(Animation.RESTART);
        animation.setInterpolator(new AccelerateInterpolator());
        imageView.startAnimation(animation);
    }

    private void startSetAnimation() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.set_animation);
        imageView.startAnimation(animation);
    }

    private void startSetAnimationWithCode() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.1f);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0F, 0.5F, 1.0F, 0.5F);
        TranslateAnimation translateAnimation = new TranslateAnimation(0, 100, 0, 100);
        RotateAnimation rotateAnimation = new RotateAnimation(0, 360);

        AnimationSet animation = new AnimationSet(false);
        animation.setDuration(2000);
        animation.setFillAfter(true);
        animation.setInterpolator(new AccelerateInterpolator());

        animation.addAnimation(alphaAnimation);
        animation.addAnimation(scaleAnimation);
        animation.addAnimation(translateAnimation);
        animation.addAnimation(rotateAnimation);

        imageView.setAnimation(animation);

        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}
