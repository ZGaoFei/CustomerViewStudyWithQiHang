package com.example.zhaogaofei.customerviewstudywithqihang.three_view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.zhaogaofei.customerviewstudywithqihang.R;

public class ViewStartActivity extends AppCompatActivity {
    private Context context;

    public static void start(Context context) {
        context.startActivity(new Intent(context, ViewStartActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_start);
        context = this;
        initView();
    }

    private void initView() {
        findViewById(R.id.bt_view_01).setOnClickListener((v -> MyLinearLayoutActivity.start(context)));

        findViewById(R.id.bt_view_02).setOnClickListener((v -> FlowLayoutActivity.start(context)));

        findViewById(R.id.bt_view_03).setOnClickListener((v -> WaterFallLayoutActivity.start(context)));
    }
}
