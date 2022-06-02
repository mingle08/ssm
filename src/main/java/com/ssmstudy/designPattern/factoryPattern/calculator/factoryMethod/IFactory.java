package com.ssmstudy.designPattern.factoryPattern.calculator.factoryMethod;

import com.ssmstudy.designPattern.factoryPattern.calculator.Operation;

public interface IFactory {
    Operation createOperation();
}
