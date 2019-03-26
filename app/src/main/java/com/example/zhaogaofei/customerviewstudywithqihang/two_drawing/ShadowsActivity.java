package com.example.zhaogaofei.customerviewstudywithqihang.two_drawing;

import android.content.Context;
import android.content.Intent;
import android.graphics.BlurMaskFilter;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zhaogaofei.customerviewstudywithqihang.R;
import com.example.zhaogaofei.customerviewstudywithqihang.two_drawing.customer.BlurMaskFilterView;
import com.example.zhaogaofei.customerviewstudywithqihang.two_drawing.customer.ShadowLayerView;

public class ShadowsActivity extends AppCompatActivity {

    public static void start(Context context) {
        context.startActivity(new Intent(context, ShadowsActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shadows);

        initView();
    }

    private void initView() {
        ImageView imageView = findViewById(R.id.iv_layer_images);
        imageView.setImageResource(R.drawable.layer_image);

        ShadowLayerView shadowLayerView = findViewById(R.id.shadow_layer_view);

        findViewById(R.id.bt_add_radius).setOnClickListener((v -> {
            shadowLayerView.addRadius(5);
        }));
        findViewById(R.id.bt_add_dx).setOnClickListener((v -> {
            shadowLayerView.addDx(5);
        }));
        findViewById(R.id.bt_add_dy).setOnClickListener((v -> {
            shadowLayerView.addDy(5);
        }));
        findViewById(R.id.bt_reset).setOnClickListener((v -> {
            shadowLayerView.reset();
        }));
        findViewById(R.id.bt_show_shadow).setOnClickListener((v -> {
            shadowLayerView.showShadow();
        }));
        findViewById(R.id.bt_clear_shadow).setOnClickListener((v -> {
            shadowLayerView.clearShadow();
        }));

        TextView textView = findViewById(R.id.tv_shadow0);
        textView.setShadowLayer(3, 10, 10, Color.GRAY);

        BlurMaskFilterView blurMaskFilterView = findViewById(R.id.blur_view);
        findViewById(R.id.bt_blur_normal).setOnClickListener((v -> {
            blurMaskFilterView.setBlurStyle(BlurMaskFilter.Blur.NORMAL);
        }));
        findViewById(R.id.bt_blur_solid).setOnClickListener((v -> {
            blurMaskFilterView.setBlurStyle(BlurMaskFilter.Blur.SOLID);
        }));
        findViewById(R.id.bt_blur_inner).setOnClickListener((v -> {
            blurMaskFilterView.setBlurStyle(BlurMaskFilter.Blur.INNER);
        }));
        findViewById(R.id.bt_blur_outer).setOnClickListener((v -> {
            blurMaskFilterView.setBlurStyle(BlurMaskFilter.Blur.OUTER);
        }));
    }
}
