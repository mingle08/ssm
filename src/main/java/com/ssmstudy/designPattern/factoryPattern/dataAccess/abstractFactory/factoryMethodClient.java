package com.ssmstudy.designPattern.factoryPattern.dataAccess.abstractFactory;

import com.ssmstudy.designPattern.factoryPattern.dataAccess.Department;
import com.ssmstudy.designPattern.factoryPattern.dataAccess.IDepartmentService;
import com.ssmstudy.designPattern.factoryPattern.dataAccess.IUserService;
import com.ssmstudy.designPattern.factoryPattern.dataAccess.User;

public class factoryMethodClient {

    public static void main(String[] args) {
        User user = new User();
        Department department = new Department();

        // 只需确定实例化哪一个数据库访问对象给factory
//        IFactory factory = new SqlserverFactory();
        IFactory factory = new AccessFactory();

        // 则此时已与具体的数据库访问解除了依赖
        IUserService iUserService = factory.createUserService();
        iUserService.insert(user);
        iUserService.getUser(1);

        // 则此时已与具体的数据库访问解除了依赖
        IDepartmentService iDepartmentService = factory.createDepartmentService();
        iDepartmentService.insert(department);
        iDepartmentService.getDepartment(1);
    }

}
