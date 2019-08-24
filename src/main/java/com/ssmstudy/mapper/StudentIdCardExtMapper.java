package com.ssmstudy.mapper;

import com.ssmstudy.entity.StudentIdCard;

import java.util.List;

public interface StudentIdCardExtMapper {
    List<StudentIdCard> selectAll();
    StudentIdCard findStudentIdCardById(Integer id);
}