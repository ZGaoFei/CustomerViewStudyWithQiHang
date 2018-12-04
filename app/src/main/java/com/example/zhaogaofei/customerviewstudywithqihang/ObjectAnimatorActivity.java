package com.example.zhaogaofei.customerviewstudywithqihang;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zhaogaofei.customerviewstudywithqihang.one_animator.customer.PointView;

public class ObjectAnimatorActivity extends Activity {
    private TextView tvStart;
    private TextView tvCancel;
    private ImageView imageView;
    private TextView textView;

    private ObjectAnimator objectAnimator;

    public static void start(Context context) {
        Intent intent = new Intent(context, ObjectAnimatorActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_animator);
        tvStart = findViewById(R.id.tv_start_object_animator);
        tvCancel = findViewById(R.id.tv_cancel_object_animator);
        imageView = findViewById(R.id.image_view_object_animator);
        textView = findViewById(R.id.tv_object_animator);

        tvStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ofInt();

                // ofFloat();

                pointViewAnimator();
            }
        });

        tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    /**
     *
     */
    private void ofInt() {
        imageView.setVisibility(View.VISIBLE);
        textView.setVisibility(View.GONE);

        objectAnimator = ObjectAnimator.ofInt(textView, "scaleX", 1, 0);
        objectAnimator.setDuration(2000);
        objectAnimator.start();
    }

    /**
     *  alpha
     *
     *  rotation,rotationX,rotationY
     *
     *  translationX,translationY,translationZ
     *
     *  scaleX,scaleY
     */
    private void ofFloat() {
        imageView.setVisibility(View.VISIBLE);
        textView.setVisibility(View.GONE);

        objectAnimator = ObjectAnimator.ofFloat(imageView, "scaleY", 0, 180, 0, 180);
        objectAnimator.setDuration(2000);
        objectAnimator.start();
    }

    private void pointViewAnimator() {
        PointView pointView = findViewById(R.id.point_view_object_animator);
        ObjectAnimator objectAnimator = ObjectAnimator.ofInt(pointView, "radius", 10, 50, 10, 80);
        objectAnimator.setDuration(2000);
        objectAnimator.start();
    }

}
