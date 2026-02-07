package com.ssmstudy.service.impl;

import com.ssmstudy.entity.Emp;
import com.ssmstudy.mapper.EmpExtMapper;
import com.ssmstudy.service.EmpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

@Service("empService")
@Transactional(readOnly = true)
public class EmpServiceImpl implements EmpService {

	private static final Logger log = LoggerFactory.getLogger(EmpServiceImpl.class);

	private final EmpExtMapper empMapper;

	public EmpServiceImpl(EmpExtMapper empMapper) {
		this.empMapper = empMapper;
	}

	@Override
	public List<Emp> selectAll() {
		log.debug("Fetching all employees");
		return empMapper.selectAll();
	}

	@Override
	@Transactional
	public void insert(Emp emp) {
		Assert.notNull(emp, "Employee cannot be null");
		log.debug("Inserting employee: {}", emp);
		empMapper.insert(emp);
	}

}
