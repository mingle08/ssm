package com.ssmstudy.designPattern.factoryPattern.calculator.factoryMethod;

import com.ssmstudy.designPattern.factoryPattern.calculator.Operation;
import com.ssmstudy.designPattern.factoryPattern.calculator.OperationDiv;

public class DivFactory implements IFactory {
    @Override
    public Operation createOperation() {
        return new OperationDiv();
    }
}
