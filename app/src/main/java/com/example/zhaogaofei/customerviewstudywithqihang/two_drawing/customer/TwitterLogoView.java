package com.example.zhaogaofei.customerviewstudywithqihang.two_drawing.customer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.zhaogaofei.customerviewstudywithqihang.R;

public class TwitterLogoView extends View {

    private Paint paint;
    private Bitmap dstBitmap;
    private Bitmap srcBitmap;


    public TwitterLogoView(Context context) {
        super(context);
        init();
    }

    public TwitterLogoView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TwitterLogoView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setLayerType(View.LAYER_TYPE_SOFTWARE, null);

        paint = new Paint();
        paint.setAntiAlias(true);

        dstBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.twiter_bg);
        srcBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.twiter_light);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        drawBitmap(canvas);

    }

    private void drawBitmap(Canvas canvas) {
        int layer = canvas.saveLayer(0, 0, 500, 500 * dstBitmap.getHeight() / dstBitmap.getWidth(), null, Canvas.ALL_SAVE_FLAG);
        canvas.drawBitmap(dstBitmap, 0, 0, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
        canvas.drawBitmap(srcBitmap, 0, 0, paint);

        paint.setXfermode(null);
        canvas.restoreToCount(layer);
    }

}
