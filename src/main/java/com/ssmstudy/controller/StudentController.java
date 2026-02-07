package com.ssmstudy.controller;

import com.ssmstudy.entity.StudentDTO;
import com.ssmstudy.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST API controller for Student operations
 */
@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

	private static final Logger log = LoggerFactory.getLogger(StudentController.class);

	private final StudentService studentService;

	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	@GetMapping
	public ResponseEntity<List<StudentDTO>> listStudents() {
		log.info("Fetching all students");
		List<StudentDTO> students = studentService.selectAll();
		return ResponseEntity.ok(students);
	}

	@GetMapping("/{id}")
	public ResponseEntity<StudentDTO> getStudent(@PathVariable Integer id) {
		log.info("Fetching student with id: {}", id);
		StudentDTO student = studentService.findStudentById(id);
		return ResponseEntity.ok(student);
	}
}
