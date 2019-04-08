package com.example.zhaogaofei.customerviewstudywithqihang.three_view;

import java.util.Random;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.zhaogaofei.customerviewstudywithqihang.R;
import com.example.zhaogaofei.customerviewstudywithqihang.three_view.customerview.WaterFallLayout;

public class WaterFallLayoutActivity extends AppCompatActivity {
    private WaterFallLayout layout;

    public static void start(Context context) {
        context.startActivity(new Intent(context, WaterFallLayoutActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_fall_layout);

        initView();
    }

    private void initView() {
        ImageView ivAdd = findViewById(R.id.iv_add);
        ivAdd.setOnClickListener(v -> addView());

        layout = findViewById(R.id.water_fall_layout);
    }

    private void addView() {
        int num = new Random().nextInt(5);
        WaterFallLayout.WaterFallLayoutParams layoutParams = new WaterFallLayout.WaterFallLayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        ImageView imageView = new ImageView(this);
        switch (num) {
            case 0:
                imageView.setImageResource(R.mipmap.angle);
                break;
            case 1:
                imageView.setImageResource(R.mipmap.timo);
                break;
            case 2:
                imageView.setImageResource(R.mipmap.timu2);
                break;
            case 3:
                imageView.setImageResource(R.mipmap.dog);
                break;
            case 4:
                imageView.setImageResource(R.mipmap.timg);
                break;
        }
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        layout.addView(imageView, layoutParams);

        layout.setOnItemClick((v, p) -> {
            Toast.makeText(WaterFallLayoutActivity.this, "this is num: " + p + " view", Toast.LENGTH_SHORT).show();
        });
    }
}
