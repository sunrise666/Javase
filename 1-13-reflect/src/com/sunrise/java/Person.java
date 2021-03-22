package com.sunrise.java;/**
 * @author: pc
 * @data:2021/1/13
 */

/**
 *@ClassName: Person
 *@Description:TODO
 *@Author: pc
 *@Date: 2021/1/13 20:32
 *@Version: 1.0
 **/
public class Person {
    private String name;
    public int age;

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

    public void show(){
        System.out.println("我是人");
    }

    private void shou1(){
        System.out.println("我是哈哈哈："+this.toString());
    }
}
