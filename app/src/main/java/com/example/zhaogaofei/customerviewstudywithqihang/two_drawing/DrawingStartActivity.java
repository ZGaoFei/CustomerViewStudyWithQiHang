package com.example.zhaogaofei.customerviewstudywithqihang.two_drawing;

import android.content.Context;
import android.content.Intent;
import android.graphics.ColorFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.zhaogaofei.customerviewstudywithqihang.R;

public class DrawingStartActivity extends AppCompatActivity {
    private DrawingStartActivity mActivity;

    public static void start(Context context) {
        context.startActivity(new Intent(context, DrawingStartActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawing_start);

        mActivity = this;
        initView();
    }

    private void initView() {
        findViewById(R.id.bt_paint_canvas).setOnClickListener((view) -> PaintAndCanvasActivity.start(mActivity));

        findViewById(R.id.bt_paint_canvas2).setOnClickListener((view) -> PaintAndCanvas2Activity.start(mActivity));

        findViewById(R.id.bt_paint_canvas3).setOnClickListener((view) -> PaintAndCanvas3Activity.start(mActivity));

        findViewById(R.id.bt_paint_canvas4).setOnClickListener((view) -> PaintAndCanvas4Activity.start(mActivity));

        findViewById(R.id.bt_paint_canvas5).setOnClickListener((view) -> PaintCanvasTextActivity.start(mActivity));

        findViewById(R.id.bt_paint_canvas6).setOnClickListener((view) -> PaintAndCanvasBezierActivity.start(mActivity));

        findViewById(R.id.bt_paint_canvas7).setOnClickListener((view) -> WaveViewActivity.start(mActivity));

        findViewById(R.id.bt_paint_canvas8).setOnClickListener((view) -> PaintAndCanvasOtherActivity.start(mActivity));

        findViewById(R.id.bt_paint_canvas9).setOnClickListener((view) -> ColorMatrix1Activity.start(mActivity));

        findViewById(R.id.bt_paint_canvas10).setOnClickListener((view) -> ColorFilterActivity.start(mActivity));

        findViewById(R.id.bt_paint_canvas11).setOnClickListener((view) -> XfermodeActivity.start(mActivity));

        findViewById(R.id.bt_paint_canvas12).setOnClickListener((view) -> TwitterActivity.start(mActivity));

        findViewById(R.id.bt_paint_canvas13).setOnClickListener((view) -> EraserActivity.start(mActivity));

        findViewById(R.id.bt_paint_canvas14).setOnClickListener((view) -> PorterDuffDstModeActivity.start(mActivity));

        findViewById(R.id.bt_paint_canvas15).setOnClickListener((view) -> RedPointActivity.start(mActivity));
    }
}
