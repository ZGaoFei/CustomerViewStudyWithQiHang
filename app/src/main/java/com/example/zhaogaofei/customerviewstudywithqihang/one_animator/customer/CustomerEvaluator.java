package com.example.zhaogaofei.customerviewstudywithqihang.one_animator.customer;

import android.animation.TypeEvaluator;

public class CustomerEvaluator implements TypeEvaluator<Integer> {

    @Override
    public Integer evaluate(float fraction, Integer startValue, Integer endValue) {
        // 改变动画运行的方式，倒着运行
        int endInt = endValue;
        return (int)(endInt + fraction * (startValue - endInt));
    }
}
