package com.ssmstudy.spring.IOCdemo.dao.impl;

import com.ssmstudy.spring.IOCdemo.dao.UserDao;

public class UserDaoImpl implements UserDao {
    @Override
    public void getUser() {
        System.out.println("default get user info");
    }
}
