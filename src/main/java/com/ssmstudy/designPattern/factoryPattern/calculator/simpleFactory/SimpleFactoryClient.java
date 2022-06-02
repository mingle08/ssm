package com.ssmstudy.designPattern.factoryPattern.calculator.simpleFactory;

import com.ssmstudy.designPattern.factoryPattern.calculator.Operation;

public class SimpleFactoryClient {

    public static void main(String[] args) {
        Operation oper = OperationFactory.createOperate("+");
        double res = oper.getResult(2, 3);
        System.out.println(res);
    }
}
