package com.ssmstudy.spring.lifecycleDemo;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * 参考博客： https://blog.csdn.net/xueping_wu/article/details/123940261
 */
@Aspect
public class LogAspect {
    // 抽取公共的切入点表达式
    // 1、本类引用
    // 2、其他的切面引用
    @Pointcut("execution(public int com.ssmstudy.spring.lifecycleDemo.AlgoCalculator.*(..))")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void logBegin(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        System.out.println("日志切面工具，前置通知方法@Before运行：　" + joinPoint.getSignature().getName() + "方法运行前，参数列表是：" + Arrays.asList(args));
    }

    @After("pointCut()")
    public void logEnd(JoinPoint joinPoint) {
        System.out.println("日志切面工具，后置通知方法@After运行：　" + joinPoint.getSignature().getName() + "方法运行结束");
    }

    @AfterReturning(value = "pointCut()", returning = "result")
    public void logReturn(JoinPoint joinPoint, Object result) {
        System.out.println("日志切面工具，返回通知方法@AfterReturning运行：　" + joinPoint.getSignature().getName() + "方法运行成功，返回结果是：　" + result);
    }

    @AfterThrowing(value = "pointCut()", throwing = "exception")
    public void logException(JoinPoint joinPoint, Exception exception) {
        System.out.println("日志切面工具，异常通知方法@AfterThrowing运行：　" + joinPoint.getSignature().getName() + "方法运行异常，异常消息是：　" + exception);
    }
}
