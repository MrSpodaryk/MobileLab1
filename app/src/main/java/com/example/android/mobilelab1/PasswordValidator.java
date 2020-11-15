package com.example.android.mobilelab1;

public class PasswordValidator {

    private static final int MIN_PASSWORD_LENGTH = 9;

    public boolean validate(String password) {
        return password.length() >= MIN_PASSWORD_LENGTH;
    }
}
