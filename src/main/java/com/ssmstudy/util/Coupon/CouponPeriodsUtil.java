package com.ssmstudy.util.Coupon;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CouponPeriodsUtil {

    public static void main(String[] args) {
        LocalDate issuDate = LocalDate.of(2023, 12, 10);
        LocalDate maturityDate = LocalDate.of(2024, 6, 30);
        List<LocalDate> holidayList = getHolidayList();
        List<PeriodEntity> list = genPeriods_1(issuDate, maturityDate, 1, holidayList);
        for (PeriodEntity periodEntity : list) {
            System.out.println("startDate=" + periodEntity.getStartDate() + ", endDate=" + periodEntity.getEndDate());
        }
        
    }
    // option 1
    public static List<PeriodEntity> genPeriods_1(LocalDate issueDate, LocalDate maturityDate, int interval, List<LocalDate> holidays) {
        List<PeriodEntity> list = new ArrayList<>();
        LocalDate endDate = issueDate;
        LocalDate startDate = issueDate;
        LocalDate calcStartDate = issueDate;
        int dayOfMonth = issueDate.getDayOfMonth();
        while (endDate.isBefore(maturityDate)) {
            // origin endDate
            endDate = calcStartDate.plusMonths(interval);
            if (dayOfMonth > endDate.getDayOfMonth() && endDate.lengthOfMonth() >= dayOfMonth) {
                endDate = LocalDate.of(endDate.getYear(), endDate.getMonthValue(), dayOfMonth);
            }
            // if holiday, forward
            LocalDate bsnesEndDate = null;
            if (holidays.contains(endDate)) {
                bsnesEndDate = getNextForwardBusinessDate(endDate, 1, holidays);
            }
            // to use for calculate endDate
            calcStartDate = endDate;
            endDate = bsnesEndDate == null ? endDate : bsnesEndDate;

            PeriodEntity periodEntity = new PeriodEntity();
            periodEntity.setStartDate(startDate);
            periodEntity.setEndDate(endDate);
            list.add(periodEntity);

            startDate = endDate;

        }
        
        return list;
    }

    public static LocalDate getNextForwardBusinessDate(LocalDate endDate, int numsOfDay, List<LocalDate> holidays) {
        while (holidays.contains(endDate)) {
            endDate = endDate.plusDays(numsOfDay);
        }
        return endDate;
    }

    public static List<LocalDate> getHolidayList() {
        List<LocalDate> list = new ArrayList<>(Arrays.asList(
            LocalDate.of(2024, 1, 1),
            LocalDate.of(2024, 1, 6),
            LocalDate.of(2024, 1, 7),
            LocalDate.of(2024, 1, 13),
            LocalDate.of(2024, 1, 14),
            LocalDate.of(2024, 1, 20),
            LocalDate.of(2024, 1, 21),
            LocalDate.of(2024, 1, 27),
            LocalDate.of(2024, 1, 28),
            LocalDate.of(2024, 2, 3),
            LocalDate.of(2024, 2, 4),
            LocalDate.of(2024, 2, 10),
            LocalDate.of(2024, 2, 11),
            LocalDate.of(2024, 2, 12),
            LocalDate.of(2024, 2, 13),
            LocalDate.of(2024, 2, 17),
            LocalDate.of(2024, 2, 18),
            LocalDate.of(2024, 2, 24),
            LocalDate.of(2024, 2, 25),
            LocalDate.of(2024, 3, 2),
            LocalDate.of(2024, 3, 3),
            LocalDate.of(2024, 3, 9),
            LocalDate.of(2024, 3, 10),
            LocalDate.of(2024, 3, 16),
            LocalDate.of(2024, 3, 17),
            LocalDate.of(2024, 3, 23),
            LocalDate.of(2024, 3, 24),
            LocalDate.of(2024, 3, 29),
            LocalDate.of(2024, 3, 30),
            LocalDate.of(2024, 3, 31),
            LocalDate.of(2024, 4, 1),
            LocalDate.of(2024, 4, 4),
            LocalDate.of(2024, 4, 6),
            LocalDate.of(2024, 4, 7),
            LocalDate.of(2024, 4, 13),
            LocalDate.of(2024, 4, 14),
            LocalDate.of(2024, 4, 20),
            LocalDate.of(2024, 4, 21),
            LocalDate.of(2024, 4, 27),
            LocalDate.of(2024, 4, 28),
            LocalDate.of(2024, 5, 1),
            LocalDate.of(2024, 5, 4),
            LocalDate.of(2024, 5, 5),
            LocalDate.of(2024, 5, 11),
            LocalDate.of(2024, 5, 12),
            LocalDate.of(2024, 5, 15),
            LocalDate.of(2024, 5, 18),
            LocalDate.of(2024, 5, 19),
            LocalDate.of(2024, 5, 25),
            LocalDate.of(2024, 5, 26),
            LocalDate.of(2024, 6, 1),
            LocalDate.of(2024, 6, 2),
            LocalDate.of(2024, 6, 8),
            LocalDate.of(2024, 6, 9),
            LocalDate.of(2024, 6, 10),
            LocalDate.of(2024, 6, 15),
            LocalDate.of(2024, 6, 16),
            LocalDate.of(2024, 6, 22),
            LocalDate.of(2024, 6, 23),
            LocalDate.of(2024, 6, 29),
            LocalDate.of(2024, 6, 30)

        ));

        return list;
    }
}
