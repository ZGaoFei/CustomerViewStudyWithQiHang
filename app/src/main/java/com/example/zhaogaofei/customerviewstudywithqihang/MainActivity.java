package com.example.zhaogaofei.customerviewstudywithqihang;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.zhaogaofei.customerviewstudywithqihang.one_animator.AnimatorStartActivity;
import com.example.zhaogaofei.customerviewstudywithqihang.three_view.ViewStartActivity;
import com.example.zhaogaofei.customerviewstudywithqihang.two_drawing.DrawingStartActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.bt_one).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimatorStartActivity.start(MainActivity.this);
            }
        });

        findViewById(R.id.bt_two).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DrawingStartActivity.start(MainActivity.this);
            }
        });

        findViewById(R.id.bt_three).setOnClickListener(v -> ViewStartActivity.start(MainActivity.this));
    }
}
