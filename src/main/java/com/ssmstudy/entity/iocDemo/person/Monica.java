package com.ssmstudy.entity.iocDemo.person;

import com.ssmstudy.entity.iocDemo.car.Car;

public class Monica extends PersonWithCar {
    public Monica(Car car) {
        super(car);
    }

    @Override
    public void goHome() {
        car.start();
        car.turnRight();
        car.stop();
    }
}
