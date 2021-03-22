package com.sunrise.java;

/**
 * @author: pc
 * @data:2021/3/15
 */

public class MyThread extends Thread {

    public MyThread() {
        super();
    }

    @Override
    public void run(){
        for (int i = 0; i < 100; i++) {
            System.out.println("子线程:"+i);
        }
    }
}

