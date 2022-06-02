package com.ssmstudy.mapper;

import com.ssmstudy.entity.Book;
import org.apache.ibatis.annotations.Param;

public interface BookMapper {
    Book selectBookForCategory(Integer id);
}
