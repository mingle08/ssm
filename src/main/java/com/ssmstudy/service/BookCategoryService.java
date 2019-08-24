package com.ssmstudy.service;

import com.ssmstudy.entity.BookCategory;

import java.util.List;

public interface BookCategoryService {
    List<BookCategory> selectAll();
    BookCategory findCategoryWithBook(Integer id);
}
