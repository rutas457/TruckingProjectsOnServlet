package com.training.ServletLogin.utils;

public class ValidationUtils {
    public static boolean correctInput(String... params) {
        for (String param : params) {
            if (param == null || param.equals("")) {
                return false;
            }
        }
        return true;
    }
}
