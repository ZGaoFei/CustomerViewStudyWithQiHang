package com.example.zhaogaofei.customerviewstudywithqihang;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.zhaogaofei.customerviewstudywithqihang.one_animator.AnimatorStartActivity;

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

            }
        });

        findViewById(R.id.bt_three).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
