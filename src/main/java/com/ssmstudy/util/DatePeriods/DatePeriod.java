package com.ssmstudy.util.DatePeriods;

import java.time.LocalDate;

public class DatePeriod {
    
    public DatePeriod(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    private LocalDate startDate;

    private LocalDate endDate;

    private LocalDate paymentDate;

    private LocalDate recordDate;

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public LocalDate getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(LocalDate recordDate) {
        this.recordDate = recordDate;
    }

    @Override
    public String toString() {
        return "DatePeriod{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                ", paymentDate=" + paymentDate +
                ", recordDate=" + recordDate +
                '}';
    }
}
