package com.ssmstudy.util.DatePeriods;

import java.time.LocalDate;

import lombok.Data;

@Data
public class DatePeriod {
    
    public DatePeriod(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    private LocalDate startDate;

    private LocalDate endDate;
}
