package com.ssmstudy.rmiTest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssmstudy.rmiTest.server.HelloRMIService;

public class ClientTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/RMIClient.xml");
        HelloRMIService hms = context.getBean("myClient", HelloRMIService.class);
        System.out.println(hms.getAdd(2,3));
    }
}
