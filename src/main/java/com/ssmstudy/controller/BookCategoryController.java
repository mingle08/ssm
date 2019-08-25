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
	    // 方式1：嵌套查询
        List<BookCategory> bookCategoryList = BookCategoryService.selectAll1();

        // 方式2：嵌套结果
//		List<BookCategory> bookCategoryList = BookCategoryService.selectAll2();

		model.addAttribute(bookCategoryList);
		for (BookCategory bookCategory : bookCategoryList) {
			System.out.println(bookCategory);
		}
		return "bookCategoryList";
	}

	@RequestMapping("/{id}")
	public String selectAll(@PathVariable Integer id, Model model){
	    // 方式1：嵌套查询
        BookCategory BookCategory = BookCategoryService.findCategoryWithBook1(id);

        // 方式2：嵌套结果
//		BookCategory BookCategory = BookCategoryService.findCategoryWithBook2(id);

		model.addAttribute(BookCategory);
		return "bookCategoryDetail";
	}



}
