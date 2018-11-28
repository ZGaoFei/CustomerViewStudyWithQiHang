package com.example.zhaogaofei.customerviewstudywithqihang.one_animator;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.zhaogaofei.customerviewstudywithqihang.R;

public class AnimatorOneActivity extends AppCompatActivity {

    public static void start(Context context) {
        Intent intent = new Intent(context, AnimatorOneActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator_one);

        findViewById(R.id.bt_animation).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimationActivity.start(AnimatorOneActivity.this);
            }
        });

        findViewById(R.id.bt_animator).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ValueAnimatorActivity.start(AnimatorOneActivity.this);
            }
        });

        findViewById(R.id.bt_animator_two).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimatorTwoActivity.start(AnimatorOneActivity.this);
            }
        });
    }
}
