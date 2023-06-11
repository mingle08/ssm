package com.ssmstudy.jdk;

import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.support.MergedBeanDefinitionPostProcessor;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;

public class InstanceofDemo {

    public static void main(String[] args) {
        CommonAnnotationBeanPostProcessor a = new CommonAnnotationBeanPostProcessor();
        System.out.println(a instanceof InstantiationAwareBeanPostProcessor);
        System.out.println(a instanceof MergedBeanDefinitionPostProcessor);
    }
}
