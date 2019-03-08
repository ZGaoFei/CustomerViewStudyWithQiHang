package com.example.zhaogaofei.customerviewstudywithqihang.two_drawing.customer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.example.zhaogaofei.customerviewstudywithqihang.R;

public class PaintAndCanvasColorMatrix1View extends View {
    private Bitmap mBitmap;

    public PaintAndCanvasColorMatrix1View(Context context) {
        super(context);
        init();
    }

    public PaintAndCanvasColorMatrix1View(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PaintAndCanvasColorMatrix1View(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.timo);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.e("zgf", "paint and canvas color matrix view on draw");

        drawRect(canvas);

        drawBitmap(canvas);

        drawBitmap1(canvas);

        drawBitmap2(canvas);

        drawBitmap3(canvas);

        drawBitmap4(canvas);

        drawBitmap5(canvas);

        drawBitmap6(canvas);

        drawBitmap7(canvas);

        drawBitmap8(canvas);
    }

    private void drawRect(Canvas canvas) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setARGB(255, 200, 100, 100);
        canvas.drawRect(0, 0, 200, 300, paint);

        canvas.translate(300, 0);

        ColorMatrix colorMatrix = new ColorMatrix(new float[]{
                0, 0, 0, 0, 0,
                0, 0, 0, 0, 0,
                0, 0, 1, 0, 0,
                0, 0, 0, 1, 0,
        });

        paint.setARGB(255, 200, 100, 100);
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawRect(0, 0, 200, 300, paint);
    }

    // 设置为蓝色通道输出
    private void drawBitmap(Canvas canvas) {
        Paint paint = getPaint();

        canvas.translate(-300, 400);

        canvas.drawBitmap(mBitmap, null,
                new Rect(0, 0, 500, 500 * mBitmap.getHeight() / mBitmap.getWidth()),
                paint);

        canvas.translate(550, 0);

        ColorMatrix colorMatrix = new ColorMatrix(new float[]{
                0, 0, 0, 0, 0,
                0, 0, 0, 0, 0,
                0, 0, 1, 0, 0,
                0, 0, 0, 1, 0,
        });
        drawBitmap(mBitmap, canvas, paint, colorMatrix);
    }

    // 增加绿色饱和度
    private void drawBitmap1(Canvas canvas) {
        Paint paint = getPaint();

        canvas.translate(-550, 550);

        ColorMatrix colorMatrix = new ColorMatrix(new float[]{
                1, 0, 0, 0, 0,
                0, 1, 0, 0, 50,
                0, 0, 1, 0, 0,
                0, 0, 0, 1, 0,
        });
        drawBitmap(mBitmap, canvas, paint, colorMatrix);
    }

    // 色彩反转
    private void drawBitmap2(Canvas canvas) {
        Paint paint = getPaint();

        canvas.translate(550, 0);

        ColorMatrix colorMatrix = new ColorMatrix(new float[]{
                -1, 0, 0, 0, 255,
                0, -1, 0, 0, 255,
                0, 0, -1, 0, 255,
                0, 0, 0, 1, 0,
        });
        drawBitmap(mBitmap, canvas, paint, colorMatrix);
    }

    // 色彩的缩放运算
    private void drawBitmap3(Canvas canvas) {
        Paint paint = getPaint();

        canvas.translate(-550, 550);

        ColorMatrix colorMatrix = new ColorMatrix(new float[]{
                1.2f, 0, 0, 0, 0,
                0, 1.2f, 0, 0, 50,
                0, 0, 1.2f, 0, 0,
                0, 0, 0, 1.2f, 0,
        });

        drawBitmap(mBitmap, canvas, paint, colorMatrix);
    }

    // 红色通道输出
    private void drawBitmap4(Canvas canvas) {
        Paint paint = getPaint();

        canvas.translate(550, 0);

        ColorMatrix colorMatrix = new ColorMatrix(new float[]{
                1, 0, 0, 0, 0,
                0, 0, 0, 0, 0,
                0, 0, 0, 0, 0,
                0, 0, 0, 1, 0,
        });

        drawBitmap(mBitmap, canvas, paint, colorMatrix);
    }

    /**
     * 色彩投射，将图片变为黑白图片
     */
    private void drawBitmap5(Canvas canvas) {
        Paint paint = getPaint();

        canvas.translate(-550, 550);

        ColorMatrix colorMatrix = new ColorMatrix(new float[]{
                0.213f, 0.715f, 0.072f, 0, 0,
                0.213f, 0.715f, 0.072f, 0, 0,
                0.213f, 0.715f, 0.072f, 0, 0,
                0, 0, 0, 1, 0,
        });

        drawBitmap(mBitmap, canvas, paint, colorMatrix);
    }

    /**
     * 色彩反色
     * <p>
     * 红绿反色，将红色变成绿色
     */
    private void drawBitmap6(Canvas canvas) {
        Paint paint = getPaint();

        canvas.translate(550, 0);

        ColorMatrix colorMatrix = new ColorMatrix(new float[]{
                0, 1, 0, 0, 0,
                1, 0, 0, 0, 0,
                0, 0, 1, 0, 0,
                0, 0, 0, 1, 0,
        });

        drawBitmap(mBitmap, canvas, paint, colorMatrix);
    }

    /**
     * 变旧照片
     */
    private void drawBitmap7(Canvas canvas) {
        Paint paint = getPaint();

        canvas.translate(-550, 550);

        ColorMatrix colorMatrix = new ColorMatrix(new float[]{
                1 / 2f, 1 / 2f, 1 / 2f, 0, 0,
                1 / 3f, 1 / 3f, 1 / 3f, 0, 0,
                1 / 4f, 1 / 4f, 1 / 4f, 0, 0,
                0, 0, 0, 1, 0,
        });

        drawBitmap(mBitmap, canvas, paint, colorMatrix);
    }

    /**
     * 测试colorMatrix.setScale()方法
     * setScale(float rScale, float gScale, float bScale, float aScale)
     * 四个参数分别对应RGBA四个的倍数
     */
    private void drawBitmap8(Canvas canvas) {
        Paint paint = getPaint();

        canvas.translate(550, 0);

        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setScale(1, 1.3f, 1, 1);

        drawBitmap(mBitmap, canvas, paint, colorMatrix);
    }

    private Paint getPaint() {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        return paint;
    }

    private void drawBitmap(Bitmap bitmap, Canvas canvas, Paint paint, ColorMatrix colorMatrix) {
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap, null,
                new Rect(0, 0, 500, 500 * bitmap.getHeight() / bitmap.getWidth()),
                paint);
    }
}
