package com.example.zhaogaofei.customerviewstudywithqihang.two_drawing.customer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.example.zhaogaofei.customerviewstudywithqihang.R;

public class BitmapShaderView extends View {
    private static final int CIRCLE_RADIUS = 150;

    private Paint paint;

    private Bitmap bitmap;
    private Bitmap bgBitmap;

    private int dx = -1;
    private int dy = -1;

    public BitmapShaderView(Context context) {
        super(context);
        init();
    }

    public BitmapShaderView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BitmapShaderView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setAntiAlias(true);

        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.timg);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvasCircle(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                dx = (int) event.getX();
                dy = (int) event.getY();
                postInvalidate();
                break;
            case MotionEvent.ACTION_MOVE:
                dx = (int) event.getX();
                dy = (int) event.getY();
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                dx = -1;
                dy = -1;
                break;
        }
        postInvalidate();
        return true;
    }

    private void canvasCircle(Canvas canvas) {
        if (bgBitmap == null) {
            bgBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
            Canvas bgCanvas = new Canvas(bgBitmap);
            bgCanvas.drawBitmap(bitmap, null, new Rect(0, 0, getWidth(), getHeight()), paint);
        }

        if (dx != -1 && dy != -1) {
            paint.setShader(new BitmapShader(bgBitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT));
            canvas.drawCircle(dx, dy, CIRCLE_RADIUS, paint);
        }
    }

    private void setShader() {
        paint.setShader(new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT));
        paint.setShader(new BitmapShader(bitmap, Shader.TileMode.MIRROR, Shader.TileMode.MIRROR));
        paint.setShader(new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
    }

    private void canvasRect(Canvas canvas) {
        canvas.drawRect(0, 0, getWidth(), getHeight(), paint);
    }
}
