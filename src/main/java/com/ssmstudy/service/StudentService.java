package com.ssmstudy.service;

import com.ssmstudy.entity.StudentDTO;

import java.util.List;

public interface StudentService {

	List<StudentDTO> selectAll();
	StudentDTO findStudentById(Integer id) ;
}
