package com.ssmstudy.util.DatePeriods;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PeriodsUtil {

    public static List<DatePeriod> generateDatePeriods(LocalDate inputDate, int count, String option) {
        List<DatePeriod> DatePeriods = new ArrayList<>();
        LocalDate startDate = inputDate;
        LocalDate endDate = inputDate;
        LocalDate calcDate = inputDate;
        int dayOfMonth = inputDate.getDayOfMonth();

        for (int i = 0; i < count; i++) {
            if ("1".equals(option)) {//以inputDate的DayOfMonth为准，允许跨月
                // 加1个月
                endDate = calcDate.plusMonths(1);
                if (endDate.getDayOfMonth() < dayOfMonth && endDate.lengthOfMonth() > dayOfMonth) {
                    endDate = endDate.withDayOfMonth(dayOfMonth);
                }
                calcDate = endDate;
                
                // 检查最后一天是否小于等于30号
                if (endDate.lengthOfMonth() < dayOfMonth) {
                    // 如果是，直接使用最后一天的日期
                    endDate = endDate.plusDays(1);
                }
            } else if ("2".equals(option)) {// 以上次的endDate的dayOfMonth为准
                endDate = startDate.plusMonths(1);
            } else if ("3".equals(option)) {// 以月末为准
                endDate = startDate.plusMonths(1);
                endDate = endDate.withDayOfMonth(endDate.lengthOfMonth());
            } else {// 以inputDate的DayOfMonth为准，不允许跨月
                // 加1个月
                endDate = calcDate.plusMonths(1);
                if (endDate.getDayOfMonth() < dayOfMonth && endDate.lengthOfMonth() > dayOfMonth) {
                    endDate = endDate.withDayOfMonth(dayOfMonth);
                }
                calcDate = endDate;
            }
             
            
            // 创建日期对并添加到集合
            DatePeriod datePeriod = new DatePeriod(startDate, endDate);
            DatePeriods.add(datePeriod);

            startDate = endDate;
        }

        return DatePeriods;
    }

    public static void main(String[] args) {
        // inputDate
        LocalDate inpuDate = LocalDate.of(2024, 1, 30);
        String option = "4";
        // List
        List<DatePeriod> list = generateDatePeriods(inpuDate, 5, option);

        System.out.println(option);
        for (DatePeriod datePeriod : list) {
            System.out.println(datePeriod);
        }
    }
}
