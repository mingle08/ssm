package com.ssmstudy.util.DatePeriods;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.ssmstudy.util.Coupon.BusinessService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PeriodsUtil {

    private BusinessService businessService;

    public List<DatePeriod> generateDatePeriods(LocalDate inputDate, int count, String option) {
        List<DatePeriod> DatePeriods = new ArrayList<>();
        LocalDate startDate = inputDate;
        LocalDate endDate = inputDate;
        LocalDate calcDate = inputDate;
        int dayOfMonth = inputDate.getDayOfMonth();
        LocalDate bsnesDate = null;

        List<LocalDate> holidays = businessService.getHolidayList();

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
                bsnesDate = businessService.getNextForwardBusinessDate(endDate, 1, holidays);
            } else if ("2".equals(option)) {// 以上次的endDate的dayOfMonth为准
                endDate = startDate.plusMonths(1);
                bsnesDate = businessService.getNextForwardBusinessDate(endDate, 2, holidays);
            } else if ("3".equals(option)) {// 以月末为准
                endDate = startDate.plusMonths(1);
                endDate = endDate.withDayOfMonth(endDate.lengthOfMonth());
                bsnesDate = businessService.getNextForwardBusinessDate(endDate, 3, holidays);
            } else {// 以inputDate的DayOfMonth为准，不允许跨月
                // 加1个月
                endDate = calcDate.plusMonths(1);
                if (endDate.getDayOfMonth() < dayOfMonth && endDate.lengthOfMonth() > dayOfMonth) {
                    endDate = endDate.withDayOfMonth(dayOfMonth);
                }
                calcDate = endDate;
                bsnesDate = businessService.getNextForwardBusinessDate(endDate, 4, holidays);

            }
             
            endDate = bsnesDate == null ? endDate : bsnesDate;
            
            // 创建日期对并添加到集合
            DatePeriod datePeriod = new DatePeriod(startDate, endDate);
            DatePeriods.add(datePeriod);

            startDate = endDate;
        }

        return DatePeriods;
    }
}
