package com.ssmstudy.spring.IOCdemo.dao.impl;

import com.ssmstudy.spring.IOCdemo.dao.UserDao;

public class UserDaoOracleImpl implements UserDao {
    @Override
    public void getUser() {
        System.out.println("oracle get user info");
    }
}
