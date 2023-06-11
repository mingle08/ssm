package com.ssmstudy.jdk.PatternRex;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * 正则表达式
 */
public class PatternDemo {

    public static void main(String[] args) {
        String value = "dubbo, redis, zookeeper";
        // dubbo源码中的ExtensionLoader.java中的正则表达式
//        Pattern p = Pattern.compile("\\s*[,]+\\s*");
        String pattern_str = "^(([0][1-9])|([1][0-2]))(([0-2][0-9])|([3][0,1]))([0-1][0-9]|[2][0-3])([0-5][0-9])([0-5][0-9])$";
        SimpleDateFormat sdf = new SimpleDateFormat("MMddHHmmss");
        sdf.setLenient(false);
        Pattern p = Pattern.compile(pattern_str);
        String dateStr = "0231231455";
        boolean matches = Pattern.matches(pattern_str, dateStr);
        if (matches) {
            System.out.println("matches");
            try {
                sdf.parse(dateStr);
            } catch (ParseException e) {
                System.out.println("date format error");
            }
        }
        System.out.println();
//        String[] arr = p.split(value);
//        for (String str : arr) {
//            System.out.println(str);
//        }
    }
}
