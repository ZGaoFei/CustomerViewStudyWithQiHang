package com.example.zhaogaofei.customerviewstudywithqihang.two_drawing.customer;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposePathEffect;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.DiscretePathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.SumPathEffect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;

public class PaintAndCanvasOtherView extends View {
    private Paint paint;

    private int dx;

    public PaintAndCanvasOtherView(Context context) {
        super(context);
        init();
    }

    public PaintAndCanvasOtherView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PaintAndCanvasOtherView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.RED);
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.e("zgf", "paint and canvas other on draw");

        canvasStrokeCap(canvas);

        canvasStrokeJoin(canvas);

        canvasPathEffect(canvas);

        canvasPathEffectWithDash(canvas);

        canvasPathEffectWithDiscrete(canvas);

        canvasPathEffectWithPath(canvas);

        canvasPathEffectOther(canvas);
    }

    private void canvasStrokeCap(Canvas canvas) {
        paint.setStrokeWidth(80);

        paint.setColor(Color.RED);
        paint.setStrokeCap(Paint.Cap.BUTT);
        canvas.drawLine(100, 100, 300, 100, paint);

        paint.setColor(Color.RED);
        paint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawLine(100, 300, 300, 300, paint);

        paint.setColor(Color.RED);
        paint.setStrokeCap(Paint.Cap.SQUARE);
        canvas.drawLine(100, 500, 300, 500, paint);

        paint.reset();
        paint.setStrokeWidth(5);
        paint.setColor(Color.BLACK);
        paint.setAntiAlias(true);
        canvas.drawLine(100, 0, 100, 600, paint);
    }

    private void canvasStrokeJoin(Canvas canvas) {
        paint.setStrokeWidth(40);
        paint.setStyle(Paint.Style.STROKE);

        paint.setColor(Color.RED);
        paint.setStrokeJoin(Paint.Join.BEVEL);
        Path path = new Path();
        path.moveTo(100, 700);
        path.lineTo(300, 700);
        path.lineTo(100, 900);
        canvas.drawPath(path, paint);

        paint.setColor(Color.RED);
        paint.setStrokeJoin(Paint.Join.MITER);
        path.moveTo(400, 700);
        path.lineTo(600, 700);
        path.lineTo(400, 900);
        canvas.drawPath(path, paint);

        paint.setColor(Color.RED);
        paint.setStrokeJoin(Paint.Join.ROUND);
        path.moveTo(700, 700);
        path.lineTo(900, 700);
        path.lineTo(700, 900);
        canvas.drawPath(path, paint);
    }

    /**
     * 设置圆角折线
     */
    private void canvasPathEffect(Canvas canvas) {
        paint.setStrokeWidth(4);
        paint.setStyle(Paint.Style.STROKE);

        Path path = new Path();
        path.moveTo(100, 1200);
        path.lineTo(200, 1000);
        path.lineTo(250, 1300);

        paint.setColor(Color.RED);
        canvas.drawPath(path, paint);

        paint.setColor(Color.GREEN);
        paint.setPathEffect(new CornerPathEffect(100));
        canvas.drawPath(path, paint);

        paint.setColor(Color.BLACK);
        paint.setPathEffect(new CornerPathEffect(200));
        canvas.drawPath(path, paint);
    }

    private void canvasPathEffectWithDash(Canvas canvas) {
        paint.reset();
        paint.setStrokeWidth(4);
        paint.setStyle(Paint.Style.STROKE);

        Path path = new Path();
        path.moveTo(100, 1500);
        path.lineTo(200, 1300);
        path.lineTo(300, 1600);

        paint.setColor(Color.RED);
        canvas.drawPath(path, paint);

        paint.setColor(Color.GREEN);
        paint.setPathEffect(new DashPathEffect(new float[]{20, 10, 15, 15}, -dx));
        canvas.translate(0, 50);
        canvas.drawPath(path, paint);

        paint.setColor(Color.BLACK);
        paint.setPathEffect(new DashPathEffect(new float[]{20, 10, 15, 15}, dx));
        canvas.translate(0, 50);
        canvas.drawPath(path, paint);
    }

    public void startAnimation() {
        int lineLength = 20 + 10 + 15 + 15;
        ValueAnimator animator = ValueAnimator.ofInt(0, lineLength);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setInterpolator(new LinearInterpolator());
        animator.setDuration(2000);
        animator.addUpdateListener((animation -> {
            dx = (int) animation.getAnimatedValue();
            postInvalidate();
        }));
        animator.start();
    }

    private void canvasPathEffectWithDiscrete(Canvas canvas) {
        Path path = getPath(1700);
        paint.reset();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.RED);
        paint.setStrokeWidth(4);
        canvas.drawPath(path, paint);

        paint.setPathEffect(new DiscretePathEffect(2, 5));
        canvas.translate(0, 100);
        canvas.drawPath(path, paint);

        paint.setPathEffect(new DiscretePathEffect(5, 10));
        canvas.translate(0,100);
        canvas.drawPath(path, paint);

        paint.setPathEffect(new DiscretePathEffect(10, 10));
        canvas.translate(1, 100);
        canvas.drawPath(path, paint);
    }

    private Path getPath(int y) {
        Path path = new Path();
        // 定义路径的起点
        path.moveTo(0, y);

        // 定义路径的各个点
        for (int i = 0; i <= 40; i++) {
            path.lineTo(i * 35, (float) (Math.random() * 150) + y);
        }
        return path;
    }

    private void canvasPathEffectWithPath(Canvas canvas) {
        Path path = new Path();
        path.moveTo(100, 2100);
        path.lineTo(300, 1900);
        path.lineTo(500, 2100);

        paint.reset();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.RED);
        paint.setStrokeWidth(4);
        canvas.drawPath(path, paint);

        Path path1 = new Path();
        path1.moveTo(0, 20);
        path1.lineTo(10, 0);
        path1.lineTo(20, 20);
        path1.close();
        path1.addCircle(0, 0, 3, Path.Direction.CCW);

        paint.setColor(Color.GREEN);
        paint.setPathEffect(new PathDashPathEffect(path1, 35, dx, PathDashPathEffect.Style.ROTATE));
        canvas.translate(0, 100);
        canvas.drawPath(path, paint);

        paint.setColor(Color.BLUE);
        paint.setPathEffect(new PathDashPathEffect(path1, 35, -dx, PathDashPathEffect.Style.MORPH));
        canvas.translate(0,100);
        canvas.drawPath(path, paint);

        paint.setColor(Color.BLACK);
        paint.setPathEffect(new PathDashPathEffect(path1, 35, dx, PathDashPathEffect.Style.TRANSLATE));
        canvas.translate(0,100);
        canvas.drawPath(path, paint);
    }

    /**
     * ComposePathEffect合并两个特效是有先后顺序的，它会先将第二个参数的PathEffect innerpe的特效作用于路径上，
     * 然后再在此加了特效的路径上作用第二个特效。
     *
     * SumPathEffect是分别对原始路径分别作用第一个特效和第二个特效。然后再将这两条路径合并，做为最终结果。
     */
    private void canvasPathEffectOther(Canvas canvas) {
        Path path = getPath(2200);

        paint.reset();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.RED);
        paint.setStrokeWidth(4);
        canvas.drawPath(path, paint);

        CornerPathEffect cornerPathEffect = new CornerPathEffect(100);
        paint.setPathEffect(cornerPathEffect);
        canvas.translate(0, 100);
        canvas.drawPath(path, paint);

        DashPathEffect dashPathEffect = new DashPathEffect(new float[]{10, 5, 15, 10}, 0);
        paint.setPathEffect(dashPathEffect);
        canvas.translate(0, 100);
        canvas.drawPath(path, paint);

        //利用ComposePathEffect先应用圆角特效,再应用虚线特效
        paint.setPathEffect(new ComposePathEffect(dashPathEffect, cornerPathEffect));
        canvas.translate(0, 100);
        canvas.drawPath(path, paint);

        //利用SumPathEffect,分别将圆角特效应用于原始路径,然后将生成的两条特效路径合并
        paint.setPathEffect(new SumPathEffect(dashPathEffect, cornerPathEffect));
        canvas.translate(0, 100);
        canvas.drawPath(path, paint);
    }
}
