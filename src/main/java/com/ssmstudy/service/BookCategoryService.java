package com.ssmstudy.service;

import com.ssmstudy.entity.BookCategory;

import java.util.List;

public interface BookCategoryService {
    // 方式1：嵌套查询
    List<BookCategory> selectAll1();
    BookCategory findCategoryWithBook1(Integer id);

    // 方式2：嵌套结果
    List<BookCategory> selectAll2();
    BookCategory findCategoryWithBook2(Integer id);
}
