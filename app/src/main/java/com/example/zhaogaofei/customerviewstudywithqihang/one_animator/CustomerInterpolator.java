package com.example.zhaogaofei.customerviewstudywithqihang.one_animator;

import android.annotation.SuppressLint;
import android.view.animation.Interpolator;

@SuppressLint("NewApi")
public class CustomerInterpolator implements Interpolator {

    private final float mFactor = 0.4F;

    // 实现运行到头后进行回弹的效果
    // factor = 0.4
    // pow(2, -10 * x) * sin((x - factor / 4) * (2 * PI) / factor) + 1

    @Override
    public float getInterpolation(float input) {
        return (float) (Math.pow(2, -10 * input) * Math.sin((input - mFactor / 4) * (2 * Math.PI) / mFactor) + 1);
    }
}
