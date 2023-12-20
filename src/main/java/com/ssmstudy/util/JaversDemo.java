package com.ssmstudy.util;

import java.util.List;

import org.javers.core.Javers;
import org.javers.core.JaversBuilder;
import org.javers.core.diff.Diff;
import org.javers.core.diff.changetype.ValueChange;

import com.ssmstudy.entity.Emp;

public class JaversDemo {

    public static void main(String[] args) {

        Javers javers = JaversBuilder.javers().build();
        
        Emp bfImg = new Emp();
        bfImg.setId(1);
        bfImg.setName("Rachel");
        bfImg.setSex("F");
        bfImg.setAge(26);
        bfImg.setAddress("Nanshan University Town");

        Emp afImg = new Emp();
        afImg.setId(1);
        afImg.setName("Monica");
        afImg.setSex("F");
        afImg.setAge(27);
        afImg.setAddress(null);
        afImg.setEmail("rachel@gmail.com");

        Diff diff = javers.compare(bfImg, afImg);
        List<ValueChange> changes = diff.getChangesByType(ValueChange.class);

        System.out.println(changes.size());

        for (ValueChange valueChange : changes) {
            System.out.print(valueChange.getLeft());
            System.out.print(" <- " + valueChange.getPropertyName() + " -> ");
            System.out.println(valueChange.getRight());
        }
    }

    

}
