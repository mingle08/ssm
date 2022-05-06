package com.ssmstudy.jdk.multiThreadPrint;

import java.util.concurrent.locks.LockSupport;

public class LockSupportPrintDemo {

    private static Thread t1;

    private static Thread t2;

    public static void main(String[] args) {
        final Object obj = new Object();
        char[] a1 = "1234567".toCharArray();
        char[] a2 = "ABCDEFG".toCharArray();

        t1 = new Thread(() -> {
            for (char c : a1) {
                System.out.print(c);
                LockSupport.unpark(t2);
                LockSupport.park();

            }

        }, "t1");

        t2 = new Thread(() -> {
            for (char c : a2) {
                System.out.print(c);
                LockSupport.unpark(t1);
                LockSupport.park();
            }

        }, "t2");

        t1.start();
        t2.start();
    }
}
