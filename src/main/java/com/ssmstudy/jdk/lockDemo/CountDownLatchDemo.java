package com.ssmstudy.jdk.lockDemo;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

    private static final Integer THREAD_NUM = 11;

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(THREAD_NUM);

        for (int i = 0; i < THREAD_NUM; i++) {
            new Thread(new Worker(countDownLatch), "B" + i).start();
        }

        try {
            System.out.println("门卫"+Thread.currentThread().getName()+"等待员工上班中。。。");
            countDownLatch.await();//阻塞当前线程，直到计数器的值为0
            System.out.println("门卫"+Thread.currentThread().getName()+"看到员工到齐了，休息去了");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
