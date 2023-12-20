package com.ssmstudy.util.mapstruct;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StructMapper {
    StructMapper INSTANCE = Mappers.getMapper(StructMapper.class);

    // convert A to B
    @Mapping(target = "fromInt", expression = "java(convertTimeStringToInt(dtoA.getFromTime()))")
    @Mapping(target = "toInt", expression = "java(convertTimeStringToInt(dtoA.getToTime()))")
    DtoB convert(DtoA dtoA);

    List<DtoB> convertList(List<DtoA> list);

    default int convertTimeStringToInt(String timeString) {
        return Integer.valueOf(timeString.replace(":", ""));
    }

    // convert C to D
    @Mapping(target = "fromInt", expression = "java(convertTimeToMinutes(dtoC.getFromTime()))")
    @Mapping(target = "toInt", expression = "java(convertTimeToMinutes(dtoC.getToTime()))")
    DtoD convertC2D(DtoC dtoC);

    List<DtoD> convertC2DList(List<DtoC> list);

    default int convertTimeToMinutes(String timeString) {
        String[] hm = timeString.split(":");

        return Integer.parseInt(hm[0]) * 60 + Integer.parseInt(hm[1]);
    }
}
