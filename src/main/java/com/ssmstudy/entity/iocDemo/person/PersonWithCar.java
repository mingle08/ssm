package com.ssmstudy.entity.iocDemo.person;

import com.ssmstudy.entity.iocDemo.car.Car;

public abstract class PersonWithCar implements Person {

    protected Car car;
    public PersonWithCar(Car car) {
        this.car = car;
    }

    @Override
    public abstract void goHome() ;
}
