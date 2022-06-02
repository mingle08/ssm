package com.ssmstudy.designPattern.factoryPattern.dataAccess.abstractFactory;

import com.ssmstudy.designPattern.factoryPattern.dataAccess.AccessDepartmentServiceImpl;
import com.ssmstudy.designPattern.factoryPattern.dataAccess.AccessUserServiceImpl;
import com.ssmstudy.designPattern.factoryPattern.dataAccess.IDepartmentService;
import com.ssmstudy.designPattern.factoryPattern.dataAccess.IUserService;

public class AccessFactory implements IFactory {
    @Override
    public IUserService createUserService() {
        return new AccessUserServiceImpl();
    }

    // 增加了AccessDepartment工厂
    @Override
    public IDepartmentService createDepartmentService() {
        return new AccessDepartmentServiceImpl();
    }
}
