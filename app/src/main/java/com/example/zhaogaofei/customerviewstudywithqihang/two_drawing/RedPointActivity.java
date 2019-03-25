package com.example.zhaogaofei.customerviewstudywithqihang.two_drawing;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.zhaogaofei.customerviewstudywithqihang.R;
import com.example.zhaogaofei.customerviewstudywithqihang.two_drawing.customer.RedPointView;

public class RedPointActivity extends AppCompatActivity {

    public static void start(Context context) {
        context.startActivity(new Intent(context, RedPointActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_red_point);
        RedPointView redPointView = findViewById(R.id.red_point_view);

        findViewById(R.id.bt_normal).setOnClickListener((v -> {
            redPointView.setType(RedPointView.POINT_TYPE_NORMAL);
        }));

        findViewById(R.id.bt_text).setOnClickListener((v -> {
            redPointView.setType(RedPointView.POINT_TYPE_TEXT);
        }));

        findViewById(R.id.bt_image).setOnClickListener((v -> {
            redPointView.setType(RedPointView.POINT_TYPE_IMAGE);
        }));

        findViewById(R.id.bt_red_point_reset).setOnClickListener((v -> {
            redPointView.reset();
        }));
    }
}
