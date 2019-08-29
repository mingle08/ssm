package com.ssmstudy.entity.iocDemo.person;

import com.ssmstudy.entity.iocDemo.car.Car;

public class Joey implements Person {

//    private Car car = new Audi();

    private Car car;
    public Joey(Car car) {
        this.car = car;
    }

    @Override
    public void goHome() {
        car.start();
        car.turnRight();
        car.stop();
    }
}
