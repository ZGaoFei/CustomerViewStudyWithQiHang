package com.example.zhaogaofei.customerviewstudywithqihang.two_drawing.customer;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

import com.example.zhaogaofei.customerviewstudywithqihang.R;

public class TextWaveView extends View {
    private Paint paint;

    private Bitmap bitmap;
    private Bitmap dstBitmap;

    private Path path;

    private int itemWaveLength = 1000;
    private int dx;

    public TextWaveView(Context context) {
        super(context);
        init();
    }

    public TextWaveView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TextWaveView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);

        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.text_shade);
        dstBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);

        path = new Path();

        startAnimation();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        generateWavePath();

        Canvas c = new Canvas(dstBitmap);
        c.drawColor(Color.BLACK, PorterDuff.Mode.CLEAR);
        c.drawPath(path, paint);

        // 先画上原图，避免出现文字显示不全的问题
        canvas.drawBitmap(bitmap, 0, 0, paint);

        int layer = canvas.saveLayer(0, 0, bitmap.getWidth(), bitmap.getHeight(), null, Canvas.ALL_SAVE_FLAG);
        canvas.drawBitmap(dstBitmap, 0, 0, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        canvas.drawBitmap(bitmap, 0, 0, paint);

        paint.setXfermode(null);
        canvas.restoreToCount(layer);
    }

    /**
     * 设置path路径
     * path路径四个点的坐标为：
     *（-itemWaveLength + dx, originY）
     *（getWidth() + itemWaveLength， originY）
     * (bitmap.getWidth(), bitmap.getHeight())
     * (0, bitmap.getHeight())
     *
     * path.rQuadTo()是二阶贝赛尔曲线，开始坐标为前一个点的终点
     */
    private void generateWavePath() {
        path.reset();

        int originY = bitmap.getHeight() / 2;
        int halfWave = itemWaveLength / 2;
        path.moveTo(-itemWaveLength + dx, originY);
        for (int i = -itemWaveLength; i < getWidth() + itemWaveLength; i += itemWaveLength) {
            path.rQuadTo(halfWave / 2, -50, halfWave, 0);
            path.rQuadTo(halfWave / 2, 50, halfWave, 0);
        }
        path.lineTo(bitmap.getWidth(), bitmap.getHeight());
        path.lineTo(0, bitmap.getHeight());
        path.close();
    }

    private void startAnimation() {
        ValueAnimator animator = ValueAnimator.ofInt(0, itemWaveLength);
        animator.setDuration(2000);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setInterpolator(new LinearInterpolator());

        animator.addUpdateListener((animation -> {
            dx = (int) animation.getAnimatedValue();
            postInvalidate();
        }));

        animator.start();
    }
}
