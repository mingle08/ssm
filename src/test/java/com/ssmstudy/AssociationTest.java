package com.ssmstudy;

import com.ssmstudy.mapper.StudentExtMapper;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class AssociationTest {
    private StudentExtMapper studentExtMapper = null;

    @Test
    public void testGetStudent(){
        String xmlPath = "classpath:spring/spring-mybatis.xml";
//        BeanFactory factory = new XmlBeanFactory(new ClassPathResource(xmlPath));
        ApplicationContext factory = new ClassPathXmlApplicationContext(xmlPath);
        studentExtMapper = (StudentExtMapper) factory.getBean("student");
        System.out.println(studentExtMapper.findStudentById(1));
    }

}
