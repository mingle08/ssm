package com.ssmstudy;

import com.ssmstudy.entity.iocDemo.IoCContainer;
import com.ssmstudy.entity.iocDemo.car.Audi;
import com.ssmstudy.entity.iocDemo.car.BMW;
import com.ssmstudy.entity.iocDemo.person.Monica;
import com.ssmstudy.entity.iocDemo.person.Person;
import com.ssmstudy.entity.iocDemo.person.Rachel;
import org.junit.Before;
import org.junit.Test;

public class IoCTest {

    private IoCContainer ioCContainer = new IoCContainer();

    @Before
    public void before() {
        ioCContainer.setBean(Audi.class, "audi");
        ioCContainer.setBean(BMW.class, "bmw");
        ioCContainer.setBean(Rachel.class, "rachel","audi");
        ioCContainer.setBean(Monica.class, "monica","bmw");
    }

    @Test
    public void test() {
        Person monica = (Person) ioCContainer.getBean("monica");
        monica.goHome();
        Person rachel = (Person) ioCContainer.getBean("rachel");
        rachel.goHome();

    }
}
