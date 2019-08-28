package com.ssmstudy.service;

import java.util.List;

import com.ssmstudy.entity.Emp;

public interface EmpService {

	List<Emp> selectAll();
	void insert(Emp emp) ;
	void insertReturnKey(Emp emp);
}
