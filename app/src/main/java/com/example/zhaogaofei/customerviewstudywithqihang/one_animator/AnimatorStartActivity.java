package com.example.zhaogaofei.customerviewstudywithqihang.one_animator;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.zhaogaofei.customerviewstudywithqihang.R;

public class AnimatorStartActivity extends AppCompatActivity {

    public static void start(Context context) {
        Intent intent = new Intent(context, AnimatorStartActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator_one);

        findViewById(R.id.bt_animation).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimationActivity.start(AnimatorStartActivity.this);
            }
        });

        findViewById(R.id.bt_animator).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ValueAnimatorActivity.start(AnimatorStartActivity.this);
            }
        });

        findViewById(R.id.bt_animator_two).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomerViewAnimatorActivity.start(AnimatorStartActivity.this);
            }
        });

        findViewById(R.id.bt_object_animator).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimatorActivity.start(AnimatorStartActivity.this);
            }
        });

        findViewById(R.id.bt_other).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ValuesHolderAndKeyFrameActivity.start(AnimatorStartActivity.this);
            }
        });
    }
}
