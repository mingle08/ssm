package com.ssmstudy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssmstudy.entity.Emp;
import com.ssmstudy.service.EmpService;

@Controller
@RequestMapping("emp")
public class EmpController {

	@Autowired
	private EmpService empService;
	
	@RequestMapping("/list")
	public String selectAll(Model model){
		List<Emp> empList = empService.selectAll();
		model.addAttribute(empList);
		return "list";
	}
	
	@RequestMapping("/add")
	public String add(Model model){
		return "add";
	}
	
	@RequestMapping("/doAdd")
	public String doAdd(Emp emp){
		empService.insert(emp);
		System.out.println("添加成功！");
		return "redirect:list";
	}
	
	
}
