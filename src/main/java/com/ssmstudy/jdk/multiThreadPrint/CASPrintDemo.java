package com.ssmstudy.jdk.multiThreadPrint;

public class CASPrintDemo {

    enum ReadyToRun {
        THREAD_1, THREAD_2
    }
    private static volatile ReadyToRun readyToRun = ReadyToRun.THREAD_1;

    public static void main(String[] args) {
        char[] a1 = "1234567".toCharArray();
        char[] a2 = "ABCDEFG".toCharArray();

        new Thread(() -> {
            for (char c : a1) {
                while (readyToRun != ReadyToRun.THREAD_1){}//cas自旋
                System.out.print(c);
                readyToRun = ReadyToRun.THREAD_2;//线程可见性
            }
        }, "t1").start();

        new Thread(() -> {
            for (char c : a2) {
                while (readyToRun != ReadyToRun.THREAD_2){}//cas自旋
                System.out.print(c);
                readyToRun = ReadyToRun.THREAD_1;//线程可见性
            }
        }, "t2").start();
    }
}
