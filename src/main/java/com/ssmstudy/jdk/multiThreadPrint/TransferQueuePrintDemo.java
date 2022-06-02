package com.ssmstudy.jdk.multiThreadPrint;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

public class TransferQueuePrintDemo {

    public static void main(String[] args) {
        char[] a1 = "1234567".toCharArray();
        char[] a2 = "ABCDEFG".toCharArray();
        TransferQueue<Character> queue = new LinkedTransferQueue<>();
        new Thread(() -> {
            try{
                for(char c : a1){
                    System.out.print(queue.take());
                    queue.transfer(c);
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }, "t1").start();

        new Thread(() -> {
            try{
                for(char c : a2){
                    queue.transfer(c);
                    System.out.print(queue.take());
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }, "t2").start();
    }
}
