package com.ssmstudy.util.mapstruct;

import javax.persistence.Transient;

public class DtoC {
    @Transient
    private int id;

    // time pattern  HH:mm
    private String fromTime;

    // time pattern  HH:mm
    private String toTime;

    private Integer nextCouponRate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFromTime() {
        return fromTime;
    }

    public void setFromTime(String fromTime) {
        this.fromTime = fromTime;
    }

    public String getToTime() {
        return toTime;
    }

    public void setToTime(String toTime) {
        this.toTime = toTime;
    }

    public Integer getNextCouponRate() {
        return nextCouponRate;
    }

    public void setNextCouponRate(Integer nextCouponRate) {
        this.nextCouponRate = nextCouponRate;
    }

    @Override
    public String toString() {
        return "DtoC{" +
                "id=" + id +
                ", fromTime='" + fromTime + '\'' +
                ", toTime='" + toTime + '\'' +
                ", nextCouponRate=" + nextCouponRate +
                '}';
    }
}
