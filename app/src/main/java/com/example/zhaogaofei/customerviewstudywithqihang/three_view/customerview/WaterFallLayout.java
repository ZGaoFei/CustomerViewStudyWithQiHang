package com.example.zhaogaofei.customerviewstudywithqihang.three_view.customerview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import com.example.zhaogaofei.customerviewstudywithqihang.R;


public class WaterFallLayout extends ViewGroup {
    private static final int DEFAULT_COLUMNS = 3;
    private static final int DEFAULT_SPACE = 20;
    private int columns = DEFAULT_COLUMNS;
    private int hSpace = DEFAULT_SPACE;
    private int vSpace = DEFAULT_SPACE;
    private int childWidth = 0;
    private int[] top;

    public WaterFallLayout(Context context) {
        this(context, null);
    }

    public WaterFallLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public WaterFallLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.WaterFallLayout);
        columns = a.getInteger(R.styleable.WaterFallLayout_columns, DEFAULT_COLUMNS);
        hSpace = a.getDimensionPixelSize(R.styleable.WaterFallLayout_hSpace, DEFAULT_SPACE);
        vSpace = a.getDimensionPixelSize(R.styleable.WaterFallLayout_vSpace, DEFAULT_SPACE);
        a.recycle();

        top = new int[columns];
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int widthMeasure = MeasureSpec.getSize(widthMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);

        measureChildren(widthMeasureSpec, heightMeasureSpec);

        childWidth = (widthMeasure - (columns - 1) * hSpace) / columns;

        int wrapWidth;
        int childCount = getChildCount();
        if (childCount < columns) { // 一行以内
            wrapWidth = childCount * childWidth + (childCount - 1) * hSpace;
        } else { // 说明已经超过一行了
            wrapWidth = widthMeasure;
        }

        clearTop();
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            int childHeight = child.getMeasuredHeight() * childWidth / child.getMeasuredWidth();
            int minColumn = getMinColumn();

            WaterFallLayoutParams layoutParams = (WaterFallLayoutParams) child.getLayoutParams();
            layoutParams.left = minColumn * (childWidth + hSpace);
            layoutParams.top = top[minColumn];
            layoutParams.right = layoutParams.left + childWidth;
            layoutParams.bottom = layoutParams.top + childHeight;

            top[minColumn] += childHeight + vSpace;
        }

        int wrapHeight = getMaxHeight();

        setMeasuredDimension(widthMode == MeasureSpec.EXACTLY ? wrapWidth : widthMeasure, wrapHeight);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            WaterFallLayoutParams layoutParams = (WaterFallLayoutParams) child.getLayoutParams();
            child.layout(layoutParams.left, layoutParams.top, layoutParams.right, layoutParams.bottom);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new WaterFallLayoutParams(getContext(), attrs);
    }

    @Override
    protected LayoutParams generateDefaultLayoutParams() {
        return new WaterFallLayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
    }

    @Override
    protected LayoutParams generateLayoutParams(LayoutParams p) {
        return new WaterFallLayoutParams(p);
    }

    @Override
    protected boolean checkLayoutParams(LayoutParams p) {
        return p instanceof WaterFallLayoutParams;
    }

    private void clearTop() {
        for (int i = 0; i < columns; i++) {
            top[i] = 0;
        }
    }

    private int getMinColumn() {
        int minColumn = 0;
        for (int i = 0; i < columns; i++) {
            if (top[minColumn] > top[i]) {
                minColumn = i;
            }
        }
        return minColumn;
    }

    private int getMaxHeight() {
        int maxHeight = 0;
        for (int i = 0; i < columns; i++) {
            if (maxHeight < top[i]) {
                maxHeight = top[i];
            }
        }
        return maxHeight;
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

    public void setOnItemClick(ItemClickListener itemClickListener) {
        if (itemClickListener == null) {
            return;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            int index = i;
            child.setOnClickListener(v ->
                    itemClickListener.onItemClick(v, index)
            );
        }
    }

    public static class WaterFallLayoutParams extends ViewGroup.LayoutParams {
        public int left = 0;
        public int top = 0;
        public int right = 0;
        public int bottom = 0;

        public WaterFallLayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
        }

        public WaterFallLayoutParams(int width, int height) {
            super(width, height);
        }

        public WaterFallLayoutParams(LayoutParams source) {
            super(source);
        }
    }
}
