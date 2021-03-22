package com.sunrise.exer;/**
 * @author: pc
 * @data:2021/3/15
 */

/**
 *@ClassName: bank
 *@Description:银行有一个账户。有两个储户分别向同一个账户存3000元，每次存1000，存3次。每次存完	打印账户余额。问题：该程序是否有安全问题，如果有，如何解决？
 *@Author: pc
 *@Date: 2021/3/15 13:25
 *@Version: 1.0
 **/
public class bank {
    public static void main(String[] args) {

        Account ac = new Account(0);
        Runnable p1 = new Person(ac);
        Runnable p2 = new Person(ac);
        Thread thread1 = new Thread(p1);
        Thread thread2 = new Thread(p2);
        thread1.start();
        thread2.start();
    }

}

class Person implements Runnable{
    private Account ac;

    public Person(Account ac) {
        this.ac = ac;
    }

    public Account getAc() {
        return ac;
    }

    public void setAc(Account ac) {
        this.ac = ac;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            ac.setBalance(1000);
        }
    }
}

class Account{
    int balance;

    public Account(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        synchronized(Account.class){
            System.out.println("账户"+Thread.currentThread()+"存入1000");
            this.balance += balance;
            print();
        }
    }

    public void print(){
        System.out.println("账户中存在："+balance);
    }
}
