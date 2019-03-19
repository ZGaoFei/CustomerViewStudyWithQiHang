package com.example.zhaogaofei.customerviewstudywithqihang.two_drawing.customer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.zhaogaofei.customerviewstudywithqihang.R;

public class CircleBitmapView extends View {

    private Paint paint;
    private Bitmap dstBitmap;
    private Bitmap srcBitmap;
    private Bitmap translateBitmap;
    private Bitmap bmpRevert;

    public CircleBitmapView(Context context) {
        super(context);
        init();
    }

    public CircleBitmapView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CircleBitmapView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setLayerType(View.LAYER_TYPE_SOFTWARE, null);

        paint = new Paint();
        // paint.setAntiAlias(true);

        dstBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.dog_shade);
        srcBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.dog);
        translateBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.dog_invert_shade);

        Matrix matrix = new Matrix();
        matrix.setScale(1F, -1F);
        // 生成倒影图
        bmpRevert = Bitmap.createBitmap(srcBitmap, 0, 0, srcBitmap.getWidth(), srcBitmap.getHeight(), matrix, true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        drawCircleBitmap(canvas);

        // drawTranslateBitmap(canvas);
    }

    /**
     * 实现圆角图片
     */
    private void drawCircleBitmap(Canvas canvas) {
        int layer = canvas.saveLayer(0, 0, getWidth(), getHeight(), null, Canvas.ALL_SAVE_FLAG);
        canvas.drawBitmap(dstBitmap, 0, 0, paint);
        // paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));

        canvas.drawBitmap(srcBitmap, 0, 0, paint);

        paint.setXfermode(null);
        canvas.restoreToCount(layer);
    }

    /**
     * 实现倒影功能
     */
    private void drawTranslateBitmap(Canvas canvas) {
        //先画出小狗图片
        canvas.drawBitmap(srcBitmap, 0, 0, paint);

        int layer = canvas.saveLayer(0, 0, getWidth(), getHeight(), paint, Canvas.ALL_SAVE_FLAG);
        canvas.translate(0, srcBitmap.getHeight());

        canvas.drawBitmap(translateBitmap, 0, 0, paint);
        // paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));

        canvas.drawBitmap(bmpRevert, 0, 0, paint);

        paint.setXfermode(null);
        canvas.restoreToCount(layer);
    }
}

