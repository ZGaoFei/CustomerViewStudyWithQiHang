package com.example.zhaogaofei.customerviewstudywithqihang.two_drawing.customer;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

import com.example.zhaogaofei.customerviewstudywithqihang.R;

public class BlueWaveView extends View {
    private Paint paint;

    private Bitmap dstBitmap;
    private Bitmap srcBitmap;

    private int dx;
    private int itemWaveLength;

    public BlueWaveView(Context context) {
        super(context);
        init();
    }

    public BlueWaveView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BlueWaveView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setAntiAlias(true);

        dstBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.wave_bg);
        srcBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.circle_shape);

        itemWaveLength = dstBitmap.getWidth();

        startAnimation();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawBitmap(srcBitmap, 0, 0, paint);

        int layer = canvas.saveLayer(0, 0, getWidth(), getHeight(), null, Canvas.ALL_SAVE_FLAG);
        canvas.drawBitmap(dstBitmap,
                new Rect(dx, 0, dx + srcBitmap.getWidth(), srcBitmap.getHeight()),
                new Rect(0, 0, srcBitmap.getWidth(), srcBitmap.getHeight()),
                paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        canvas.drawBitmap(srcBitmap, 0, 0, paint);

        paint.setXfermode(null);
        canvas.restoreToCount(layer);
    }

    private void startAnimation() {
        ValueAnimator animator = ValueAnimator.ofInt(0, itemWaveLength);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setDuration(6000);
        animator.setInterpolator(new LinearInterpolator());
        animator.addUpdateListener((animation -> {
            dx = (int) animation.getAnimatedValue();
            postInvalidate();
        }));
        animator.start();
    }
}
