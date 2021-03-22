package com.sunrise.java;

/**
 * @author: pc
 * @data:2021/3/15
 */

public class MyThread1 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("子线程："+i + Thread.currentThread());
        }
    }
}
