package com.ssmstudy.mapper;

import com.ssmstudy.entity.StudentDTO;

import java.util.List;

public interface StudentExtMapper extends StudentMapper {
    List<StudentDTO> selectAll();
    StudentDTO findStudentById(Integer id);
}