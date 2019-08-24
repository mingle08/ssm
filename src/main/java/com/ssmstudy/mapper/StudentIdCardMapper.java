package com.ssmstudy.mapper;

import com.ssmstudy.entity.StudentIdCard;

public interface StudentIdCardMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StudentIdCard record);

    int insertSelective(StudentIdCard record);

    StudentIdCard selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StudentIdCard record);

    int updateByPrimaryKey(StudentIdCard record);
}