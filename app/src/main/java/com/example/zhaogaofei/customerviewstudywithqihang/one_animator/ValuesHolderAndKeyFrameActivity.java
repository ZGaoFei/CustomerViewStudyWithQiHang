package com.example.zhaogaofei.customerviewstudywithqihang.one_animator;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zhaogaofei.customerviewstudywithqihang.R;
import com.example.zhaogaofei.customerviewstudywithqihang.one_animator.customer.CharEvaluator;
import com.example.zhaogaofei.customerviewstudywithqihang.one_animator.customer.CharTextView;

public class ValuesHolderAndKeyFrameActivity extends AppCompatActivity {
    private TextView tvStart;
    private CharTextView tvCancel;
    private ImageView imageView;

    public static void start(Context context) {
        Intent intent = new Intent(context, ValuesHolderAndKeyFrameActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_values_holder_and_key_frame);
        tvStart = findViewById(R.id.tv_start_other);
        tvCancel = findViewById(R.id.tv_cancel_other);
        imageView = findViewById(R.id.image_view_other);

        tvStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                animator1();

                // valuesHolderOfObject();

                // keyFrame();
                // keyFrame2();
                // keyFrame3();
                // keyFrame4();
                keyFrame5();
            }
        });
    }

    private void animator1() {
        PropertyValuesHolder valuesHolder = PropertyValuesHolder.ofFloat("rotation", 0, 180, 270, 360, 0);
        PropertyValuesHolder valuesHolder1 = PropertyValuesHolder.ofFloat("translationX", 0, 100, 200, 150, 0);

        ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(imageView, valuesHolder, valuesHolder1);
        objectAnimator.setDuration(2000);
        objectAnimator.setInterpolator(new BounceInterpolator());
        objectAnimator.start();
    }

    private void valuesHolderOfObject() {
         PropertyValuesHolder valuesHolder = PropertyValuesHolder.ofObject("CharText", new CharEvaluator(), new Character('A'), new Character('z'));

         ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(tvCancel, valuesHolder);
         objectAnimator.setDuration(2000);
         objectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
         objectAnimator.start();
    }

    // 没有插值器
    private void keyFrame() {
        Keyframe keyframe = Keyframe.ofFloat(0, 0);
        Keyframe keyframe1 = Keyframe.ofFloat(0.1f, 30);
        Keyframe keyframe2 = Keyframe.ofFloat(0.2f, 90);
        Keyframe keyframe3 = Keyframe.ofFloat(0.5f, 180);
        Keyframe keyframe4 = Keyframe.ofFloat(0.8f, 270);
        Keyframe keyframe5 = Keyframe.ofFloat(1, 360);

        PropertyValuesHolder valuesHolder = PropertyValuesHolder.ofKeyframe("rotation", keyframe, keyframe1, keyframe2, keyframe3, keyframe4, keyframe5);

        ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(imageView, valuesHolder);
        objectAnimator.setDuration(2000);
        objectAnimator.setInterpolator(new BounceInterpolator());
        objectAnimator.start();
    }

    // 单一设置插值器
    private void keyFrame2() {
        Keyframe keyframe = Keyframe.ofFloat(0, 0);
        Keyframe keyframe1 = Keyframe.ofFloat(0.1f, 30);
        keyframe1.setInterpolator(new AccelerateDecelerateInterpolator());
        Keyframe keyframe2 = Keyframe.ofFloat(0.2f, 90);
        keyframe2.setInterpolator(new BounceInterpolator());
        Keyframe keyframe3 = Keyframe.ofFloat(0.5f, 180);
        keyframe3.setInterpolator(new AnticipateOvershootInterpolator());
        Keyframe keyframe4 = Keyframe.ofFloat(0.8f, 270);
        Keyframe keyframe5 = Keyframe.ofFloat(1, 360);

        PropertyValuesHolder valuesHolder = PropertyValuesHolder.ofKeyframe("rotation", keyframe, keyframe1, keyframe2, keyframe3, keyframe4, keyframe5);

        ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(imageView, valuesHolder);
        objectAnimator.setDuration(4000);
        objectAnimator.setInterpolator(new BounceInterpolator());
        objectAnimator.start();
    }

    // ofObject
    private void keyFrame3() {
        Keyframe keyframe = Keyframe.ofObject(0, new Character('A'));
        Keyframe keyframe1 = Keyframe.ofObject(0.3f, new Character('O'));
        Keyframe keyframe2 = Keyframe.ofObject(0.7f, new Character('c'));
        Keyframe keyframe3 = Keyframe.ofObject(1, new Character('z'));

        PropertyValuesHolder valuesHolder = PropertyValuesHolder.ofKeyframe("CharText", keyframe, keyframe1, keyframe2, keyframe3);
        valuesHolder.setEvaluator(new CharEvaluator());

        ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(tvCancel, valuesHolder);
        objectAnimator.setDuration(4000);
        objectAnimator.setInterpolator(new BounceInterpolator());
        objectAnimator.start();
    }

    // 只设置一帧的情况:IndexOutOfBoundsException
    private void keyFrame4() {
        Keyframe keyframe = Keyframe.ofFloat(0, 0);

        PropertyValuesHolder valuesHolder = PropertyValuesHolder.ofKeyframe("rotation", keyframe);

        ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(imageView, valuesHolder);
        objectAnimator.setDuration(4000);
        objectAnimator.setInterpolator(new BounceInterpolator());
        objectAnimator.start();
    }

    // 操作多属性
    private void keyFrame5() {
        Keyframe keyframe = Keyframe.ofFloat(0, 0);
        Keyframe keyframe1 = Keyframe.ofFloat(0.1f, 30);
        Keyframe keyframe2 = Keyframe.ofFloat(0.2f, 90);
        Keyframe keyframe3 = Keyframe.ofFloat(0.5f, 180);
        Keyframe keyframe4 = Keyframe.ofFloat(0.8f, 270);
        Keyframe keyframe5 = Keyframe.ofFloat(1, 360);

        PropertyValuesHolder valuesHolder = PropertyValuesHolder.ofKeyframe("rotation", keyframe, keyframe1, keyframe2, keyframe3, keyframe4, keyframe5);

        Keyframe keyframe0 = Keyframe.ofFloat(0, 0);
        Keyframe keyframe01 = Keyframe.ofFloat(0.1f, 30);
        Keyframe keyframe02 = Keyframe.ofFloat(0.2f, 90);
        Keyframe keyframe03 = Keyframe.ofFloat(0.5f, 180);
        Keyframe keyframe04 = Keyframe.ofFloat(0.8f, 270);
        Keyframe keyframe05 = Keyframe.ofFloat(1, 360);

        PropertyValuesHolder valuesHolder1 = PropertyValuesHolder.ofKeyframe("translationX", keyframe0, keyframe01, keyframe02, keyframe03, keyframe04, keyframe05);

        ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(imageView, valuesHolder, valuesHolder1);
        objectAnimator.setDuration(2000);
        objectAnimator.setInterpolator(new BounceInterpolator());
        objectAnimator.start();
    }
}
