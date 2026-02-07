package com.ssmstudy.util.mapstruct;

public class DtoB {
    private int id;

    // HHmm
    private int fromInt;

    // HHmm
    private int toInt;
   
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

    @Override
    public String toString() {
        return "DtoB{" +
                "id=" + id +
                ", fromInt=" + fromInt +
                ", toInt=" + toInt +
                '}';
    }
}
