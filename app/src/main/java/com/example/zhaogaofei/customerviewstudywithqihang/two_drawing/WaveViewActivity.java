package com.example.zhaogaofei.customerviewstudywithqihang.two_drawing;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.zhaogaofei.customerviewstudywithqihang.R;
import com.example.zhaogaofei.customerviewstudywithqihang.two_drawing.customer.WaveView;

public class WaveViewActivity extends AppCompatActivity {

    public static void start(Context context) {
        context.startActivity(new Intent(context, WaveViewActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wave_view);

        WaveView waveView = findViewById(R.id.wave_view);
        waveView.startAnimation();
    }
}
