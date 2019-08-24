package com.ssmstudy.service.impl;

import com.ssmstudy.entity.Student;
import com.ssmstudy.mapper.StudentExtMapper;
import com.ssmstudy.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentExtMapper studentExtMapper;
	
	public List<Student> selectAll() {
		
		return studentExtMapper.selectAll();
	}
	public Student findStudentById(Integer id) {

		return studentExtMapper.findStudentById(id);
	}

}
