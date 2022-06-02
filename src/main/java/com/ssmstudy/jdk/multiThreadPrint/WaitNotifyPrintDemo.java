package com.ssmstudy.jdk.multiThreadPrint;

public class WaitNotifyPrintDemo {
    public static void main(String[] args) {
        final Object obj = new Object();
        char[] a1 = "1234567".toCharArray();
        char[] a2 = "ABCDEFG".toCharArray();

        new Thread(() -> {
            synchronized (obj) {
                for (char c : a1) {
                    System.out.print(c);
                    try {
                        obj.notify();
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 必须，否则进程不停止
                obj.notify();
            }
        }, "t1").start();

        new Thread(() -> {
            synchronized (obj) {
                for (char c : a2) {
                    System.out.print(c);
                    try {
                        obj.notify();
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 必须，否则进程不停止
                obj.notify();
            }
        }, "t2").start();
    }
}
