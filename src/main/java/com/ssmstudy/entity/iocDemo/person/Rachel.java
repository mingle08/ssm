package com.ssmstudy.entity.iocDemo.person;

import com.ssmstudy.entity.iocDemo.car.Car;

public class Rachel extends PersonWithCar {
    public Rachel(Car car) {
        super(car);
    }

    @Override
    public void goHome() {
        car.start();
        car.turnLeft();
        car.stop();
    }
}
