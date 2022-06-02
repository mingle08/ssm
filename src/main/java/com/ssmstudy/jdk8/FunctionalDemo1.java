package com.ssmstudy.jdk8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class FunctionalDemo1 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 2, 3, 5, 7, 9, 11, 13);

        // 遍历1
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println("-------------函数式接口-------------");
        // 遍历2
        Consumer<Integer> con1 = new Consumer<Integer>() {

            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        };
        list.forEach(con1);

        System.out.println("-------------函数式接口升级1-------------");
        // 遍历3
        Consumer<Integer> con2 = (integer) -> System.out.println(integer);
        list.forEach(con2);

        System.out.println("-------------函数式接口升级2-------------");
        list.forEach((n)-> System.out.println(n));
    }
}
