package com.example.android.mobilelab1;

import android.text.TextUtils;
import android.util.Patterns;

public class EmailValidator {

    public boolean validate(String email) {
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}
