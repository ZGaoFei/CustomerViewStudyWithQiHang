package com.example.zhaogaofei.customerviewstudywithqihang.two_drawing.customer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;


public class LinearGradientView extends View {

    private Paint paint;

    public LinearGradientView(Context context) {
        super(context);
        init();
    }

    public LinearGradientView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LinearGradientView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setLayerType(LAYER_TYPE_SOFTWARE, null);

        paint = new Paint();
        paint.setAntiAlias(true);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvasRect(canvas);

        // canvasRect1(canvas);

        // canvasText(canvas);

    }

    private void canvasRect(Canvas canvas) {
        LinearGradient linearGradient = new LinearGradient(
                0, getHeight() / 2,
                getWidth(), getHeight() / 2,
                0xffff0000, 0xff00ff00,
                Shader.TileMode.REPEAT);
        paint.setShader(linearGradient);

        canvas.drawRect(0, 0, getWidth(), getHeight(), paint);
    }

    private void canvasRect1(Canvas canvas) {
        LinearGradient linearGradient = new LinearGradient(
                0, 0,
                getWidth(), getHeight(),
                new int[]{0xffff0000, 0xff00ff00, 0xff0000ff, 0xffffff00, 0xff00ffff},
                new float[]{0f, 0.2f, 0.4f, 0.6f, 1.0f},
                Shader.TileMode.REPEAT);
        paint.setShader(linearGradient);

        canvas.drawRect(0, 0, getWidth(), getHeight(), paint);
    }

    private void canvasText(Canvas canvas) {
        LinearGradient linearGradient = new LinearGradient(
                0, 0,
                getWidth() / 2, getHeight() / 2,
                new int[]{0xffff0000, 0xff00ff00, 0xff0000ff, 0xffffff00, 0xff00ffff},
                new float[]{0f, 0.2f, 0.4f, 0.6f, 1.0f},
                Shader.TileMode.REPEAT);
        paint.setTextSize(50);
        paint.setShader(linearGradient);

        canvas.drawText("hello world!!!!!!", 0, 200, paint);
    }
}
