package com.ssmstudy.jdk.lockDemo;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

    private static final Integer THREAD_NUM = 11;

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(THREAD_NUM, () -> System.out.println(Thread.currentThread().getName() + " 宣布：所有人都到齐了，开始训练"));

        for (int i = 0; i < THREAD_NUM; i++) {
            new Thread(new FootballPlayer(cyclicBarrier), "A" + i).start();
        }
    }
}
