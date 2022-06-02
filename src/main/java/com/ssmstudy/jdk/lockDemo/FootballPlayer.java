package com.ssmstudy.jdk.lockDemo;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class FootballPlayer implements Runnable {
    // 循环栅栏
    private CyclicBarrier cyclicBarrier;

    public FootballPlayer(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " 正在等待其他人到来");
        try {
            cyclicBarrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + " 开始训练");

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + " 训练完毕");
    }
}
