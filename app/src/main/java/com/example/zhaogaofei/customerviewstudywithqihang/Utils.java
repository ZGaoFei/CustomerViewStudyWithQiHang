package com.example.zhaogaofei.customerviewstudywithqihang;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;

public class Utils {

    private Utils() {

    }

    public static int getScreenWidth(Activity activity) {
        DisplayMetrics dm = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
        return dm.widthPixels;
    }

    public static int getScreenHeight(Activity activity) {
        DisplayMetrics dm = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
        return dm.heightPixels;
    }

    public static int px2dip(Context cc, float pxValue) {
        final float scale = cc.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    public static int dip2px(Context cc, float dipValue) {
        final float scale = cc.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }
}
