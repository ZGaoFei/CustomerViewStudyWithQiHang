package com.example.zhaogaofei.customerviewstudywithqihang.two_drawing.customer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class PaintAndCanvas4View extends View {

    private Paint paint;
    private Paint greenPaint;

    public PaintAndCanvas4View(Context context) {
        super(context);
        init();
    }

    public PaintAndCanvas4View(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PaintAndCanvas4View(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setColor(Color.RED);
        paint.setStrokeWidth(5);

        greenPaint = new Paint();
        greenPaint.setStyle(Paint.Style.STROKE);
        greenPaint.setAntiAlias(true);
        greenPaint.setColor(Color.GREEN);
        greenPaint.setStrokeWidth(5);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // canvasTranslate(canvas);

        // canvasAfterTranslate(canvas);

        // canvasRotate(canvas);

        // canvasScale(canvas);

        // canvasSkew(canvas);

        // canvasClip(canvas);

        canvasSaveOrRestore(canvas);
    }

    private void canvasTranslate(Canvas canvas) {
        Rect rect = new Rect(10, 10, 110, 110);

        canvas.translate(100, 100);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(rect, paint);
    }

    /**
     * drawRect()以后，进行translate操作
     * 两个矩形没有重合
     *
     * 1、每次调用canvas.drawXXXX系列函数来绘图时，都会产生一个全新的Canvas画布。
     * 2、如果在DrawXXX前，调用平移、旋转等函数来对Canvas进行了操作，那么这个操作是不可逆的！
     * 每次产生的画布的最新位置都是这些操作后的位置。（关于Save()、Restore()的画布可逆问题的后面再讲）
     * 3、在Canvas与屏幕合成时，超出屏幕范围的图像是不会显示出来的。
     */
    private void canvasAfterTranslate(Canvas canvas) {
        Rect rect = new Rect(10, 220, 110, 320);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawRect(rect, paint);

        canvas.translate(100, 100);
        canvas.drawRect(rect, greenPaint);
    }

    /**
     * 执行完rotate方法后，后面在调用draw***()方法时，
     * 绘制的内容都是rotate角度之后的
     */
    private void canvasRotate(Canvas canvas) {
        Rect rect = new Rect(200, 500, 310, 600);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawRect(rect, paint);

        // 这里相当于把canvas旋转了30度
        canvas.rotate(30, 200, 500);
        greenPaint.setStyle(Paint.Style.FILL);
        greenPaint.setColor(Color.GREEN);
        canvas.drawRect(rect, greenPaint);

        // 这里相当于把canvas在前面的基础上又旋转了30度
        canvas.rotate(30, 200, 500);
        greenPaint.setColor(Color.RED);
        greenPaint.setStyle(Paint.Style.FILL);
        canvas.drawRect(rect, greenPaint);
    }

    /**
     * canvas.scale(sx, sy)：在原点的位置进行宽高比缩放
     * canvas.scale(sx, sy, px, py)：从某个坐标点的位置进行宽高比缩放
     * sx、sy表示缩放比例，大于0表示放大，小于0表示缩小
     * px、py表示x轴和y轴坐标点
     */
    private void canvasScale(Canvas canvas) {
        Rect rect = new Rect(10, 700, 210, 900);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawRect(rect, paint);

        // canvas.scale(0.5f, 0.5f);
        canvas.scale(0.5f, 0.5f, 10, 700);
        greenPaint.setColor(Color.GREEN);
        greenPaint.setStyle(Paint.Style.STROKE);
        canvas.drawRect(rect, greenPaint);
    }

    /**
     * canvas.skew(sx, sy)：斜切或者叫扭曲
     * sx、sy：在x轴或者y轴上倾斜相应的角度
     * 角度为tan值，比如tan60 = 跟号3 约为1.732
     */
    private void canvasSkew(Canvas canvas) {
        Rect rect = new Rect(300, 10, 600, 110);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawRect(rect, paint);

        canvas.skew(1.732f, 0);
        greenPaint.setColor(Color.GREEN);
        greenPaint.setStyle(Paint.Style.STROKE);
        canvas.drawRect(rect, greenPaint);
    }

    /**
     * boolean	clipPath(Path path)
     * boolean	clipPath(Path path, Region.Op op)
     * boolean	clipRect(Rect rect, Region.Op op)
     * boolean	clipRect(RectF rect, Region.Op op)
     * boolean	clipRect(int left, int top, int right, int bottom)
     * boolean	clipRect(float left, float top, float right, float bottom)
     * boolean	clipRect(RectF rect)
     * boolean	clipRect(float left, float top, float right, float bottom, Region.Op op)
     * boolean	clipRect(Rect rect)
     * boolean	clipRegion(Region region)
     * boolean	clipRegion(Region region, Region.Op op)
     *
     * 根据path或者rect或者region来clip一部分canvas
     * op为区域的合并、交叉等操作
     */
    private void canvasClip(Canvas canvas) {
        canvas.drawColor(Color.BLUE);

        canvas.clipRect(new Rect(100, 100, 200, 200));

        canvas.drawColor(Color.RED);
    }

    /**
     * canvas.save()：都会把当前的画布的状态进行保存，然后放入特定的栈中
     * canvas.restore()：把栈中最顶层的画布状态取出来，并按照这个状态恢复当前的画布，并在这个画布上做画
     */
    private void canvasSaveOrRestore(Canvas canvas) {
        canvas.drawColor(Color.RED);
        canvas.save();

        canvas.clipRect(new Rect(100, 100, 600, 600));
        canvas.drawColor(Color.BLUE);
        canvas.save();

        canvas.clipRect(new Rect(150, 150, 550, 550));
        canvas.drawColor(Color.BLACK);
        canvas.save();

        canvas.clipRect(new Rect(200, 200, 500, 500));
        canvas.drawColor(Color.GREEN);
        canvas.save();

        canvas.clipRect(new Rect(250, 250, 450, 450));
        canvas.drawColor(Color.GRAY);
        canvas.save();

        canvas.clipRect(new Rect(300, 300, 400, 400));
        canvas.drawColor(Color.YELLOW);

        canvas.restore();
        canvas.restore();
        // canvas.restore();
        // canvas.restore();
        // canvas.restore();
        canvas.drawColor(Color.DKGRAY);

    }
}
