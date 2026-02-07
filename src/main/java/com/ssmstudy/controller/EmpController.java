package com.ssmstudy.controller;

import com.ssmstudy.entity.Emp;
import com.ssmstudy.service.EmpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST API controller for Employee operations
 */
@RestController
@RequestMapping("/api/v1/employees")
public class EmpController {

	private static final Logger log = LoggerFactory.getLogger(EmpController.class);

	private final EmpService empService;

	public EmpController(EmpService empService) {
		this.empService = empService;
	}

	@GetMapping
	public ResponseEntity<List<Emp>> listEmployees() {
		log.info("Fetching all employees");
		List<Emp> employees = empService.selectAll();
		return ResponseEntity.ok(employees);
	}

	@PostMapping
	public ResponseEntity<Void> createEmployee(@RequestBody Emp emp) {
		log.info("Creating new employee: {}", emp);
		empService.insert(emp);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}
