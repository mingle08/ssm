package com.ssmstudy.jdk.lockDemo;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {

    //停车场同时容纳的车辆10
    private static Semaphore semaphore = new Semaphore(10);

    public static void main(String[] args) {
        //模拟50辆车进入停车场
        for (int i = 0; i < 50; i++) {
            new Thread(new Car(semaphore), i + "号车").start();
        }

    }
}
