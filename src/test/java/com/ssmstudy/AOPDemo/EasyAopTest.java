package com.ssmstudy.AOPDemo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ssmstudy.spring.AOP.EasyAop.*;
import com.ssmstudy.spring.lifecycleDemo.AlgoCalculator;
import com.ssmstudy.spring.lifecycleDemo.AopConfig;

public class EasyAopTest {
    @Test
    public void getProxy() throws Exception {
        // 1. 创建一个MethodInvocation 实现类
        MethodInvocation logTask = () -> System.out.println("log task start.");
        HelloServiceImpl helloServiceImpl = new HelloServiceImpl();

        // 2. 创建一个 advice
        Advice beforeAdvice = new BeforeAdvice(helloServiceImpl, logTask);

        // 3. 为目标生成代理
        HelloService helloServiceImplProxy = (HelloService) EasyAop.getProxy(helloServiceImpl, beforeAdvice);

        helloServiceImplProxy.sayHello();

    }
    ApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);

    @Test
    public void testAop() {
        System.out.println("ioc容器已创建完成");
        AlgoCalculator calculator = context.getBean(AlgoCalculator.class);
        calculator.div(100, 4);
    }
}
