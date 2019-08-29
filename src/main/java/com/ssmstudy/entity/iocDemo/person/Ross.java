package com.ssmstudy.entity.iocDemo.person;

import com.ssmstudy.entity.iocDemo.car.Car;

public class Ross implements Person {

//    private Car car = new BMW();
    private Car car;

    public Ross(Car car) {
        this.car = car;
    }

    @Override
    public void goHome() {
        car.start();
        car.turnLeft();
        car.turnRight();
        car.stop();
    }
}
