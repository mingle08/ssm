package com.ssmstudy.jdk.lockDemo;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Car implements Runnable {

    private Semaphore semaphore;

    public Car(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + "来到停车场");
            if (semaphore.availablePermits() == 0) {
                System.out.println("车位不足，请耐心等待");
            }
            semaphore.acquire();//获取令牌尝试进入停车场
            System.out.println(Thread.currentThread().getName() + "成功进入停车场");
            int nextInt = new Random().nextInt(100);
            TimeUnit.SECONDS.sleep(nextInt);//模拟车辆在停车场停留的时间
            // 日志显示分钟更真实
            System.out.println(Thread.currentThread().getName() + "在停车场停车" + nextInt + "分钟之后，驶出停车场");
            semaphore.release();//释放令牌，腾出停车场车位
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
