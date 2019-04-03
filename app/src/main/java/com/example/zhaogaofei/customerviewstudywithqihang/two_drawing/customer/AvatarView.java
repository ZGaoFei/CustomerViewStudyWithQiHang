package com.example.zhaogaofei.customerviewstudywithqihang.two_drawing.customer;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.zhaogaofei.customerviewstudywithqihang.R;

public class AvatarView extends View {

    private Paint paint;
    private Bitmap bitmap;

    private BitmapShader bitmapShader;

    private float radius;
    private int format;

    public AvatarView(Context context) throws Exception {
        super(context);

        init(context, null);
    }

    public AvatarView(Context context, @Nullable AttributeSet attrs) throws Exception {
        super(context, attrs);

        init(context, attrs);
    }

    public AvatarView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) throws Exception {
        super(context, attrs, defStyleAttr);

        init(context, attrs);
    }

    private void init(Context context, @Nullable AttributeSet attrs) throws Exception {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.AvatarView);
        int bitmapId = typedArray.getResourceId(R.styleable.AvatarView_avatarSrc, -1);
        if (bitmapId == -1) {
            throw new Exception("src 不能为null");
        }
        bitmap = BitmapFactory.decodeResource(getResources(), bitmapId);
        format = typedArray.getInt(R.styleable.AvatarView_format, 0);
        if (format == 1) {
            radius = typedArray.getFloat(R.styleable.AvatarView_radius, 5);
        }
        typedArray.recycle();

        paint = new Paint();
        paint.setAntiAlias(true);

        bitmapShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
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
        setMeasuredDimension(
                (widthMode == MeasureSpec.EXACTLY ? widthMeasure : width),
                (heightMode == MeasureSpec.EXACTLY ? heightMeasure : height));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvasAvatar(canvas);
    }

    private void canvasAvatar(Canvas canvas) {
        Matrix matrix = new Matrix();
        float scale = (float) getWidth() / bitmap.getWidth();
        matrix.setScale(scale, scale);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);

        float half = getWidth() / 2;
        if (format == 0) { // draw circle
            canvas.drawCircle(half, half, half, paint);
        } else { // draw rectangle
            canvas.drawRoundRect(new RectF(0, 0, getWidth(), getHeight()), radius, radius, paint);
        }
    }

    private void canvasCircleAvatar(Canvas canvas) {
        Matrix matrix = new Matrix();
        float scale = (float) getWidth() / bitmap.getWidth();
        matrix.setScale(scale, scale);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);

        float half = getWidth() / 2;
        canvas.drawCircle(half, half, half, paint);
    }
}
