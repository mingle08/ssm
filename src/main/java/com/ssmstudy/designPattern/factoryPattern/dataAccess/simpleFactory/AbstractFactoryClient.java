package com.ssmstudy.designPattern.factoryPattern.dataAccess.simpleFactory;

import com.ssmstudy.designPattern.factoryPattern.dataAccess.Department;
import com.ssmstudy.designPattern.factoryPattern.dataAccess.IDepartmentService;
import com.ssmstudy.designPattern.factoryPattern.dataAccess.IUserService;
import com.ssmstudy.designPattern.factoryPattern.dataAccess.User;

public class AbstractFactoryClient {
    public static void main(String[] args) {
        User user = new User();
        Department dept = new Department();

        IUserService iUserService = DataAccess.createUser();
        iUserService.insert(user);
        iUserService.getUser(1);

        IDepartmentService iDepartmentService = DataAccess.createDepartment();
        iDepartmentService.insert(dept);
        iDepartmentService.getDepartment(1);
    }
}
