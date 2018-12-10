package com.example.zhaogaofei.customerviewstudywithqihang;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * 测试冷启动时去除启动开始白屏的情况
 */
public class WelcomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppWelcome);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
