package com.example.zhaogaofei.customerviewstudywithqihang.two_drawing.customer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.RegionIterator;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class PaintAndCanvas3View extends View {
    private Paint mPaint;
    private Paint mOpPaint;

    public PaintAndCanvas3View(Context context) {
        super(context);
        init();
    }

    public PaintAndCanvas3View(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PaintAndCanvas3View(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);

        mOpPaint = new Paint();
        mOpPaint.setColor(Color.GREEN);
        mOpPaint.setAntiAlias(true);
        mOpPaint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 画区域
        drawRegion(canvas);

        // 画path
        drawPath(canvas);

        // 画椭圆和矩形
        drawOval(canvas);

        drawOpIntersect(canvas);
        drawOpDifference(canvas);
        drawOpUnion(canvas);
        drawOpXor(canvas);
        drawOpReverseDifference(canvas);
        drawOpReplace(canvas);
    }

    private void drawRegion(Canvas canvas) {
        Region region = new Region(10, 10, 110, 110);
        // 将构造函数里面的值覆盖掉
        region.set(50, 50, 150, 150);

        mPaint.setStyle(Paint.Style.FILL);
        drawRegion(region, canvas, mPaint);
    }

    private void drawPath(Canvas canvas) {
        Path path = new Path();
        RectF rectF = new RectF(200, 20, 300, 220);
        path.addOval(rectF, Path.Direction.CCW);

        Region region = new Region(200, 20, 300, 120);
        region.setPath(path, region);

        mPaint.setStyle(Paint.Style.FILL);
        drawRegion(region, canvas, mPaint);
    }

    private void drawOval(Canvas canvas) {
        Path path = new Path();
        RectF rectF = new RectF(350, 20, 450, 220);
        path.addOval(rectF, Path.Direction.CCW);

        Region region = new Region(350, 20, 450, 220);
        region.setPath(path, region);

        mPaint.setStyle(Paint.Style.STROKE);
        drawRegion(region, canvas, mPaint);
    }

    // 区域的合并、交叉等操作
    private void drawOpIntersect(Canvas canvas) {
        mPaint.setStyle(Paint.Style.STROKE);
        Rect rect1 = new Rect(20, 360, 320, 460);
        Rect rect2 = new Rect(120, 260, 220, 560);

        canvas.drawRect(rect1, mPaint);
        canvas.drawRect(rect2, mPaint);

        Region region1 = new Region(rect1);
        Region region2 = new Region(rect2);

        region1.op(region2, Region.Op.INTERSECT);

        drawRegion(region1, canvas, mOpPaint);
    }

    private void drawOpDifference(Canvas canvas) {
        mPaint.setStyle(Paint.Style.STROKE);
        Rect rect1 = new Rect(420, 360, 720, 460);
        Rect rect2 = new Rect(520, 260, 620, 560);

        canvas.drawRect(rect1, mPaint);
        canvas.drawRect(rect2, mPaint);

        Region region1 = new Region(rect1);
        Region region2 = new Region(rect2);

        region1.op(region2, Region.Op.DIFFERENCE);

        drawRegion(region1, canvas, mOpPaint);
    }

    private void drawOpUnion(Canvas canvas) {
        mPaint.setStyle(Paint.Style.STROKE);
        Rect rect1 = new Rect(20, 760, 320, 860);
        Rect rect2 = new Rect(120, 660, 220, 960);

        canvas.drawRect(rect1, mPaint);
        canvas.drawRect(rect2, mPaint);

        Region region1 = new Region(rect1);
        Region region2 = new Region(rect2);

        region1.op(region2, Region.Op.UNION);

        drawRegion(region1, canvas, mOpPaint);
    }

    private void drawOpXor(Canvas canvas) {
        mPaint.setStyle(Paint.Style.STROKE);
        Rect rect1 = new Rect(420, 760, 720, 860);
        Rect rect2 = new Rect(520, 660, 620, 960);

        canvas.drawRect(rect1, mPaint);
        canvas.drawRect(rect2, mPaint);

        Region region1 = new Region(rect1);
        Region region2 = new Region(rect2);

        region1.op(region2, Region.Op.XOR);

        drawRegion(region1, canvas, mOpPaint);
    }

    private void drawOpReverseDifference(Canvas canvas) {
        mPaint.setStyle(Paint.Style.STROKE);
        Rect rect1 = new Rect(20, 1160, 320, 1260);
        Rect rect2 = new Rect(120, 1060, 220, 1360);

        canvas.drawRect(rect1, mPaint);
        canvas.drawRect(rect2, mPaint);

        Region region1 = new Region(rect1);
        Region region2 = new Region(rect2);

        region1.op(region2, Region.Op.REVERSE_DIFFERENCE);

        drawRegion(region1, canvas, mOpPaint);
    }

    private void drawOpReplace(Canvas canvas) {
        mPaint.setStyle(Paint.Style.STROKE);
        Rect rect1 = new Rect(420, 1160, 720, 1260);
        Rect rect2 = new Rect(520, 1060, 620, 1360);

        canvas.drawRect(rect1, mPaint);
        canvas.drawRect(rect2, mPaint);

        Region region1 = new Region(rect1);
        Region region2 = new Region(rect2);

        region1.op(region2, Region.Op.REPLACE);

        drawRegion(region1, canvas, mOpPaint);
    }

    private void drawRegion(Region region, Canvas canvas, Paint paint) {
        RegionIterator iterator = new RegionIterator(region);
        Rect rect = new Rect();
        while (iterator.next(rect)) {
            canvas.drawRect(rect, paint);
        }
    }

}
