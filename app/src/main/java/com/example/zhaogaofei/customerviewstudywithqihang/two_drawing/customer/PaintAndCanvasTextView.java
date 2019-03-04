package com.example.zhaogaofei.customerviewstudywithqihang.two_drawing.customer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class PaintAndCanvasTextView extends View {
    private Paint mPaint;

    public PaintAndCanvasTextView(Context context) {
        super(context);
        init();
    }

    public PaintAndCanvasTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PaintAndCanvasTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        drawTextWithLine(canvas);
    }

    /**
     * 1、drawText是中的参数y是基线的位置
     * 2、一定要清楚的是，只要x坐标、基线位置、文字大小确定以后，文字的位置就是确定的了
     */
    private void drawTextWithLine(Canvas canvas) {
        int baseLineX = 200;
        int baseLineY = 200;
        mPaint.setColor(Color.RED);
        canvas.drawLine(baseLineX, baseLineY, 1080, baseLineY, mPaint);

        mPaint.setColor(Color.GREEN);
        mPaint.setTextSize(120);
        mPaint.setTextAlign(Paint.Align.LEFT);
        // mPaint.setTextAlign(Paint.Align.CENTER);
        // mPaint.setTextAlign(Paint.Align.RIGHT);
        canvas.drawText("Your are good!j", baseLineX, baseLineY, mPaint);
    }

}
