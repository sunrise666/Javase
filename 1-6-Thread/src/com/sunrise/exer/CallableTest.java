package com.sunrise.exer;/**
 * @author: pc
 * @data:2021/3/15
 */

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 *@ClassName: CallableTest
 *@Description:TODO
 *@Author: pc
 *@Date: 2021/3/15 14:33
 *@Version: 1.0
 **/
public class CallableTest {
    public static void main(String[] args) {
        Callable t1 = new MyThread();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(t1);
        new Thread(futureTask).start();

        try {
            Integer value = futureTask.get();
            System.out.println(value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class MyThread implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            if(i %2 == 0){
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}

