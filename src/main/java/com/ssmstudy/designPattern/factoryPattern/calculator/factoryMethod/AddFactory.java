package com.ssmstudy.designPattern.factoryPattern.calculator.factoryMethod;

import com.ssmstudy.designPattern.factoryPattern.calculator.Operation;
import com.ssmstudy.designPattern.factoryPattern.calculator.OperationAdd;

public class AddFactory implements IFactory {
    @Override
    public Operation createOperation() {
        return new OperationAdd();
    }
}
