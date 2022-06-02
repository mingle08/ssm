package com.ssmstudy.designPattern.factoryPattern.calculator.factoryMethod;

import com.ssmstudy.designPattern.factoryPattern.calculator.Operation;
import com.ssmstudy.designPattern.factoryPattern.calculator.OperationSub;

public class SubFactory implements IFactory {
    @Override
    public Operation createOperation() {
        return new OperationSub();
    }
}
