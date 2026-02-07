package com.ssmstudy.service.impl;

import com.ssmstudy.entity.BookCategory;
import com.ssmstudy.mapper.BookCategoryMapper;
import com.ssmstudy.service.BookCategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

@Service("bookCategoryService")
@Transactional(readOnly = true)
public class BookCategoryServiceImpl implements BookCategoryService {

	private static final Logger log = LoggerFactory.getLogger(BookCategoryServiceImpl.class);

	private final BookCategoryMapper bookCategoryMapper;

	public BookCategoryServiceImpl(BookCategoryMapper bookCategoryMapper) {
		this.bookCategoryMapper = bookCategoryMapper;
	}

	@Override
	public List<BookCategory> selectAll1() {
		log.debug("Fetching all book categories using nested query");
		return bookCategoryMapper.selectAll1();
	}

	@Override
	public BookCategory findCategoryWithBook1(Integer id) {
		Assert.notNull(id, "Category ID cannot be null");
		log.debug("Fetching category with books using nested query, id: {}", id);
		return bookCategoryMapper.findCategoryWithBook1(id);
	}

	@Override
	public List<BookCategory> selectAll2() {
		log.debug("Fetching all book categories using nested result");
		return bookCategoryMapper.selectAll2();
	}

	@Override
	public BookCategory findCategoryWithBook2(Integer id) {
		Assert.notNull(id, "Category ID cannot be null");
		log.debug("Fetching category with books using nested result, id: {}", id);
		return bookCategoryMapper.findCategoryWithBook2(id);
	}

}
