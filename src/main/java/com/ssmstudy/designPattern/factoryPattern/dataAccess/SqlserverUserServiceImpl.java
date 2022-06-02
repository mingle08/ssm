package com.ssmstudy.designPattern.factoryPattern.dataAccess;

public class SqlserverUserServiceImpl implements IUserService {

    public void insert(User user) {
        System.out.println("在SQL Server中给User表增加一条记录");
    }

    public User getUser(int id) {
        System.out.println("在SQL Server中根据ID得到User表一条记录");
        return null;
    }
}
