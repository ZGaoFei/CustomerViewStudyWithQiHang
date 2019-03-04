package com.example.zhaogaofei.customerviewstudywithqihang.two_drawing.customer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class PaintAndCanvasBezierView extends View implements View.OnTouchListener {

    private Paint paint;

    private Path leftPath;

    private Path rightPath;
    private int preX;
    private int preY;

    private boolean isLeft = true;

    public PaintAndCanvasBezierView(Context context) {
        super(context);
        init();
    }

    public PaintAndCanvasBezierView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PaintAndCanvasBezierView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.RED);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(5);

        leftPath = new Path();
        rightPath = new Path();

        setOnTouchListener(this);
    }

    public void setIsLeft(Boolean b) {
        this.isLeft = b;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvasQuadTo(canvas);
        canvasrQuadTo(canvas);

        if (isLeft) {
            canvasPath(canvas);
        } else {
            canvasRightPath(canvas);
        }
    }

    /**
     * 整条线的起始点是通过Path.moveTo(x,y)来指定的，如果初始没有调用Path.moveTo(x,y)来指定起始点，
     * 则默认以控件左上角(0,0)为起始点；
     * 而如果我们连续调用quadTo()，前一个quadTo()的终点，就是下一个quadTo()函数的起点；
     */
    private void canvasQuadTo(Canvas canvas) {
        Path path = new Path();
        path.moveTo(100, 200);
        path.quadTo(200, 100, 300, 200);
        path.quadTo(400, 300, 500, 200);

        canvas.drawPath(path, paint);
    }

    /**
     * 第一个rQuadTo的起点是建立在moveTo上的
     * 因此第一个rQuadTo得出的坐标点是
     * (100+100, 300-100)=(200, 200)：moveTo点的横竖坐标加上rQuadTo的起始点和结束点的对应值
     * (100+200, 300+0)=(300, 300)
     * 第二个rQuadTo的起始点是建立在第一个rQuadTo的结束点(300, 300)上的
     * 因此第二个rQuadTo的坐标点是
     * (300+100, 300+100)=(400, 400)
     * (300+200, 300+0)=(500， 300)
     *
     * rQuadTo()中的位移坐标，都是以上一个终点位置为基准来做偏移的！
     */
    private void canvasrQuadTo(Canvas canvas) {
        Path path = new Path();
        path.moveTo(100, 300);
        path.rQuadTo(100, -100, 200, 0);// (200, 200)/(300, 300)
        path.rQuadTo(100, 100, 200, 0);// (400, 400)/(500, 300)

        canvas.drawPath(path, paint);
    }

    private void canvasPath(Canvas canvas) {
        paint.setColor(Color.RED);
        canvas.drawPath(leftPath, paint);
    }

    private void canvasRightPath(Canvas canvas) {
        paint.setColor(Color.BLACK);
        canvas.drawPath(rightPath, paint);
    }

    public void reset() {
        if (isLeft) {
            leftPath.reset();
            invalidate();
        } else {
            rightPath.reset();
            invalidate();
        }
    }

    /**
     * postInvalidate()：请求刷新页面，可以在其他线程中调用，通过handle来发送消息通知主线程刷新页面
     * invalidate()：只能在主线程中调用
     */
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (isLeft) {
                    leftPath.moveTo(event.getX(), event.getY());
                } else {
                    rightPath.moveTo(event.getX(), event.getY());
                    preX = (int) event.getX();
                    preY = (int) event.getY();
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if (isLeft) {
                    leftPath.lineTo(event.getX(), event.getY());
                } else {
                    float endX = (preX + event.getX()) / 2;
                    float endY = (preY + event.getY()) / 2;
                    rightPath.quadTo(preX, preY, endX, endY);

                    preX = (int) event.getX();
                    preY = (int) event.getY();
                }
                postInvalidate();
                break;
        }
        return true;
    }

}
