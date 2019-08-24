package com.ssmstudy.service;

import com.ssmstudy.entity.Student;

import java.util.List;

public interface StudentService {

	List<Student> selectAll();
	Student findStudentById(Integer id) ;
}
