package com.sunrise.java;/**
 * @author: pc
 * @data:2021/1/10
 */

/**
 *@ClassName: Person
 *@Description:TODO
 *@Author: pc
 *@Date: 2021/1/10 16:27
 *@Version: 1.0
 **/
public class Person implements Comparable{
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Person){
            Person person = (Person)o;
            int compare = -this.name.compareTo(person.name);
            if(compare != 0){
                return compare;
            }else {
                return Integer.compare(this.age, person.age);
            }

        }else {
            throw new RuntimeException("输入的类型不一致！");
        }
    }
}

