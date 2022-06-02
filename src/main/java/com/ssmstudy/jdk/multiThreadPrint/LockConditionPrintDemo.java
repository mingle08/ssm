package com.ssmstudy.jdk.multiThreadPrint;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class LockConditionPrintDemo {

    private static Thread t1;

    private static Thread t2;

    public static void main(String[] args) {
        final Object obj = new Object();
        char[] a1 = "1234567".toCharArray();
        char[] a2 = "ABCDEFG".toCharArray();
        Lock lock = new ReentrantLock();  //锁
        Condition cond1 = lock.newCondition();  //cond1队列
        Condition cond2 = lock.newCondition();  //cond2队列

        new Thread(() -> {
            try {
                lock.lock();
                for (char c : a1) {
                    System.out.print(c);
                    cond2.signal();
                    cond1.await();
                }
                cond1.signal();
                cond2.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "t1").start();

        new Thread(() -> {
            try {
                lock.lock();
                for (char c : a2) {
                    System.out.print(c);
                    cond1.signal();
                    cond2.await();
                }
                cond2.signal();
                cond1.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "t2").start();
    }
}
