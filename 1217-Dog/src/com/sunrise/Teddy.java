package com.sunrise;/**
 * @author: pc
 * @data:2020/12/17
 */

/**
 *@ClassName: Teddy
 *@Description:TODO
 *@Author: pc
 *@Date: 2020/12/17 16:58
 *@Version: 1.0
 **/
public class Teddy implements Dog{

    private String name;
    private int age;
    public Teddy(){}

    public Teddy(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public void food() {
        System.out.println("Teddy "+this.getName()+" like eating dog food;");
    }

    @Override
    public void shout() {
        System.out.println(this.getName()+" don't like shout" );
    }

    @Override
    public void play() {
        System.out.println("I like play with my owner");
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
