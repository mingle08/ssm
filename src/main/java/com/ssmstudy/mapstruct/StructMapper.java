package com.ssmstudy.mapstruct;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StructMapper {
    StructMapper INSTANCE = Mappers.getMapper(StructMapper.class);

    @Mapping(target = "fromInt", expression = "java(convertTimeStringToInt(dto1.getFromTime()))")
    @Mapping(target = "toInt", expression = "java(convertTimeStringToInt(dto1.getToTime()))")
    DemoDtoB convert(DemoDtoA dto1);

    List<DemoDtoB> convertList(List<DemoDtoA> list);

    default int convertTimeStringToInt(String timeString) {
        return Integer.valueOf(timeString.replace(":", ""));
    }
}
