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
	private EmpExtMapper empExtMapper;
	
	public List<Emp> selectAll() {
		
		return empExtMapper.selectAll();
	}
	public void insert(Emp emp) {

		empExtMapper.insert(emp);
	}

	@Override
	public void insertReturnKey(Emp emp) {
		empExtMapper.insertReturnKey(emp);
		// 插入操作完成之后，不需要再查询，直接能得到id值
		System.out.println("回填的主键id= " + emp.getId());
	}

}
