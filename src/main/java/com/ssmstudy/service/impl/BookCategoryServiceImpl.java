package com.ssmstudy.service.impl;

import com.ssmstudy.entity.BookCategory;
import com.ssmstudy.mapper.BookCategoryMapper;
import com.ssmstudy.service.BookCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bookCategoryService")
public class BookCategoryServiceImpl implements BookCategoryService {

	@Autowired
	private BookCategoryMapper bookCategoryMapper;

	// 方式1：嵌套查询
	public List<BookCategory> selectAll1() {
		return bookCategoryMapper.selectAll1();
	}

	public BookCategory findCategoryWithBook1(Integer id) {

		return bookCategoryMapper.findCategoryWithBook1(id);
	}

	// 方式2：嵌套结果
	public List<BookCategory> selectAll2() {
		return bookCategoryMapper.selectAll2();
	}

	public BookCategory findCategoryWithBook2(Integer id) {

		return bookCategoryMapper.findCategoryWithBook2(id);
	}

}
