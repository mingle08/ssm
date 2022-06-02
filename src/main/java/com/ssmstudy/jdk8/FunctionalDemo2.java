package com.ssmstudy.jdk8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class FunctionalDemo2 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 2, 3, 5, 7, 9, 11, 13);

        // 断言
        /*Predicate<Integer> predicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer i) {
                return i > 10;
            }
        };*/

//        list.removeIf(predicate);
        list.removeIf(x -> x > 10);
        /**
         * 打印结果是  [2,3,5,7,9]
         * 打印结果不是地址值，那一定是list在哪里重写了toString方法
         *
         * 最终在AbstractCollection发现了toString()
         */
        System.out.println(list);
    }
}
