package com.example.zhaogaofei.customerviewstudywithqihang.one_animator.customer;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

public class CharTextView extends AppCompatTextView {

    public CharTextView(Context context) {
        super(context);
    }

    public CharTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setCharText(Character charText) {
        setText(String.valueOf(charText));
    }
}
