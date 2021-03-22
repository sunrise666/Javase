package com.sunrise.java;/**
 * @author: pc
 * @data:2021/1/13
 */

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 *@ClassName: ReflectionTest
 *@Description:TODO
 *@Author: pc
 *@Date: 2021/1/13 20:32
 *@Version: 1.0
 **/
public class ReflectionTest {

    //反射前，对Person类型的操作

    @Test
    public void test1(){
        Person person = new Person("tom", 12);

        person.age = 10;
        System.out.println(person.toString());
    }
    /*
        
     */
    @Test
    public void test2() throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException, NoSuchFieldException {
        Class clazz = Person.class;
        //通过反射，创建Person类的对象
        Constructor cons = clazz.getConstructor(String.class, int.class);

        Object tom = cons.newInstance("tom", 12);
        System.out.println(tom.toString());

        //2、通过反射，调用对象指定的属性和方法
        Field age = clazz.getDeclaredField("age");
        age.set(10);
    }

}
