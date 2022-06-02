package com.ssmstudy.designPattern.factoryPattern.calculator.factoryMethod;

import com.ssmstudy.designPattern.factoryPattern.calculator.Operation;

public class FactoryMethodClient {

    public static void main(String[] args) {
        IFactory operFactory = new AddFactory();
        Operation oper = operFactory.createOperation();
        double res = oper.getResult(2, 3);
        System.out.println(res);
    }
}
