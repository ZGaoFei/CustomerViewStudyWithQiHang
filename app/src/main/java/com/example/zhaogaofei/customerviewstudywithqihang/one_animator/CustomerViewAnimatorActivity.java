package com.example.zhaogaofei.customerviewstudywithqihang.one_animator;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.TextView;

import com.example.zhaogaofei.customerviewstudywithqihang.R;
import com.example.zhaogaofei.customerviewstudywithqihang.one_animator.customer.CharEvaluator;
import com.example.zhaogaofei.customerviewstudywithqihang.one_animator.customer.PointView;

public class CustomerViewAnimatorActivity extends AppCompatActivity {
    private TextView tvStart;
    private TextView tvChar;

    private PointView pointView;

    public static void start(Context context) {
        Intent intent = new Intent(context, CustomerViewAnimatorActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator_two);

        tvStart = findViewById(R.id.tv_start_animator_two);
        tvChar = findViewById(R.id.tv_char_animator_two);

        tvStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animatorStart();

                // pointView.startDrawAnimator();
            }
        });

        pointView = findViewById(R.id.point_view);
    }

    private void animatorStart() {
        ValueAnimator valueAnimator = ValueAnimator.ofObject(new CharEvaluator(), new Character('A'), new Character('z'));
        valueAnimator.setDuration(3000);
        valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                char animatedValue = (char) animation.getAnimatedValue();
                tvChar.setText(String.valueOf(animatedValue));
            }
        });
        valueAnimator.start();
    }

}
