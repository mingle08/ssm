package com.ssmstudy.spring.IOCdemo.dao.impl;

import com.ssmstudy.spring.IOCdemo.dao.UserDao;

public class UserDaoSqlserverImpl implements UserDao {
    @Override
    public void getUser() {
        System.out.println("sqlserver get user info");
    }
}
