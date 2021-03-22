package com.sunrise.java;/**
 * @author: pc
 * @data:2021/1/12
 */

import java.io.Serializable;

/**
 * Person需要满足如下的要求，方可序列化
 *  1、需要实现接口：Serializable
 *  2、当前类提供一个全局变量serialVersionUID
 *  3、除了当前Person类实现Serializable接口之外，还必须保证其内部所有属性可以序列化（默认情况基本数据类型可以序列化）
 *
 *  补充：static、transient修饰的成员变量不可以被序列化
 *
 *@ClassName: Person
 *@Description:TODO
 *@Author: pc
 *@Date: 2021/1/12 19:37
 *@Version: 1.0
 **/
public class Person implements Serializable {
    private String name;
    private int age;
    public static final long serialVersionUID =  3534657875346L;
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }
}
