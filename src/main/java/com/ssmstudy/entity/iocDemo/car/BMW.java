package com.ssmstudy.entity.iocDemo.car;

public class BMW implements Car {
    @Override
    public void start() {
        System.out.println("BMW start.");
    }

    @Override
    public void turnLeft() {
        System.out.println("BMW turnLeft.");
    }

    @Override
    public void turnRight() {
        System.out.println("BMW turnRight.");
    }

    @Override
    public void stop() {
        System.out.println("BMW stop.");
    }
}
