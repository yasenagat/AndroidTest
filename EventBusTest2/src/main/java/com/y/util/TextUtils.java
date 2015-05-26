package com.y.util;

import android.widget.EditText;


public class TextUtils {

    private TextUtils() { /* cannot be instantiated */}

    /**
     * @param et
     * @return {@link android.widget.EditText#getEditableText()} if not empty, else return {@link android.widget.EditText#getHint()}
     */
    public static CharSequence getHintIfTextIsNull(EditText et) {
        CharSequence text;
        if (et == null) {
            return null;
        }

        return ("".equals(text = et.getEditableText().toString())) ? et.getHint() : text;
    }
}
