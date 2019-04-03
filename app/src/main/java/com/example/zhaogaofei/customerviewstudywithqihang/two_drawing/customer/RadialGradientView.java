package com.example.zhaogaofei.customerviewstudywithqihang.two_drawing.customer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class RadialGradientView extends View {
    private Paint paint;

    public RadialGradientView(Context context) {
        super(context);
        init();
    }

    public RadialGradientView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RadialGradientView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // canvasCircle1(canvas);
        canvasCircle2(canvas);
    }

    private void canvasCircle1(Canvas canvas) {
        RadialGradient radialGradient = new RadialGradient(
                200, 200,
                150,
                0xffffffff, 0xff000000,
                Shader.TileMode.MIRROR);

        paint.setShader(radialGradient);

        canvas.drawCircle(200, 200, 150, paint);
    }

    private void canvasCircle2(Canvas canvas) {
        RadialGradient radialGradient = new RadialGradient(
                200, 200,
                150,
                new int[]{0xffff0000, 0xff00ff00, 0xff0000ff, 0xffffff00},
                new float[]{0f, 0.2f, 0.5f, 1f},
                Shader.TileMode.CLAMP);

        paint.setShader(radialGradient);

        canvas.drawCircle(200, 200, 150, paint);
    }
}
