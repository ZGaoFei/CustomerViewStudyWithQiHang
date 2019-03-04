package com.example.zhaogaofei.customerviewstudywithqihang.two_drawing.customer;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.LinearInterpolator;

public class WaveView extends View {
    private static final int WAVE_LENGTH = 400;

    private Paint paint;
    private Path path;

    private int dx;

    public WaveView(Context context) {
        super(context);
        init();
    }

    public WaveView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public WaveView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setStrokeWidth(5);

        path = new Path();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvasWave(canvas);
    }

    private void canvasWave(Canvas canvas) {
        path.reset();
        int originY = 300;
        int halfWaveLength = WAVE_LENGTH / 2;
        // 起始点
        path.moveTo(-WAVE_LENGTH + dx, originY);

        // 画波浪线
        for (int i = -WAVE_LENGTH; i < getWidth() + WAVE_LENGTH; i += WAVE_LENGTH) {
            path.rQuadTo(halfWaveLength / 2, -100, halfWaveLength, 0);
            path.rQuadTo(halfWaveLength / 2, 100, halfWaveLength, 0);
        }

        // 闭合路径
        path.lineTo(getWidth(), getHeight());
        path.lineTo(0, getHeight());
        path.close();

        canvas.drawPath(path, paint);
    }

    // 开始动画每次移动一个波长的距离
    public void startAnimation() {
        ValueAnimator animator = ValueAnimator.ofInt(0, WAVE_LENGTH);
        animator.setDuration(2000);
        animator.setInterpolator(new LinearInterpolator());
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.addUpdateListener(animation -> {
            dx = (int) animation.getAnimatedValue();
            postInvalidate();
        });
        animator.start();
    }


}
