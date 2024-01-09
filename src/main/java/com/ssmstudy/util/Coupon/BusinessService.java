package com.ssmstudy.util.Coupon;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BusinessService {

    public LocalDate getNextForwardBusinessDate(LocalDate endDate, int numsOfDay, List<LocalDate> holidays) {
        while (holidays.contains(endDate)) {
            endDate = endDate.plusDays(numsOfDay);
        }
        return endDate;
    }

    public List<LocalDate> getHolidayList() {
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
