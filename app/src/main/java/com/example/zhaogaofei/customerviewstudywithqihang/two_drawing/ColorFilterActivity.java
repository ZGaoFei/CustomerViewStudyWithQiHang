package com.example.zhaogaofei.customerviewstudywithqihang.two_drawing;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.zhaogaofei.customerviewstudywithqihang.R;

public class ColorFilterActivity extends AppCompatActivity {

    public static void start(Context context) {
        context.startActivity(new Intent(context, ColorFilterActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_filter);

        initView();
    }

    /**
     * 测试DrawableCompat.setTint()方法
     */
    private void initView() {
        ImageView iv02 = findViewById(R.id.iv_02);
        DrawableCompat.setTint(iv02.getDrawable(), ContextCompat.getColor(this, R.color.colorPrimary));

        ImageView iv03 = findViewById(R.id.iv_03);
        DrawableCompat.setTint(iv03.getDrawable(), ContextCompat.getColor(this, R.color.colorAccent));

        ImageView iv04 = findViewById(R.id.iv_04);
        DrawableCompat.setTint(iv04.getDrawable(), ContextCompat.getColor(this, R.color.black));

        ImageView iv05 = findViewById(R.id.iv_05);
        DrawableCompat.setTint(iv05.getDrawable(), ContextCompat.getColor(this, R.color.white));
    }
}
