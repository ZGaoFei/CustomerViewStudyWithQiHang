package com.example.zhaogaofei.customerviewstudywithqihang.two_drawing.customer;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;

public class FlashTextView extends AppCompatTextView {
    private Paint paint;

    private LinearGradient linearGradient;

    private int dx;

    public FlashTextView(Context context) {
        super(context);
        init();
    }

    public FlashTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public FlashTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = getPaint();

    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        startAnimation();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvasFlashText(canvas);
    }

    private void canvasFlashText(Canvas canvas) {
        linearGradient = new LinearGradient(
                -getMeasuredWidth(), 0,
                0, 0,
                new int[]{getCurrentTextColor(), 0xff00ff00, getCurrentTextColor()},
                new float[]{0, 0.5f, 1},
                Shader.TileMode.CLAMP);

        Matrix matrix = new Matrix();
        matrix.setTranslate(dx, 0);
        linearGradient.setLocalMatrix(matrix);
        paint.setShader(linearGradient);
        paint.setTextSize(50);

        canvas.drawText("月亮出来我爬山坡，爬到了山顶我想唱歌！", 0, 200, paint);
    }

    private void startAnimation() {
        ValueAnimator animator = ValueAnimator.ofInt(0, 2 * getMeasuredWidth());
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setRepeatMode(ValueAnimator.RESTART);
        animator.setDuration(1000);
        animator.setInterpolator(new LinearInterpolator());
        animator.addUpdateListener((animation -> {
            dx = (int) animation.getAnimatedValue();
            postInvalidate();
        }));
        animator.start();
    }
}
