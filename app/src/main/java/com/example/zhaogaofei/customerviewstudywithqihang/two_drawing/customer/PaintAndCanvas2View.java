package com.example.zhaogaofei.customerviewstudywithqihang.two_drawing.customer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class PaintAndCanvas2View extends View {

    private Paint paint;

    public PaintAndCanvas2View(Context context) {
        this(context, null);
    }

    public PaintAndCanvas2View(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PaintAndCanvas2View(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStrokeWidth(10);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        drawPath(canvas);

        drawRectWithPath(canvas);

        drawText(canvas);

        drawRoundRectWithPath(canvas);

        drawText1(canvas);

        drawText2(canvas);

        drawText3(canvas);

        drawText4(canvas);

        drawText5(canvas);
    }

    private void drawPath(Canvas canvas) {
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.RED);

        Path path = new Path();
        path.moveTo(20, 20);
        path.lineTo(120, 20);
        path.lineTo(120, 120);
        path.lineTo(20, 120);
        path.close();

        canvas.drawPath(path, paint);
    }

    private void drawRectWithPath(Canvas canvas) {
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.RED);

        Path path = new Path();
        path.addRect(140, 20, 240, 220, Path.Direction.CCW);
        canvas.drawPath(path, paint);

        Path path1 = new Path();
        path1.addRect(new RectF(260, 20, 360, 220), Path.Direction.CW);
        canvas.drawPath(path1, paint);

        /**
         * 同canvas内部的方法使用一样
         *
         * Path path2 = new Path();
         * path2.addArc();
         * path2.addCircle();
         * path2.addOval();
         * path2.addRoundRect();// 其一除外
         * path2.addRect();
         */
    }

    // 区分正序和倒叙
    private void drawText(Canvas canvas) {
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.RED);

        Path pathCw = new Path();
        pathCw.addRect(new RectF(20, 260, 320, 560), Path.Direction.CW);
        canvas.drawPath(pathCw, paint);

        Path pathCcw = new Path();
        pathCcw.addRect(new RectF(420, 260, 720, 560), Path.Direction.CCW);
        canvas.drawPath(pathCcw, paint);

        String string = "你是我的小呀小苹果，怎么爱你都不嫌多！";
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(5);
        paint.setTextSize(35);
        canvas.drawTextOnPath(string, pathCw, 0, 0, paint);
        canvas.drawTextOnPath(string, pathCcw, 20, 40, paint);
    }

    /**
     * addRoundRect(RectF rect, float[] radii, Direction dir)
     * addRoundRect(float left, float top, float right, float bottom, float[] radii, Direction dir)
     */
    private void drawRoundRectWithPath(Canvas canvas) {
        float[] radii = new float[] {15, 20, 25, 30, 30, 60, 90, 20};
        Path path = new Path();
        path.addRoundRect(new RectF(760, 260, 1060, 560), radii, Path.Direction.CW);

        paint.setStrokeWidth(10);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawPath(path, paint);
    }

    // y: 700
    private void drawText1(Canvas canvas) {
        paint.setColor(Color.BLUE);
        paint.setTextSize(100);
        paint.setStrokeWidth(5);

        String string1 = "你是我的小呀小苹果，怎么爱你都不嫌多！";

        paint.setStyle(Paint.Style.FILL);
        canvas.drawText(string1, 0, string1.length(), 20, 700, paint);

        paint.setStyle(Paint.Style.STROKE);
        canvas.drawText(string1, 0, string1.length(), 20, 800, paint);

        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawText(string1, 0, string1.length(), 20, 900, paint);
    }

    // y:1000
    private void drawText2(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setTextSize(50);
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.FILL);
        paint.setFakeBoldText(true);
        paint.setUnderlineText(true);
        paint.setStrikeThruText(true);

        String string1 = "你是我的小呀小苹果，怎么爱你都不嫌多！";

        paint.setTextSkewX(-0.25f);
        canvas.drawText(string1, 20, 1000, paint);

        paint.setTextSkewX(0.25f);
        canvas.drawText(string1, 20, 1100, paint);
    }

    // y:1200
    private void drawText3(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setTextSize(70);
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.FILL);

        String string1 = "你是我的小呀小苹果，怎么爱你都不嫌多！";

        canvas.drawText(string1, 20, 1200, paint);

        paint.setColor(Color.BLUE);
        paint.setTextScaleX(2);
        canvas.drawText(string1, 20, 1200, paint);
    }

    // y:1300
    private void drawText4(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setTextSize(70);
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.FILL);

        String string1 = "小苹果";

        canvas.drawPosText(string1, new float[]{20, 1300, 20, 1400, 20, 1500}, paint);

        char[] chars = new char[]{'A', 'B', 'C', 'D', 'E'};
        canvas.drawPosText(chars, 1, 3, new float[]{120, 1300, 120, 1400, 120, 1500}, paint);
    }

    private void drawText5(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setTextSize(70);
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.STROKE);

        String string = "小苹果";
        String stringType = "宋体";

        paint.setTypeface(Typeface.create(stringType, Typeface.NORMAL));

        canvas.drawText(string, 220, 1300, paint);
    }
}
