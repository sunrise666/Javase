package com.sunrise.exer;/**
 * @author: pc
 * @data:2021/3/15
 */
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 *@ClassName: ThreadPool
 *@Description:TODO
 *@Author: pc
 *@Date: 2021/3/15 14:47
 *@Version: 1.0
 **/
class MyThread2 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i %2 == 0){
                System.out.println(Thread.currentThread().getName() +":"+ i);
            }
        }
    }
}
public class ThreadPool {
    public static void main(String[] args) {
        // 1.调用Executors的newFixedThreadPool(),返回指定线程数量的ExecutorService
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        // 2.将Runnable实现类的对象作为形参传递给ExecutorService的submit()方法中，开启线程
        executorService.execute(new MyThread2());
        executorService.execute(new MyThread2());
        executorService.execute(new MyThread2());
        executorService.execute(new MyThread2());
        // 3.结束线程的使用
        executorService.shutdown();
    }
}
