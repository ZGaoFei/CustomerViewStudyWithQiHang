package com.example.zhaogaofei.customerviewstudywithqihang.one_animator;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zhaogaofei.customerviewstudywithqihang.R;

public class AnimationActivity extends AppCompatActivity {
    private TextView tvAlpha;
    private TextView tvScale;
    private TextView tvTranslate;
    private TextView tvRotate;
    private TextView tvSet;
    private ImageView imageView;

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

        tvAlpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAlpha();
            }
        });
        tvScale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startScale();
            }
        });
        tvTranslate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTranslate();
            }
        });
        tvRotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startRotate();
            }
        });
        tvSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startSetAnimation();
            }
        });
    }

    private void startAlpha() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.alpha_animation);
        imageView.startAnimation(animation);
    }

    private void startScale() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.scale_animation);
        imageView.startAnimation(animation);
    }

    private void startTranslate() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.translate_animation);
        imageView.startAnimation(animation);
    }

    private void startRotate() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.rotate_animation);
        imageView.startAnimation(animation);
    }

    private void startSetAnimation() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.set_animation);
        imageView.startAnimation(animation);
    }
}
