package com.app.utils;

import org.springframework.util.StringUtils;

public class MyStringUtils {
    private MyStringUtils() {}

    public static String getValue(String str) {
        return StringUtils.isEmpty(str) ? "" : str;
    }
}
