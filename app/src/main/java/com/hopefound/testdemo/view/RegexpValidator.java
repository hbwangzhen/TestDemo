package com.hopefound.testdemo.view;

import android.support.annotation.NonNull;

import java.util.regex.Pattern;

/**
 * Created by 王震 on 2018/4/11 0011.
 */

public class RegexpValidator extends METValidator {
    private Pattern pattern;

    public RegexpValidator(@NonNull String errorMessage, @NonNull String regex) {
        super(errorMessage);
        pattern = Pattern.compile(regex);
    }

    @Override
    public boolean isValid(@NonNull CharSequence text, boolean isEmpty) {
        return pattern.matcher(text).matches();
    }
}
