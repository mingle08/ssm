package com.ssmstudy.IOCdemo;

import org.junit.Test;

import com.ssmstudy.spring.IOCdemo.Car;
import com.ssmstudy.spring.IOCdemo.EasyIOC;
import com.ssmstudy.spring.IOCdemo.Wheel;

public class EasyIOCTest {
    @Test
    public void getBean() throws Exception {
        /**
         *   URL.java中的getFile()方法返回的是file名称
         *  * @return  the file name of this {@code URL},
         *  * or an empty string if one does not exist
         *
         *  public String getFile () {
         *     return file;
         *  }
         */
        String location = EasyIOC.class.getClassLoader().getResource("ioc.xml").getFile();
        EasyIOC bf = new EasyIOC(location);
        Wheel wheel = (Wheel) bf.getBean("wheel");
        System.out.println("wheel brand: " + wheel.getBrand());
        Car car = (Car) bf.getBean("car");
        System.out.println("car name:" + car.getName());
    }
}
