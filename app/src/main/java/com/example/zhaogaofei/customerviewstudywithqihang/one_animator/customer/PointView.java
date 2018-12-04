package com.example.zhaogaofei.customerviewstudywithqihang.one_animator.customer;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;

public class PointView extends View {
    private Point point;

    private Paint paint;

    private int screenWidth;
    private int screenHeight;

    public PointView(Context context) {
        super(context);
        init();
    }

    public PointView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PointView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        point = new Point(10);

        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);

        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startDrawAnimator();
            }
        });
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        screenWidth = w;
        screenHeight = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (point != null) {
            int radius = point.getRadius();
            canvas.drawCircle(screenWidth / 2, screenHeight / 2, radius, paint);
        }
    }

    public void startDrawAnimator() {
        ValueAnimator valueAnimator = ValueAnimator.ofObject(new PointEvaluator(), new Point(10), new Point(100));
        valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        valueAnimator.setDuration(3000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                point = (Point) animation.getAnimatedValue();
                invalidate(); // 会触发onDraw()方法
            }
        });
        valueAnimator.start();
    }
    // requestLayout()：会触发onMeasure()和onLayout()方法

    public void setRadius(int radius) {
        point.setRadius(radius);

        invalidate();
    }
}
