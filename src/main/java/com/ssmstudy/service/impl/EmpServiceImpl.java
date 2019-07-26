package com.ssmstudy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssmstudy.entity.Emp;
import com.ssmstudy.mapper.EmpExtMapper;
import com.ssmstudy.service.EmpService;

@Service("empService")
public class EmpServiceImpl implements EmpService {

	@Autowired
	private EmpExtMapper empMapper;
	
	public List<Emp> selectAll() {
		
		return empMapper.selectAll();
	}

}
