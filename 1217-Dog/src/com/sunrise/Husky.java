package com.sunrise;/**
 * @author: pc
 * @data:2020/12/17
 */

/**
 *@ClassName: Husky
 *@Description:TODO
 *@Author: pc
 *@Date: 2020/12/17 17:04
 *@Version: 1.0
 **/
public class Husky implements Dog{
    private String name;
    private int age;

    public Husky(){}
    public Husky(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public void food() {
        System.out.println("Huskt "+ this.getName() + " don't like eating dog food");

    }

    @Override
    public void shout() {
        System.out.println("Husky like shouting");
    }

    @Override
    public void play() {
        System.out.println(this.getName() + " like playing with owner");
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
}
