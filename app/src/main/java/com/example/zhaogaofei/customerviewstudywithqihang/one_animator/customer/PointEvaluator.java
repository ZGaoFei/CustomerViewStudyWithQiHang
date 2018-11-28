package com.example.zhaogaofei.customerviewstudywithqihang.one_animator.customer;

import android.animation.TypeEvaluator;

public class PointEvaluator implements TypeEvaluator<Point> {

    @Override
    public Point evaluate(float fraction, Point startValue, Point endValue) {
        int startRadius = startValue.getRadius();
        int endRadius = endValue.getRadius();
        int resultRadius = (int) (startRadius + fraction * (endRadius - startRadius));
        return new Point(resultRadius);
    }
}
