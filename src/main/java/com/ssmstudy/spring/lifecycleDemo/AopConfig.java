package com.ssmstudy.spring.lifecycleDemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 参考博客： https://blog.csdn.net/xueping_wu/article/details/123940261
 */
@EnableAspectJAutoProxy
@Configuration
public class AopConfig {

    @Bean
    public AlgoCalculator createCalculator() {
        return new AlgoCalculator();
    }

    @Bean
    public LogAspect createLogAspect() {
        return new LogAspect();
    }
}
