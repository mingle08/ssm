package com.ssmstudy.designPattern.factoryPattern.dataAccess;

public class AccessDepartmentServiceImpl implements IDepartmentService {
    @Override
    public void insert(Department department) {
        System.out.println("在Access server中给Department表增加一条记录");
    }

    @Override
    public Department getDepartment(int id) {
        System.out.println("在Access server中根据ID得到Department表一条记录");
        return null;
    }
}
