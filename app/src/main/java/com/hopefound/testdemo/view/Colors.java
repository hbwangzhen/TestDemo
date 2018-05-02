package com.hopefound.testdemo.view;

import android.graphics.Color;

/**
 * Created by 王震 on 2018/4/11 0011.
 */

public class Colors {
    public static boolean isLight(int color) {
        return Math.sqrt(
                Color.red(color) * Color.red(color) * .241 +
                        Color.green(color) * Color.green(color) * .691 +
                        Color.blue(color) * Color.blue(color) * .068) > 130;
    }
}
