package com.example.zhaogaofei.customerviewstudywithqihang.two_drawing.customer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.zhaogaofei.customerviewstudywithqihang.R;

public class ColorMatrixColorFilterView extends View {
    private Bitmap bitmap;
    private Bitmap btBitmap;
    private Bitmap starBitmap;

    public ColorMatrixColorFilterView(Context context) {
        super(context);
        init();
    }

    public ColorMatrixColorFilterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ColorMatrixColorFilterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.timo);
        btBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.button);
        starBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.star);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawDefaultBitmap(canvas);

        drawBitmapColorMatrix(canvas);

        drawButtonBitmap(canvas);

        drawBitmapLighting(canvas);

        drawBitmapBlue(canvas);

        drawBitmapPorterDuff(canvas);

        drawBitmapPorterDuffMode(canvas);

        drawBitmapWithTint(canvas);
    }

    private Paint getPaint() {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        return paint;
    }

    private void drawDefaultBitmap(Canvas canvas) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        canvas.drawBitmap(bitmap, null,
                new Rect(0, 0, 500, 500 * bitmap.getHeight() / bitmap.getWidth()),
                paint);
    }

    private void drawBitmapColorMatrix(Canvas canvas) {
        Paint paint = getPaint();
        canvas.translate(550, 0);

        ColorMatrix colorMatrix = new ColorMatrix(new float[]{
                1 / 2f, 1 / 2f, 1 / 2f, 0, 0,
                1 / 3f, 1 / 3f, 1 / 3f, 0, 0,
                1 / 4f, 1 / 4f, 1 / 4f, 0, 0,
                0, 0, 0, 1, 0
        });
        ColorMatrixColorFilter colorFilter = new ColorMatrixColorFilter(colorMatrix);
        paint.setColorFilter(colorFilter);
        canvas.drawBitmap(bitmap, null,
                new Rect(0, 0, 500, 500 * bitmap.getHeight() / bitmap.getWidth()),
                paint);
    }

    // 绘制原按钮
    private void drawButtonBitmap(Canvas canvas) {
        Paint paint = getPaint();
        canvas.translate(-550, 550);

        canvas.drawBitmap(btBitmap, null,
                new Rect(0, 0, 300, 300 * bitmap.getHeight() / bitmap.getWidth()),
                paint);
    }

    // 改变颜色为green
    private void drawBitmapLighting(Canvas canvas) {
        Paint paint = getPaint();
        canvas.translate(350, 0);

        paint.setColorFilter(new LightingColorFilter(0x00ff00, 0x000000));
        canvas.drawBitmap(btBitmap, null,
                new Rect(0, 0, 300, 300 * bitmap.getHeight() / bitmap.getWidth()),
                paint);
    }

    // 增加蓝色值
    private void drawBitmapBlue(Canvas canvas) {
        Paint paint = getPaint();
        canvas.translate(350, 0);

        paint.setColorFilter(new LightingColorFilter(0xffffff, 0x0000f0));
        canvas.drawBitmap(btBitmap, null,
                new Rect(0, 0, 300, 300 * bitmap.getHeight() / bitmap.getWidth()),
                paint);
    }

    private void drawBitmapPorterDuff(Canvas canvas) {
        Paint paint = getPaint();
        canvas.translate(-700, 350);

        paint.setColorFilter(new PorterDuffColorFilter(Color.RED, PorterDuff.Mode.MULTIPLY));
        canvas.drawBitmap(bitmap, null,
                new Rect(0, 0, 500, 500 * bitmap.getHeight() / bitmap.getWidth()),
                paint);
    }

    private void drawBitmapPorterDuffMode(Canvas canvas) {
        Paint paint = getPaint();

        int width = 500;
        int height = width * bitmap.getHeight() / bitmap.getWidth();

        canvas.translate(550, 0);
        paint.setColorFilter(new PorterDuffColorFilter(Color.RED, PorterDuff.Mode.ADD));//饱和度相加
        canvas.drawBitmap(bitmap, null, new Rect(0, 0, width, height), paint);

        canvas.translate(-550, 550);
        paint.setColorFilter(new PorterDuffColorFilter(Color.RED, PorterDuff.Mode.DARKEN));//变暗
        canvas.drawBitmap(bitmap, null, new Rect(0, 0, width, height), paint);

        canvas.translate(550, 0);
        paint.setColorFilter(new PorterDuffColorFilter(Color.RED, PorterDuff.Mode.LIGHTEN));//变亮
        canvas.drawBitmap(bitmap, null, new Rect(0, 0, width, height), paint);

        canvas.translate(-550, 550);
        paint.setColorFilter(new PorterDuffColorFilter(Color.RED, PorterDuff.Mode.MULTIPLY));//正片叠底
        canvas.drawBitmap(bitmap, null, new Rect(0, 0, width, height), paint);

        canvas.translate(550, 0);
        paint.setColorFilter(new PorterDuffColorFilter(Color.RED, PorterDuff.Mode.OVERLAY));//叠加
        canvas.drawBitmap(bitmap, null, new Rect(0, 0, width, height), paint);

        canvas.translate(-550, 550);
        paint.setColorFilter(new PorterDuffColorFilter(Color.RED, PorterDuff.Mode.SCREEN));//滤色
        canvas.drawBitmap(bitmap, null, new Rect(0, 0, width, height), paint);

    }

    private void drawBitmapWithTint(Canvas canvas) {
        Paint paint = getPaint();
        canvas.translate(0, 550);

        int width = 100;
        int height = width * starBitmap.getHeight() / starBitmap.getWidth();

        canvas.drawBitmap(starBitmap, null, new Rect(0, 0, width, height), paint);

        canvas.translate(150, 0);
        paint.setColorFilter(new PorterDuffColorFilter(0xffff00ff, PorterDuff.Mode.SRC));
        canvas.drawBitmap(starBitmap, null, new Rect(0, 0, width, height), paint);

        canvas.translate(150, 0);
        paint.setColorFilter(new PorterDuffColorFilter(0xff00f0ff, PorterDuff.Mode.SRC_ATOP));
        canvas.drawBitmap(starBitmap, null, new Rect(0, 0, width, height), paint);

        canvas.translate(150, 0);
        paint.setColorFilter(new PorterDuffColorFilter(0xfff0f0ff, PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(starBitmap, null, new Rect(0, 0, width, height), paint);

        canvas.translate(150, 0);
        paint.setColorFilter(new PorterDuffColorFilter(0xffffff00, PorterDuff.Mode.SRC_OVER));
        canvas.drawBitmap(starBitmap, null, new Rect(0, 0, width, height), paint);

        canvas.translate(150, 0);
        paint.setColorFilter(new PorterDuffColorFilter(0xff000000, PorterDuff.Mode.SRC_ATOP));
        canvas.drawBitmap(starBitmap, null, new Rect(0, 0, width, height), paint);

    }

}
