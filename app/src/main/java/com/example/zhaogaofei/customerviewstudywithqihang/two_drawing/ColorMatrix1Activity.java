package com.example.zhaogaofei.customerviewstudywithqihang.two_drawing;

import android.content.Context;
import android.content.Intent;
import android.graphics.ColorMatrix;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.zhaogaofei.customerviewstudywithqihang.R;
import com.example.zhaogaofei.customerviewstudywithqihang.two_drawing.customer.ColorMatrixTest1View;
import com.example.zhaogaofei.customerviewstudywithqihang.two_drawing.customer.ColorMatrixTestView;

public class ColorMatrix1Activity extends AppCompatActivity {

    public static void start(Context context) {
        context.startActivity(new Intent(context, ColorMatrix1Activity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_matrix1);

        initView();
    }

    private void initView() {
        ColorMatrixTestView colorMatrixTestView = findViewById(R.id.color_matrix_1);
        SeekBar seekBar = findViewById(R.id.seek_bar);
        seekBar.setMax(20);
        seekBar.setProgress(1);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                colorMatrixTestView.set(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        TextView textView = findViewById(R.id.tv_degrees);
        ColorMatrixTest1View colorMatrixTest1View = findViewById(R.id.color_matrix_2);
        SeekBar seekBar1 = findViewById(R.id.seek_bar1);
        seekBar1.setMax(360);
        seekBar1.setProgress(180);
        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // 表示从-180到180
                int currentProgress = progress - 180;
                textView.setText("当前值为：" + currentProgress);
                colorMatrixTest1View.set(currentProgress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        RadioGroup radioGroup = findViewById(R.id.radio_group);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_red:
                        colorMatrixTest1View.setColorType(0);
                        break;
                    case R.id.rb_green:
                        colorMatrixTest1View.setColorType(1);
                        break;
                    case R.id.rb_blue:
                        colorMatrixTest1View.setColorType(2);
                        break;
                }
            }
        });
    }
}
