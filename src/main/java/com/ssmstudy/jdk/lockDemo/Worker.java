package com.ssmstudy.jdk.lockDemo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Worker implements Runnable {

    private CountDownLatch countDownLatch;

    public Worker(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + "正在赶路");
            // 模拟赶路
            TimeUnit.SECONDS.sleep(5);
            System.out.println(Thread.currentThread().getName() + " 已到达公司");
            countDownLatch.countDown();
            System.out.println(Thread.currentThread().getName() + " 开始工作");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
