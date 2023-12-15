package com.ssmstudy.mapstruct;

import java.util.ArrayList;
import java.util.List;

public class DemoTest {
    public static void main(String[] args) {
        // A to B
        List<DtoA> list1 = new ArrayList<>();
        DtoA a1 = new DtoA();
        a1.setId(0);
        a1.setFromTime("09:13");
        a1.setToTime("10:11");
        list1.add(a1);

        DtoA a2 = new DtoA();
        a2.setId(1);
        a2.setFromTime("12:22");
        a2.setToTime("14:22");
        list1.add(a2);

        List<DtoB> list2 = StructMapper.INSTANCE.convertList(list1);

        for (DtoB demoDtoB : list2) {
            System.out.println("demoDtoB: fromInt=" + demoDtoB.getFromInt() + ", toInt=" + demoDtoB.getToInt());
        }

        // C to D
        List<DtoC> listC = new ArrayList<>();
        DtoC c1 = new DtoC();
        c1.setId(2);
        c1.setFromTime("09:13");
        c1.setToTime("10:11");
        c1.setNextCouponRate(20);
        listC.add(c1);

        DtoC c2 = new DtoC();
        c2.setId(3);
        c2.setFromTime("12:22");
        c2.setToTime("14:22");
        c2.setNextCouponRate(30);
        listC.add(c2);

        List<DtoD> listD = StructMapper.INSTANCE.convertC2DList(listC);

        for (DtoD demoDtoD : listD) {
            System.out.println("demoDtoD: fromInt=" + demoDtoD.getFromInt() + 
            ", toInt=" + demoDtoD.getToInt() + ", nextCouponRate=" + demoDtoD.getNextCouponRate());
        }
    }
}
