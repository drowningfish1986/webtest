package com.example.util;

/**
 * Des     : (一句话描述)
 *
 * @Author : liuyu
 * @Date : 2017/9/13.
 */
public class StringUtils {

    public static boolean isNotBlank(String s){
        return !isBlank(s);
    }

    public static boolean isBlank(String s){
        return null == s || "".equals(s.trim());
    }
}
