package com.ssmstudy.mapstruct;

import java.util.ArrayList;
import java.util.List;

public class DemoTest {
    public static void main(String[] args) {
        List<DemoDtoA> list1 = new ArrayList<>();
        DemoDtoA o1 = new DemoDtoA();
        o1.setId(0);
        o1.setFromTime("09:13");
        o1.setToTime("10:11");
        list1.add(o1);

        DemoDtoA o2 = new DemoDtoA();
        o2.setId(1);
        o2.setFromTime("12:22");
        o2.setToTime("14:22");
        list1.add(o2);

        List<DemoDtoB> list2 = StructMapper.INSTANCE.convertList(list1);

        for (DemoDtoB demoDtoB : list2) {
            System.out.println("demoDtoB: fromInt=" + demoDtoB.getFromInt() + ", toInt=" + demoDtoB.getToInt());
        }
    }
}
