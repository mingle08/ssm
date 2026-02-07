package com.ssmstudy.service.impl;

import com.ssmstudy.entity.StudentDTO;
import com.ssmstudy.mapper.StudentExtMapper;
import com.ssmstudy.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

@Service("studentService")
@Transactional(readOnly = true)
public class StudentServiceImpl implements StudentService {

	private static final Logger log = LoggerFactory.getLogger(StudentServiceImpl.class);

	private final StudentExtMapper studentExtMapper;

	public StudentServiceImpl(StudentExtMapper studentExtMapper) {
		this.studentExtMapper = studentExtMapper;
	}

	@Override
	public List<StudentDTO> selectAll() {
		log.debug("Fetching all students");
		return studentExtMapper.selectAll();
	}

	@Override
	public StudentDTO findStudentById(Integer id) {
		Assert.notNull(id, "Student ID cannot be null");
		log.debug("Fetching student with id: {}", id);
		return studentExtMapper.findStudentById(id);
	}

}
