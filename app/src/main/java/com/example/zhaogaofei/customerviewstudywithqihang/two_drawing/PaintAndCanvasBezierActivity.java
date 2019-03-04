package com.example.zhaogaofei.customerviewstudywithqihang.two_drawing;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.zhaogaofei.customerviewstudywithqihang.R;
import com.example.zhaogaofei.customerviewstudywithqihang.two_drawing.customer.PaintAndCanvasBezierView;

public class PaintAndCanvasBezierActivity extends AppCompatActivity {

    public static void start(Context context) {
        context.startActivity(new Intent(context, PaintAndCanvasBezierActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paint_and_canvas_bezier);

        PaintAndCanvasBezierView left = findViewById(R.id.bezier_left);
        left.setIsLeft(true);
        PaintAndCanvasBezierView right = findViewById(R.id.bezier_right);
        right.setIsLeft(false);

        Button btLeft = findViewById(R.id.bt_left_reset);
        btLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                left.reset();
            }
        });

        Button btRight = findViewById(R.id.bt_right_reset);
        btRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                right.reset();
            }
        });
    }
}
