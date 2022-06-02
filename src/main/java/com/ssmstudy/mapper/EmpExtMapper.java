package com.ssmstudy.mapper;

import java.util.List;

import com.ssmstudy.entity.Emp;

public interface EmpExtMapper extends EmpMapper {

	List<Emp> selectAll();
}
