package com.sunrise.exer;/**
 * @author: pc
 * @data:2021/3/15
 */

/**
 *@ClassName: Producer
 *@Description:
 * 生产者消费者问题：生产者(Productor)将产品交给店员(Clerk)，而消费者(Customer)从店员处
 * 取走产品，店员一次只能持有固定数量的产品(比如:20），如果生产者试图生产更多的产品，店员会叫生产者停一下，
 * 如果店中有空位放产品了再通知生产者继续生产；如果店中没有产品了，店员会告诉消费者等一下，如果店中有产品了再通知消费者来取走产品。
 * 	这里可能出现两个问题：
 * 	生产者比消费者快时，消费者会漏掉一些数据没有取到。
 * 	消费者比生产者快时，消费者会取相同的数据。
 *@Author: pc
 *@Date: 2021/3/15 13:55
 *@Version: 1.0
 **/
public class ProduceTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Runnable productor = new Productor(clerk);
        Runnable customer = new Customer(clerk);

        Thread t1 = new Thread(productor);
        Thread t2 = new Thread(customer);
        t1.start();
        t2.start();
    }

}
class Productor implements Runnable{
    private Clerk clerk;

    public Productor(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println("生产者开始生产产品");
        while (true){
            try {
                Thread.sleep((int)Math.random()*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.addProduct();
        }
    }
}

class Customer implements Runnable{
    private Clerk clerk;

    public Customer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println("消费者开始消费产品");
    while (true){
        try {
            Thread.sleep((int)Math.random()*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clerk.getProduct();
    }
    }

}
class Clerk{
    private int product = 0;

    public synchronized void addProduct(){
        if(product >= 20){
            try {
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }else {
            product++;
            System.out.println("生产者生产第"+product+"个产品");
            notifyAll();
        }
    }

    public synchronized void getProduct(){
        if(product <= 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("消费者取走第"+product+"个产品");
            product--;
            notifyAll();

        }
    }
}
