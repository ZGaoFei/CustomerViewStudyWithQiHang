package com.example.zhaogaofei.customerviewstudywithqihang.two_drawing.customer;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.EmbossMaskFilter;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class BlurMaskFilterView extends View {
    private Paint paint;

    private BlurMaskFilter.Blur blur;

    public BlurMaskFilterView(Context context) {
        super(context);
        init();
    }

    public BlurMaskFilterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BlurMaskFilterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setLayerType(LAYER_TYPE_SOFTWARE,null);

        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(120);

        blur = BlurMaskFilter.Blur.NORMAL;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setMaskFilter(new BlurMaskFilter(50, blur));
        canvas.drawCircle(300, 300, 100, paint);

        paint.setMaskFilter(new EmbossMaskFilter(new float[]{10, 10, 10}, 0.5f, 1, 10));
        canvas.drawText("中华人民共和国", 100, 550, paint);
    }

    public void setBlurStyle(BlurMaskFilter.Blur blur) {
        this.blur = blur;
        postInvalidate();
    }
}
