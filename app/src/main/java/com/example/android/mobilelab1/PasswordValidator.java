package com.example.android.mobilelab1;

import java.util.function.Predicate;

public class PasswordValidator implements Predicate<String> {
    @Override
    public boolean test(String password) {
        return password.length() > 8;
    }
}
