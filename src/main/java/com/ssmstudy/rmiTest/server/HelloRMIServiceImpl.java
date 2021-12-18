package com.ssmstudy.rmiTest.server;

public class HelloRMIServiceImpl implements HelloRMIService {
    @Override
    public int getAdd(int a, int b) {
        return a + b;
    }
}
