package com.ssmstudy.mapper;

import com.ssmstudy.entity.Student;

import java.util.List;

public interface StudentExtMapper extends StudentMapper {
    List<Student> selectAll();
    Student findStudentById(Integer id);
}