package com.ssmstudy.designPattern.factoryPattern.dataAccess.abstractFactory;

import com.ssmstudy.designPattern.factoryPattern.dataAccess.IDepartmentService;
import com.ssmstudy.designPattern.factoryPattern.dataAccess.IUserService;
import com.ssmstudy.designPattern.factoryPattern.dataAccess.SqlserverDepartmentServiceImpl;
import com.ssmstudy.designPattern.factoryPattern.dataAccess.SqlserverUserServiceImpl;

public class SqlserverFactory implements IFactory {
    @Override
    public IUserService createUserService() {
        return new SqlserverUserServiceImpl();
    }

    // 增加了SqlserverDepartment工厂
    @Override
    public IDepartmentService createDepartmentService() {
        return new SqlserverDepartmentServiceImpl();
    }
}
