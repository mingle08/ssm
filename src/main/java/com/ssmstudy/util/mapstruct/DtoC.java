package com.ssmstudy.util.mapstruct;

import javax.persistence.Transient;

import lombok.Data;

@Data
public class DtoC {
    @Transient
    private int id;

    // time pattern  HH:mm
    private String fromTime;

    // time pattern  HH:mm
    private String toTime;

    private Integer nextCouponRate;

}
