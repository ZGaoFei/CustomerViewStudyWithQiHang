package com.example.zhaogaofei.customerviewstudywithqihang.two_drawing.customer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.zhaogaofei.customerviewstudywithqihang.R;

public class ShadowLayerView extends View {
    private Paint paint;

    private Bitmap bitmap;

    private int radius = 1;
    private int dx = 10;
    private int dy = 10;

    private boolean isShowShadow = true;

    public ShadowLayerView(Context context) {
        super(context);
        init();
    }

    public ShadowLayerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ShadowLayerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setLayerType(LAYER_TYPE_SOFTWARE, null);

        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setTextSize(45);
        paint.setColor(Color.GREEN);

        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.timo);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (isShowShadow) {
            paint.setShadowLayer(radius, dx, dy, Color.GRAY);
        } else {
            paint.clearShadowLayer();
        }

        canvas.drawText("hello world!!!", 100, 100, paint);

        canvas.drawCircle(200, 200, 50, paint);

        canvas.drawBitmap(bitmap, 100, 300, paint);
    }

    public void addRadius(int radius) {
        this.radius += radius;
        postInvalidate();
    }

    public void addDx(int dx) {
        this.dx += dx;
        postInvalidate();
    }

    public void addDy(int dy) {
        this.dy += dy;
        postInvalidate();
    }

    public void reset() {
        radius = 1;
        dx = 10;
        dy = 10;
        postInvalidate();
    }

    public void clearShadow() {
        isShowShadow = false;
        postInvalidate();
    }

    public void showShadow() {
        isShowShadow = true;
        postInvalidate();
    }
}
