package com.ssmstudy.spring.IOCdemo.service;

import com.ssmstudy.spring.IOCdemo.dao.UserDao;

public interface UserService {
    void getUser();
    void setUserDao(UserDao userDao);
}
