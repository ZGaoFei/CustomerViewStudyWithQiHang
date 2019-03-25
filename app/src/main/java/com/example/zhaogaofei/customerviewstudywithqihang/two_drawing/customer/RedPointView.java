package com.example.zhaogaofei.customerviewstudywithqihang.two_drawing.customer;

import java.util.Arrays;
import java.util.List;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.AnimationDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zhaogaofei.customerviewstudywithqihang.R;

/**
 * 仿照QQ可拖拽红点效果
 */
public class RedPointView extends FrameLayout {
    private static final int CIRCLE_RADIUS = 20;
    public static final int POINT_TYPE_NORMAL = 0;
    public static final int POINT_TYPE_TEXT = 1;
    public static final int POINT_TYPE_IMAGE = 2;
    private List<Integer> list = Arrays.asList(POINT_TYPE_NORMAL, POINT_TYPE_TEXT, POINT_TYPE_IMAGE);

    private int radius;

    private PointF defaultPoint;
    private PointF currentPoint;

    private Paint paint;
    private Path path;

    private TextView textView;
    private ImageView imageView;

    private boolean isTouch;
    private boolean isAnimation;

    private int type;

    public RedPointView(Context context) {
        super(context);
        init();
    }

    public RedPointView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RedPointView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        radius = CIRCLE_RADIUS;
        type = POINT_TYPE_NORMAL;

        defaultPoint = new PointF(100, 100);
        currentPoint = new PointF();

        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);

        path = new Path();

        initView();
        if (type == POINT_TYPE_NORMAL) {
            textView.setVisibility(INVISIBLE);
            imageView.setVisibility(INVISIBLE);
        }
    }

    private void initView() {
        textView = new TextView(getContext());
        textView.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        textView.setTextColor(Color.WHITE);
        textView.setPadding(10, 10, 10, 10);
        textView.setBackgroundResource(R.drawable.text_bg);
        textView.setText("99+");
        addView(textView);

        imageView = new ImageView(getContext());
        imageView.setImageResource(R.drawable.tip_anim);
        imageView.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        imageView.setVisibility(INVISIBLE);
        addView(imageView);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        int layer = canvas.saveLayer(new RectF(0, 0, getWidth(), getHeight()), paint, Canvas.ALL_SAVE_FLAG);

        if (type == POINT_TYPE_NORMAL) {
            if (!isTouch) {
                canvas.drawCircle(defaultPoint.x, defaultPoint.y, radius, paint);
            } else {
                drawView(canvas);
            }
        } else if (type == POINT_TYPE_TEXT) {
            if (!isTouch) {
                setTextViewLocation(defaultPoint.x, defaultPoint.y);
            } else {
                drawView(canvas);

                setTextViewLocation(currentPoint.x, currentPoint.y);
            }
        } else {
            if (!isTouch || isAnimation) {
                setTextViewLocation(defaultPoint.x, defaultPoint.y);
            } else {
                drawView(canvas);

                setTextViewLocation(currentPoint.x, currentPoint.y);
            }
        }
        canvas.restoreToCount(layer);

        // 在super之前可以把text绘制在红点的上方
        super.dispatchDraw(canvas);
    }

    private void drawView(Canvas canvas) {
        calculatePath();
        canvas.drawCircle(defaultPoint.x, defaultPoint.y, radius, paint);
        canvas.drawCircle(currentPoint.x, currentPoint.y, radius, paint);
        canvas.drawPath(path, paint);
    }

    private void setTextViewLocation(float x, float y) {
        textView.setX(x - textView.getWidth() / 2);
        textView.setY(y - textView.getHeight() / 2);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (type == POINT_TYPE_NORMAL) {
                    isTouch = true;
                } else {
                    if (getTouchRect().contains((int) event.getRawX(), (int) event.getRawY())) {
                        isTouch = true;
                    }
                }
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                isTouch = false;
                break;
        }
        currentPoint.set(event.getX(), event.getY());
        postInvalidate();
        return true;
    }

    private Rect getTouchRect() {
        Rect rect = new Rect();
        int[] location = new int[2];
        textView.getLocationOnScreen(location);
        rect.left = location[0];
        rect.top = location[1];
        rect.right = location[0] + textView.getWidth();
        rect.bottom = location[1] + textView.getHeight();
        return rect;
    }

    private void calculatePath() {
        // 原始坐标点
        float defaultX = defaultPoint.x;
        float defaultY = defaultPoint.y;

        // 手指所在位置
        float currentX = currentPoint.x;
        float currentY = currentPoint.y;

        float dx = currentX - defaultX;
        float dy = currentY - defaultY;
        // 计算手指的偏移角度
        double a = Math.atan(dy / dx);

        // 计算坐标偏移量
        float offsetX = (float) (radius * Math.sin(a));
        float offsetY = (float) (radius * Math.cos(a));

        if (type == POINT_TYPE_IMAGE) {
            startAnimation(dx, dy, currentX, currentY);
        }

        // 原圆形的上面的切点坐标
        float x1 = defaultX + offsetX;
        float y1 = defaultY - offsetY;

        // 原圆形的下面的切点坐标
        float x2 = currentX + offsetX;
        float y2 = currentY - offsetY;

        // 手指所在圆形的上面的切点坐标
        float x3 = currentX - offsetX;
        float y3 = currentY + offsetY;

        // 手指所在圆形的下面的切点坐标
        float x4 = defaultX - offsetX;
        float y4 = defaultY + offsetY;

        // 两个远点所在中间位置的坐标
        float anchorX = (currentX + defaultX) / 2;
        float anchorY = (currentY + defaultY) / 2;

        // 将四个点连接一起
        path.reset();
        path.moveTo(x1, y1);
        path.quadTo(anchorX, anchorY, x2, y2);
        path.lineTo(x3, y3);
        path.quadTo(anchorX, anchorY, x4, y4);
        path.lineTo(x1, y1);
    }

    private void startAnimation(float dx, float dy, float currentX, float currentY){
        // 计算两个圆的中心点距离
        float distance = (float) Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
        radius = (int) (CIRCLE_RADIUS - distance / 30);
        if (radius < 9) {
            isAnimation = true;
            imageView.setX(currentX - textView.getWidth() / 2);
            imageView.setY(currentY - textView.getHeight() / 2);
            imageView.setVisibility(VISIBLE);
            ((AnimationDrawable) imageView.getDrawable()).start();

            textView.setVisibility(GONE);
        }
    }

    public void reset() {
        radius = CIRCLE_RADIUS;

        resetInter();

        postInvalidate();
    }

    private void resetInter() {
        if (type == POINT_TYPE_IMAGE) {
            isTouch = false;
            isAnimation = false;
            textView.setVisibility(VISIBLE);
            imageView.setVisibility(INVISIBLE);
        }
    }

    public void setType(int type) {
        if (list != null && !list.isEmpty() && list.contains(type)) {
            this.type = type;
            radius = CIRCLE_RADIUS;
            if (type == POINT_TYPE_NORMAL) {
                textView.setVisibility(INVISIBLE);
            } else if (type == POINT_TYPE_TEXT) {
                textView.setVisibility(VISIBLE);
            } else {
                resetInter();
            }
            postInvalidate();
        } else {
            throw new IllegalArgumentException("Type must is 0, 1, 2");
        }
    }

}
