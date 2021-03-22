package com.sunrise.java;/**
 * @author: pc
 * @data:2021/3/22
 */

/**
 *@ClassName: ProxyTest
 *@Description:动态代理举例
 *@Author: pc
 *@Date: 2021/3/22 10:14
 *@Version: 1.0
 **/

interface Human{
    String getBelief();
    void eat(String food);
}

//被代理类
class SuperMan implements Human{

    @Override
    public String getBelief() {
        return "i believe i can fly!";
    }

    @Override
    public void eat(String food) {
        System.out.println("i like eat:"+food);
    }
}

/*
    要想实现动态代理，需要解决的两个问题：
        问题一：如何根据加载到内存中的被代理类，动态的创建一个代理类及其对象
        问题二：当通过代理类的对象调用方法时，如何动态的去调用被代理类的同名方法；
 */

public class ProxyTest {
}
