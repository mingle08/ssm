package com.ssmstudy.util.mapstruct;

public class DtoD {
    private int id;

    // HHmm
    private int fromInt;

    // HHmm
    private int toInt;

    private Integer nextCouponRate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFromInt() {
        return fromInt;
    }

    public void setFromInt(int fromInt) {
        this.fromInt = fromInt;
    }

    public int getToInt() {
        return toInt;
    }

    public void setToInt(int toInt) {
        this.toInt = toInt;
    }

    public Integer getNextCouponRate() {
        return nextCouponRate;
    }

    public void setNextCouponRate(Integer nextCouponRate) {
        this.nextCouponRate = nextCouponRate;
    }

    @Override
    public String toString() {
        return "DtoD{" +
                "id=" + id +
                ", fromInt=" + fromInt +
                ", toInt=" + toInt +
                ", nextCouponRate=" + nextCouponRate +
                '}';
    }
}
