package com.example.zhaogaofei.customerviewstudywithqihang.two_drawing.customer;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.icu.util.MeasureUnit;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.zhaogaofei.customerviewstudywithqihang.R;

public class BitmapShadowView extends View {
    private Paint paint;

    private Bitmap bitmap;
    private Bitmap alphaBitmap;

    private int dx = 10;
    private int dy = 10;
    private float radius = 0;
    private int color;


    public BitmapShadowView(Context context) throws Exception {
        super(context);
        init(context, null);
    }

    public BitmapShadowView(Context context, @Nullable AttributeSet attrs) throws Exception {
        super(context, attrs);
        init(context, attrs);
    }

    public BitmapShadowView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) throws Exception {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, @Nullable AttributeSet attrs) throws Exception {
        setLayerType(LAYER_TYPE_SOFTWARE, null);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.BitmapShadowView);
        int bitmapId = typedArray.getResourceId(R.styleable.BitmapShadowView_src, -1);
        if (bitmapId == -1) {
            throw new Exception("src 不能为空！！！");
        }
        bitmap = BitmapFactory.decodeResource(getResources(), bitmapId);
        alphaBitmap = bitmap.extractAlpha();

        dx = typedArray.getInteger(R.styleable.BitmapShadowView_shadowDx, 0);
        dy = typedArray.getInteger(R.styleable.BitmapShadowView_shadowDy, 0);
        radius = typedArray.getFloat(R.styleable.BitmapShadowView_shadowRadius, 0);
        color = typedArray.getColor(R.styleable.BitmapShadowView_shadowColor, Color.BLACK);

        typedArray.recycle();

        paint = new Paint();
        paint.setAntiAlias(true);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        drawBitmap(canvas);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMeasure = MeasureSpec.getSize(widthMeasureSpec);
        int heightMeasure = MeasureSpec.getSize(heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);

        int width = bitmap.getWidth();
        int height = bitmap.getHeight();

        // 适配wrap_content
        setMeasuredDimension(
                (widthMode == MeasureSpec.EXACTLY ? widthMeasure : width),
                (heightMode == MeasureSpec.EXACTLY ? heightMeasure : height));
    }

    private void drawBitmap(Canvas canvas) {
        int width = getWidth() - dx;
        int height = width * bitmap.getHeight() / bitmap.getWidth();

        paint.setColor(color);
        paint.setMaskFilter(new BlurMaskFilter(radius, BlurMaskFilter.Blur.NORMAL));
        canvas.drawBitmap(alphaBitmap, null, new Rect(dx, dy, width, height), paint);

        paint.setMaskFilter(null);
        canvas.drawBitmap(bitmap, null, new Rect(0, 0, width, height), paint);
    }

    private void drawBit(Canvas canvas) {
        paint.setMaskFilter(new BlurMaskFilter(10, BlurMaskFilter.Blur.NORMAL));
        paint.setColor(Color.RED);
        // canvas.translate(0, 250);
        canvas.drawBitmap(alphaBitmap,
                null,
                new Rect(0, 0, 300, 300 * bitmap.getHeight() / bitmap.getWidth()),
                paint);

        paint.setColor(Color.GREEN);
        canvas.translate(0, 250);
        canvas.drawBitmap(alphaBitmap,
                null,
                new Rect(0, 0, 300, 300 * bitmap.getHeight() / bitmap.getWidth()),
                paint);

        canvas.translate(0, -250);
        paint.setMaskFilter(null);
        canvas.drawBitmap(bitmap,
                null,
                new Rect(0, 0, 300, 300 * bitmap.getHeight() / bitmap.getWidth()),
                paint);

        canvas.translate(0, 250);
        canvas.drawBitmap(bitmap,
                null,
                new Rect(0, 0, 300, 300 * bitmap.getHeight() / bitmap.getWidth()),
                paint);
    }
}
