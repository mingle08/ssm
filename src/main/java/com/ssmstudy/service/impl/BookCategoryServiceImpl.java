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

	public List<BookCategory> selectAll() {
		return bookCategoryMapper.selectAll();
	}

	public BookCategory findCategoryWithBook(Integer id) {

		return bookCategoryMapper.findCategoryWithBook(id);
	}

}
