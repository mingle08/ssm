package com.ssmstudy.rmiTest;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServerTest {
    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("spring/RMIServer.xml");
    }
}
