package com.example.zhaogaofei.customerviewstudywithqihang.two_drawing.customer;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

import com.example.zhaogaofei.customerviewstudywithqihang.R;

public class HeartMapView extends View {
    private Paint paint;

    private Bitmap dstBitmap;
    private Bitmap srcBitmap;

    private int itemWaveLength;
    private int dx;

    public HeartMapView(Context context) {
        super(context);
        init();
    }

    public HeartMapView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public HeartMapView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.RED);

        dstBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.heartmap);
        srcBitmap = Bitmap.createBitmap(dstBitmap.getWidth(), dstBitmap.getHeight(), Bitmap.Config.ARGB_8888);

        itemWaveLength = dstBitmap.getWidth();

        startAnimation();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Canvas c = new Canvas(srcBitmap);
        c.drawColor(Color.BLACK, PorterDuff.Mode.CLEAR);
        c.drawRect(dstBitmap.getWidth() - dx, 0, dstBitmap.getWidth(), dstBitmap.getHeight(), paint);

        int layer = canvas.saveLayer(0, 0, getWidth(), getHeight(), null, Canvas.ALL_SAVE_FLAG);
        canvas.drawBitmap(dstBitmap, 0, 0, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        canvas.drawBitmap(srcBitmap, 0, 0, paint);

        paint.setXfermode(null);
        canvas.restoreToCount(layer);
    }

    private void startAnimation() {
        ValueAnimator animator = ValueAnimator.ofInt(0, itemWaveLength);
        animator.setInterpolator(new LinearInterpolator());
        animator.setDuration(6000);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.addUpdateListener((animation -> {
            dx = (int) animation.getAnimatedValue();
            postInvalidate();
        }));
        animator.start();
    }
}
