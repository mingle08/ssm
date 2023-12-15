package com.ssmstudy.mapstruct;

import lombok.Data;

@Data
public class DtoC {
    private int id;

    // time pattern  HH:mm
    private String fromTime;

    // time pattern  HH:mm
    private String toTime;

    private Integer nextCouponRate;

}
