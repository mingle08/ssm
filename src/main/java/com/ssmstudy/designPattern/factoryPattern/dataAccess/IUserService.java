package com.ssmstudy.designPattern.factoryPattern.dataAccess;

public interface IUserService {
    void insert(User user);
    User getUser(int id);
}
