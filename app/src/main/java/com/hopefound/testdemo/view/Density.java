package com.hopefound.testdemo.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;

/**
 * Created by 王震 on 2018/4/11 0011.
 */

public class Density {
    public static int dp2px(Context context, float dp) {
        Resources r = context.getResources();
        float px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics());
        return Math.round(px);
    }
}
