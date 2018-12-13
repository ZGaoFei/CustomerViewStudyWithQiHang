package com.example.zhaogaofei.customerviewstudywithqihang.two_drawing.customer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

public class PaintAndCanvasTestView extends View {
    private int width;
    private int height;

    private Paint paint;

    public PaintAndCanvasTestView(Context context) {
        super(context);
        init();
    }

    public PaintAndCanvasTestView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PaintAndCanvasTestView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.RED);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.width = w / 2;
        this.height = h / 2;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 画矩形
        drawRect1(canvas);
        drawRect2(canvas);

        // 画圆
        drawCircle1(canvas);
        drawCircle2(canvas);

        // 画线
        drawLine(canvas);
        drawLine1(canvas);

        // 画点
        drawPoint(canvas);

        // 画矩形
        drawRect(canvas);
        drawRectF(canvas);

        // 画圆角矩形
        drawRoundRect(canvas);

        // 画椭圆
        drawOval(canvas);

        // 画圆弧
        drawArc(canvas);

        // 画多条线
        drawLines(canvas);
    }

    private void drawRect1(Canvas canvas) {
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(0, 0, 100, 100, paint);
    }

    private void drawRect2(Canvas canvas) {
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawRect(120, 0, 120 + 100, 100, paint);
    }

    // y:100 + 20 + 100
    private void drawCircle1(Canvas canvas) {
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(10);
        canvas.drawCircle(100, 100 + 20 + 100, 100, paint);
    }

    private void drawCircle2(Canvas canvas) {
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);
        canvas.drawCircle(200 + 10 + 100, 100 + 20 + 100, 100, paint);
    }

    // y:100 + 20 + 100 + 100 + 20 = 340
    private void drawLine(Canvas canvas) {
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(10);
        canvas.drawLine(0, 340, 100, 340, paint);
    }

    // y:440 + 20 = 360
    private void drawLine1(Canvas canvas) {
        float[] pts = new float[] {
                0, 360,
                100, 360,
                150, 360,
                250, 360};

        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(10);
        canvas.drawLines(pts, paint);
    }

    // y:360 + 40 = 400
    private void drawPoint(Canvas canvas) {
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(20);
        canvas.drawPoint(0, 400, paint);

        paint.setStyle(Paint.Style.STROKE);
        canvas.drawPoint(50, 400, paint);

        float[] pts = new float[] {
                100, 400,
                150, 400,
                200, 400,
                250, 400};
        paint.setStyle(Paint.Style.FILL);
        canvas.drawPoints(pts, paint);

        float[] pts0 = new float[] {
                300, 400,
                350, 400,
                400, 400,
                450, 400};
        //offset：跳过几个数值，count：画几个数值
        // 一个点两个数值，offset=2,count=4：表示，跳过第一个点，画接下来的两个点，省略最后一个点，即只画了中间两个点
        canvas.drawPoints(pts0, 2, 4, paint);
        canvas.drawPoint(500, 400, paint);
    }

    // y: 400 + 40 = 440
    private void drawRect(Canvas canvas) {
        Rect rect = new Rect(0, 440, 100, 540);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(10);
        canvas.drawRect(rect, paint);

        Rect rect1 = new Rect(120, 440, 220, 540);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawRect(rect1, paint);
    }

    // y: 540 + 40 = 580
    private void drawRectF(Canvas canvas) {
        RectF rectF = new RectF(240, 440, 340, 540);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(10);
        canvas.drawRect(rectF, paint);

        RectF rectF1 = new RectF(360, 440, 460, 540);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawRect(rectF1, paint);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void drawRoundRect(Canvas canvas) {
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRoundRect(20, 580, 120, 680, 20, 20, paint);

        RectF rectF = new RectF(140, 580, 240, 680);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawRoundRect(rectF, 20, 20, paint);
    }

    // y: 680 + 40 = 720
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void drawOval(Canvas canvas) {
        paint.setStyle(Paint.Style.FILL);
        canvas.drawOval(20, 720, 120, 820, paint);

        RectF rectF = new RectF(140, 720, 340, 820);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawOval(rectF, paint);
    }

    // y: 820 + 40 = 860
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void drawArc(Canvas canvas) {
        paint.setStyle(Paint.Style.FILL);
        canvas.drawArc(20, 860, 120, 960, 10, 90, true, paint);

        RectF rectF = new RectF(140, 860, 340, 960);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawArc(rectF, 10, 90, true, paint);

        paint.setStyle(Paint.Style.FILL);
        canvas.drawArc(450, 860, 550, 960, 10, 90, false, paint);

        paint.setStyle(Paint.Style.STROKE);
        canvas.drawArc(580, 860, 680, 960, 10, 90, false, paint);
    }

    // y: 960 + 40 = 1000;
    private void drawLines(Canvas canvas) {
        float[] pts = new float[] {
                0, 1000, 100, 1000,
                150, 1000, 250, 1000,
                300, 1000, 450, 1000};

        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(10);
        canvas.drawLines(pts, 4, 8, paint);
    }
}
