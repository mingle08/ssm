package com.ssmstudy.designPattern.factoryPattern.dataAccess.simpleFactory;

import com.ssmstudy.designPattern.factoryPattern.dataAccess.AccessUserServiceImpl;
import com.ssmstudy.designPattern.factoryPattern.dataAccess.IDepartmentService;
import com.ssmstudy.designPattern.factoryPattern.dataAccess.IUserService;
import com.ssmstudy.designPattern.factoryPattern.dataAccess.SqlserverUserServiceImpl;
import com.ssmstudy.designPattern.factoryPattern.dataAccess.AccessDepartmentServiceImpl;
import com.ssmstudy.designPattern.factoryPattern.dataAccess.SqlserverDepartmentServiceImpl;

public class DataAccess {
    private static final String db = "Sqlserver";
//    private static final String db = "Access";
    public static IUserService createUser() {
        IUserService result = null;
        switch (db) {
            case "Sqlserver":
                result = new SqlserverUserServiceImpl();
                break;
            case "Access":
                result = new AccessUserServiceImpl();
                break;
        }
        return result;
    }

    public static IDepartmentService createDepartment() {
        IDepartmentService result = null;
        switch (db) {
            case "Sqlserver":
                result = new SqlserverDepartmentServiceImpl();
                break;
            case "Access":
                result = new AccessDepartmentServiceImpl();
                break;
        }
        return result;
    }
}
