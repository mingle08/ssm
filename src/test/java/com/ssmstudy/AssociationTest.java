package com.ssmstudy;

import com.ssmstudy.mapper.StudentExtMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class AssociationTest {
    private StudentExtMapper studentExtMapper = null;

    @Test
    public void testGetStudent(){
        String xmlPath = "classpath:spring/spring-context.xml";
        ApplicationContext ac = new FileSystemXmlApplicationContext(xmlPath);
        studentExtMapper = ac.getBean(StudentExtMapper.class);
        System.out.println(studentExtMapper.findStudentById(1));
    }

}
