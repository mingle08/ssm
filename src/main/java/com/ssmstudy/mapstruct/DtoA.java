package com.ssmstudy.mapstruct;

public class DtoA {
    private int id;

    // time pattern  HH:mm
    private String fromTime;

    // time pattern  HH:mm
    private String toTime;

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

    
}
