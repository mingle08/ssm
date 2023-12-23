package com.ssmstudy.util;

import java.util.Calendar;

/**
 * 打印windows电脑上右下角显示的当月的日历
 * 从周一开始，周日结束
 */
public class CalendarOfThisMonth {
    public static void main(String[] args) {
        System.out.println("周一\t周二\t周三\t周四\t周五\t周六\t周日");

        Calendar calendar = Calendar.getInstance();
        /*
            在Java的Calendar类中，星期的表示是以1到7的整数形式进行计算的，其中：
            1表示星期日，
            2表示星期一，
            3表示星期二，
            4表示星期三，
            5表示星期四，
            6表示星期五，
            7表示星期六
        */ 
        int realDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        // 当前日期是几号
        int realDayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println("今天真实的日期是" + realDayOfMonth + "号，周" + realDayOfWeek);
        // 这一句设置之后，后面的dayOfWeek和dayOfMonth都是从1号周几和1号开始，每次循环后移1天
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        // 本月最大的天数
        int maxDay = calendar.getMaximum(Calendar.DAY_OF_MONTH);
        //
        for (int i = 0; i < maxDay; i++) {
            // 当前日期是周几
            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
            // 当前日期是几号
            int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
            if (i == 0) {// 1号
                if (dayOfWeek == Calendar.SUNDAY) {
                    for (int j = 0; j < 6; j++) {
                        // print不带ln
                        System.out.print("\t");
                    }
                    // 因为周日在此程序中排最后，打印之后要换行
                    System.out.println(dayOfMonth);
                } else {
                    /*
                        为什么减2 ？因为2对应星期一。
                        如果dayOfWeek是2，代表星期一，正好在此打印1号，不需要打印空格：2 - 2 = 周一 - 周一
                        如果dayOfWeek是3，代表星期二，前面要打印1个空格：3 - 2 = 周二 - 周一
                        以引类推，
                        如果dayOfWeek是7，代表星期六，前面要打印5个空格：7 - 2 = 周六 - 周一
                    */ 
                    for (int j = 0; j < dayOfWeek - 2; j++) {
                        System.out.print("\t");
                    }
                    System.out.print(dayOfMonth);
                    System.out.print("\t");
                }
            } else {// 不是1号
                if (dayOfWeek == Calendar.SUNDAY) {
                    // 因为周日在此程序中排最后，打印之后要换行
                    System.out.println(dayOfMonth);
                } else {
                    // 这2个print没有ln，不换行
                    System.out.print(dayOfMonth);
                    System.out.print("\t");
                }
            }
            // 后移1天
            calendar.add(Calendar.DATE, 1);
        }
    }
}
