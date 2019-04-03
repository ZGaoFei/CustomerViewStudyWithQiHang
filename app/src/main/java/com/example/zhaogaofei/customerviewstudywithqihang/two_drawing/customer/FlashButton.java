package com.example.zhaogaofei.customerviewstudywithqihang.two_drawing.customer;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.AccelerateInterpolator;

public class FlashButton extends AppCompatButton {
    private static final int CIRCLE_RADIUS = 50;

    private Paint paint;

    private RadialGradient radialGradient;

    private int dx;
    private int dy;

    private int radius;

    private ObjectAnimator animator;

    public FlashButton(Context context) {
        super(context);
        init();
    }

    public FlashButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        setLayerType(LAYER_TYPE_SOFTWARE, null);

        paint = getPaint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(dx, dy, radius, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        if (dx != x || dy != y) {
            dx = x;
            dy = y;
            setRadius(CIRCLE_RADIUS);
        }

        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            return true;
        } else if (event.getAction() == MotionEvent.ACTION_UP) {
            startAnimation();
        }
        return super.onTouchEvent(event);
    }

    private void setRadius(int rad) {
        this.radius = rad;
        if (rad > 0) {
            radialGradient = new RadialGradient(dx, dy, radius,
                    0x00FFFFFF, 0xFF58FAAC,
                    Shader.TileMode.CLAMP);
            paint.setShader(radialGradient);
        }
        postInvalidate();
    }

    private void startAnimation() {
        if (animator == null) {
            animator = ObjectAnimator.ofInt(this, "radius", CIRCLE_RADIUS, getWidth());
        }
        if (animator != null && animator.isRunning()) {
            animator.cancel();
        }
        animator.setInterpolator(new AccelerateInterpolator());
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                setRadius(0);
            }
        });
        animator.start();
    }
}
