package com.example.zhaogaofei.customerviewstudywithqihang.one_animator.customer;

import android.animation.TypeEvaluator;

public class CharEvaluator implements TypeEvaluator<Character> {

    @Override
    public Character evaluate(float fraction, Character startValue, Character endValue) {
        int startChar = startValue;
        int endChar = endValue;

        // (int)(startInt + fraction * (endValue - startInt));
        return (char)(startChar + fraction * (endChar - startChar));
    }
}
