package com.ssmstudy.util.Coupon;

import java.time.LocalDate;

import lombok.Data;

@Data
public class PeriodEntity {
    private LocalDate startDate;

    private LocalDate endDate;
}
