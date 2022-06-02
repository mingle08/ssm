package com.ssmstudy.designPattern.factoryPattern.dataAccess.abstractFactory;

import com.ssmstudy.designPattern.factoryPattern.dataAccess.IDepartmentService;
import com.ssmstudy.designPattern.factoryPattern.dataAccess.IUserService;

/**
 * 抽象工厂模式（Abstract Factory），提供一个创建一系列相关或相互依赖对象的接口，而无需指定它们具体的类。
 */
public interface IFactory {
    IUserService createUserService();

    // 增加的接口方法
    IDepartmentService createDepartmentService();
}
