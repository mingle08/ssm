package com.ssmstudy.controller;

import com.ssmstudy.entity.BookCategory;
import com.ssmstudy.service.BookCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("bookCategory")
public class BookCategoryController {

	@Autowired
	private BookCategoryService BookCategoryService;
	
	@RequestMapping("/list")
	public String selectAll(Model model){
		List<BookCategory> BookCategoryList = BookCategoryService.selectAll();
		model.addAttribute(BookCategoryList);
		return "bookCategoryList";
	}

	@RequestMapping("/{id}")
	public String selectAll(@PathVariable Integer id, Model model){
		BookCategory BookCategory = BookCategoryService.findCategoryWithBook(id);
		model.addAttribute(BookCategory);
		return "bookCategoryDetail";
	}



}
