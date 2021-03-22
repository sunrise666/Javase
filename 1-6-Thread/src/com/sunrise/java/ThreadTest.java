package com.sunrise.java;/**
 * @author: pc
 * @data:2021/3/15
 */

import org.junit.Test;

/**
 *@ClassName: ThreadTest
 *@Description:TODO
 *@Author: pc
 *@Date: 2021/3/15 12:38
 *@Version: 1.0
 **/
public class ThreadTest {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        for (int i = 0; i < 100; i++) {
            System.out.println("主线程："+ i);
        }
    }

    @Test
    public void test1(){
        Runnable myThread1 = new MyThread1();
        Thread thread = new Thread(myThread1);
        thread.start();
        for (int i = 0; i < 100; i++) {
            System.out.println("主线程："+ i + Thread.currentThread());
        }
    }
}



