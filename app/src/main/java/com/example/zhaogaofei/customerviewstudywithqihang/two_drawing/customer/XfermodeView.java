package com.example.zhaogaofei.customerviewstudywithqihang.two_drawing.customer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;


public class XfermodeView extends View {
    private int width = 200;
    private int height = 200;

    private Bitmap dstBitmap;
    private Bitmap srcBitmap;

    private Paint paint;

    public XfermodeView(Context context) {
        super(context);
        init();
    }

    public XfermodeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public XfermodeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        // setLayerType(LAYER_TYPE_SOFTWARE, null);

        dstBitmap = makeDst();
        srcBitmap = makeSrc();

        paint = getPaint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        drawBitmapClear(canvas);

        drawBitmapSrc(canvas);

        drawBitmapDst(canvas);

        drawBitmapSrcOver(canvas);

        drawBitmapDstOver(canvas);

        drawBitmapSrcIn(canvas);

        drawBitmapDstIn(canvas);

        drawBitmapSrcOut(canvas);

        drawBitmapDstOut(canvas);

        drawBitmapSrcATop(canvas);

        drawBitmapDstATop(canvas);

        drawBitmapXor(canvas);

        drawBitmapDarken(canvas);

        drawBitmapLighten(canvas);

        drawBitmapMultiply(canvas);

        drawBitmapScreen(canvas);
    }

    private Paint getPaint() {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        return paint;
    }

    private Bitmap makeDst() {
        Bitmap dst = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(dst);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(0xFFFFCC44);
        canvas.drawOval(new RectF(0, 0, width, height), paint);
        return dst;
    }

    private Bitmap makeSrc() {
        Bitmap src = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(src);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(0xFF66AAFF);
        canvas.drawRect(new RectF(0, 0, width, height), paint);
        return src;
    }

    private void drawBitmap(Canvas canvas, PorterDuff.Mode mode, int left, int top, int right, int bottom) {
        int layer = canvas.saveLayer(left, top, right + width * 2, bottom + height * 2, paint, Canvas.ALL_SAVE_FLAG);
        canvas.drawBitmap(dstBitmap, left, top, paint);
        paint.setXfermode(new PorterDuffXfermode(mode));
        canvas.drawBitmap(srcBitmap, left + width / 2, top + height / 2, paint);
        paint.setXfermode(null);
        canvas.restoreToCount(layer);
    }

    private void drawBitmapClear(Canvas canvas) {
        drawBitmap(canvas, PorterDuff.Mode.CLEAR, 0, 0, 0, 0);
    }

    private void drawBitmapSrc(Canvas canvas) {
        drawBitmap(canvas, PorterDuff.Mode.SRC, 450, 0, 0, 0);
    }

    private void drawBitmapDst(Canvas canvas) {
        drawBitmap(canvas, PorterDuff.Mode.DST, 0, 450, 0, 450);
    }

    private void drawBitmapSrcOver(Canvas canvas) {
        drawBitmap(canvas, PorterDuff.Mode.SRC_OVER, 450, 450, 450, 450);
    }

    private void drawBitmapDstOver(Canvas canvas) {
        drawBitmap(canvas, PorterDuff.Mode.DST_OVER, 0, 850, 0, 850);
    }

    private void drawBitmapSrcIn(Canvas canvas) {
        drawBitmap(canvas, PorterDuff.Mode.SRC_IN, 450, 850, 450, 850);
    }

    private void drawBitmapDstIn(Canvas canvas) {
        drawBitmap(canvas, PorterDuff.Mode.DST_IN, 0, 1250, 0, 1250);
    }

    private void drawBitmapSrcOut(Canvas canvas) {
        drawBitmap(canvas, PorterDuff.Mode.SRC_OUT, 450, 1250, 450, 1250);
    }

    private void drawBitmapDstOut(Canvas canvas) {
        drawBitmap(canvas, PorterDuff.Mode.DST_OUT, 0, 1650, 0, 1650);
    }

    private void drawBitmapSrcATop(Canvas canvas) {
        drawBitmap(canvas, PorterDuff.Mode.SRC_ATOP, 450, 1650, 450, 1650);
    }

    private void drawBitmapDstATop(Canvas canvas) {
        drawBitmap(canvas, PorterDuff.Mode.DST_ATOP, 0, 2050, 0, 2050);
    }

    private void drawBitmapXor(Canvas canvas) {
        drawBitmap(canvas, PorterDuff.Mode.XOR, 450, 2050, 450, 2050);
    }

    private void drawBitmapDarken(Canvas canvas) {
        drawBitmap(canvas, PorterDuff.Mode.DARKEN, 0, 2450, 0, 2450);
    }

    private void drawBitmapLighten(Canvas canvas) {
        drawBitmap(canvas, PorterDuff.Mode.LIGHTEN, 450, 2450, 450, 2450);
    }

    private void drawBitmapMultiply(Canvas canvas) {
        drawBitmap(canvas, PorterDuff.Mode.MULTIPLY, 0, 2850, 0, 2850);
    }

    private void drawBitmapScreen(Canvas canvas) {
        drawBitmap(canvas, PorterDuff.Mode.SCREEN, 450, 2850, 450, 2850);
    }

}
