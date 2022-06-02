package com.ssmstudy.designPattern.factoryPattern.dataAccess;

public class AccessUserServiceImpl implements IUserService {
    @Override
    public void insert(User user) {
        System.out.println("在Access Server中给User表增加一条记录");
    }

    @Override
    public User getUser(int id) {
        System.out.println("在Access Server中根据ID得到User表一条记录");
        return null;
    }
}
