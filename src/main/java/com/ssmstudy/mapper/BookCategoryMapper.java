package com.ssmstudy.mapper;

import com.ssmstudy.entity.BookCategory;

import java.util.List;

public interface BookCategoryMapper {
    List<BookCategory> selectAll();
    BookCategory findCategoryWithBook(Integer id);
}
