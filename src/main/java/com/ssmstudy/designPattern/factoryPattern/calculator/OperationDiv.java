package com.ssmstudy.designPattern.factoryPattern.calculator;

public class OperationDiv implements Operation {
    @Override
    public double getResult(double a, double b) {
        return a / b;
    }
}
