package com.example.zhaogaofei.customerviewstudywithqihang.two_drawing;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.zhaogaofei.customerviewstudywithqihang.R;

public class DrawingStartActivity extends AppCompatActivity {
    private DrawingStartActivity mActivity;

    public static void start(Context context) {
        context.startActivity(new Intent(context, DrawingStartActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawing_start);

        mActivity = this;
        initView();
    }

    private void initView() {
        findViewById(R.id.bt_paint_canvas).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PaintAndCanvasActivity.start(mActivity);
            }
        });

        findViewById(R.id.bt_paint_canvas2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PaintAndCanvas2Activity.start(mActivity);
            }
        });
    }
}
