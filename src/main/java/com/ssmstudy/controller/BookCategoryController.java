package com.ssmstudy.controller;

import com.ssmstudy.entity.BookCategory;
import com.ssmstudy.service.BookCategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST API controller for Book Category operations
 */
@RestController
@RequestMapping("/api/v1/book-categories")
public class BookCategoryController {

	private static final Logger log = LoggerFactory.getLogger(BookCategoryController.class);

	private final BookCategoryService bookCategoryService;

	public BookCategoryController(BookCategoryService bookCategoryService) {
		this.bookCategoryService = bookCategoryService;
	}

	@GetMapping
	public ResponseEntity<List<BookCategory>> listBookCategories() {
		log.info("Fetching all book categories using nested query");
		List<BookCategory> categories = bookCategoryService.selectAll1();
		return ResponseEntity.ok(categories);
	}

	@GetMapping("/{id}")
	public ResponseEntity<BookCategory> getBookCategory(@PathVariable Integer id) {
		log.info("Fetching book category with id: {}", id);
		BookCategory category = bookCategoryService.findCategoryWithBook1(id);
		return ResponseEntity.ok(category);
	}

	@GetMapping("/nested-result")
	public ResponseEntity<List<BookCategory>> listBookCategoriesNestedResult() {
		log.info("Fetching all book categories using nested result");
		List<BookCategory> categories = bookCategoryService.selectAll2();
		return ResponseEntity.ok(categories);
	}

	@GetMapping("/nested-result/{id}")
	public ResponseEntity<BookCategory> getBookCategoryNestedResult(@PathVariable Integer id) {
		log.info("Fetching book category using nested result, id: {}", id);
		BookCategory category = bookCategoryService.findCategoryWithBook2(id);
		return ResponseEntity.ok(category);
	}
}
