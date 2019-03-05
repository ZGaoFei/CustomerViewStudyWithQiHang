package com.example.zhaogaofei.customerviewstudywithqihang.two_drawing;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.zhaogaofei.customerviewstudywithqihang.R;
import com.example.zhaogaofei.customerviewstudywithqihang.two_drawing.customer.PaintAndCanvasOtherView;

public class PaintAndCanvasOtherActivity extends AppCompatActivity {

    public static void start(Context context) {
        context.startActivity(new Intent(context, PaintAndCanvasOtherActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paint_and_canvas_other);

        PaintAndCanvasOtherView view = findViewById(R.id.paint_canvas_other);
        // view.startAnimation();
    }
}
