package com.ssmstudy.designPattern.factoryPattern.dataAccess;

public interface IDepartmentService {
    void insert(Department department);
    Department getDepartment(int id);
}
