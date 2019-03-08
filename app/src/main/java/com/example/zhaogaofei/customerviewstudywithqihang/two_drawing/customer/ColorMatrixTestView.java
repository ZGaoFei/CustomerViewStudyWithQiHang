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
import android.view.View;

import com.example.zhaogaofei.customerviewstudywithqihang.R;

public class ColorMatrixTestView extends View {
    private Paint paint;

    private ColorMatrix colorMatrix;
    private Bitmap bitmap;

    public ColorMatrixTestView(Context context) {
        super(context);
        init();
    }

    public ColorMatrixTestView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ColorMatrixTestView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setAntiAlias(true);

        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.timu2);

        colorMatrix = new ColorMatrix();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        drawBitmap(canvas);
    }

    private void drawBitmap(Canvas canvas) {
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap, null,
                new Rect(0, 0, 800, 800 * bitmap.getHeight() / bitmap.getWidth()),
                paint);
    }

    public void set(float sat) {
        colorMatrix.setSaturation(sat);
        invalidate();
    }
}
