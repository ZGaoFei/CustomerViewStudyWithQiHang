package com.example.zhaogaofei.customerviewstudywithqihang.three_view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.zhaogaofei.customerviewstudywithqihang.R;

public class MyLinearLayoutActivity extends AppCompatActivity {

    public static void start(Context context) {
        context.startActivity(new Intent(context, MyLinearLayoutActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_linear_layout);
    }
}
