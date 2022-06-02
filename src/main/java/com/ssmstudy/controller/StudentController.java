package com.ssmstudy.controller;

import com.ssmstudy.entity.Student;
import com.ssmstudy.entity.StudentDTO;
import com.ssmstudy.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/list")
	public String selectAll(Model model){
		List<StudentDTO> StudentDTOList = studentService.selectAll();
		model.addAttribute(StudentDTOList);
		return "studentList";
	}

	@RequestMapping("/{id}")
	public String selectAll(@PathVariable Integer id, Model model){
		StudentDTO studentDTO = studentService.findStudentById(id);
		model.addAttribute(studentDTO);
		return "studentDetail";
	}



}
