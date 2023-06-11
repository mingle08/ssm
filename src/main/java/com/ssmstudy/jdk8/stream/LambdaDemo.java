package com.ssmstudy.jdk8.stream;

import java.util.Arrays;
import java.util.List;

/**
 * stream()方法 在 Collection 接口中
 * <p>
 * // Since: 1.8
 * default Stream<E> stream() {
 * return StreamSupport.stream(spliterator(), false);
 * }
 * <p>
 * // @since 1.8
 * default Stream<E> parallelStream(){
 * return StreamSupport.stream(spliterator(),true);
 * }
 */
public class LambdaDemo {

    static int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    public static void main(String[] args) {
        Person ross = new Person(1, "Ross", 26);
        Person mark = new Person(2, "mark", 23);
        Person chandler = new Person(3, "chandler", 24);
        Person joey = new Person(4, "joey", 25);
        Person rachel = new Person(5, "rachel", 22);

        List<Person> list = Arrays.asList(ross, mark, chandler, joey, rachel);
        list.stream()
                .filter(u -> {
                    return u.getId() % 2 == 0;
                })
                .filter(u -> {
                    return u.getAge() > 24;
                })
                .map(u -> {
                    return u.getName().toUpperCase();
                })
                .sorted()
                .forEach(System.out::println);

        // 输出 2 3 4 5 6 7 8 9 10 11
        Arrays.stream(arr).map((x) -> x = x + 1).forEach(System.out::println);
        System.out.println();
        // 输出 1 2 3 4 5 6 7 8 9 10，即原数组并没有改变
        Arrays.stream(arr).forEach(System.out::println);

        // 输出 2 2 4 4 6 6 8 8 10 10
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                arr[i]++;
            }
            System.out.println(arr[i]);
        }
        // 输出 2 2 4 4 6 6 8 8 10 10
        Arrays.stream(arr).map(x -> (x % 2 == 0 ? x : x + 1)).forEach(System.out::println);
    }


}
