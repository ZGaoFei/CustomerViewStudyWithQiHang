package com.example.zhaogaofei.customerviewstudywithqihang.three_view.customerview;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Transformation;

public class MyLinLayout extends ViewGroup {

    public MyLinLayout(Context context) {
        super(context);
    }

    public MyLinLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyLinLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMeasure = MeasureSpec.getSize(widthMeasureSpec);
        int heightMeasure = MeasureSpec.getSize(heightMeasureSpec);
        int modeWidth = MeasureSpec.getMode(widthMeasureSpec);
        int modeHeight = MeasureSpec.getMode(heightMeasureSpec);

        Log.e("zgf", "mesaure spec to string: " + MeasureSpec.toString(widthMeasureSpec));

        int width = 0;
        int height = 0;

        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            measureChild(child, widthMeasureSpec, heightMeasureSpec);

            MarginLayoutParams layoutParams = (MarginLayoutParams) child.getLayoutParams();
            int childWidth = child.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
            int childHeight = child.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;

            if (i == 0) {
                width = childWidth;
            } else {
                width = Math.max(width, childWidth);
            }
            height += childHeight;
        }
        Log.e("zgf", "view result width: " + width);

        // 适配wrap_content，如果设置固定值则使用测量值，
        // 如果是wrap_content使用计算的子view的值
        setMeasuredDimension(
                modeWidth == MeasureSpec.EXACTLY ? widthMeasure : width,
                modeHeight == MeasureSpec.EXACTLY ? heightMeasure : height);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int top = 0;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);

            MarginLayoutParams layoutParams = (MarginLayoutParams) child.getLayoutParams();
            int measuredWidth = child.getMeasuredWidth();
            int measuredHeight = child.getMeasuredHeight();
            child.layout(layoutParams.leftMargin, layoutParams.topMargin + top, measuredWidth + layoutParams.rightMargin, top + measuredHeight + layoutParams.bottomMargin);

            top = measuredHeight + layoutParams.topMargin + layoutParams.bottomMargin + top;
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

    }

    @Override
    protected LayoutParams generateDefaultLayoutParams() {
        return new MarginLayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
    }

    @Override
    protected LayoutParams generateLayoutParams(LayoutParams p) {
        return new MarginLayoutParams(p);
    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new MarginLayoutParams(getContext(), attrs);
    }
}
