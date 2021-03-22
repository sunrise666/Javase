package com.sunrise.java;/**
 * @author: pc
 * @data:2021/1/11
 */

import org.junit.Test;

import java.util.*;

/**
 *
 * 泛型的使用：
 *  1、JDK5.0新增的特性
 *  2、在集合中使用泛型：
 *      总结：
 *          ①在集合接口和集合类在jdk5.0时都修改为带泛型的结构；
 *          ②在实例化集合类，可以指名具体的泛型类型；
 *          ③指明晚以后，在集合类或者接口中凡是定义类或者接口时，内部结构使用到的类的类型的位置，都指定为实例化的类型
 *          比如： add(E e) --->实例化：add(Integer e)
 *          ④泛型必须为类，不能是基本数据类型
 *          ⑤如果实例化是，没有指定泛型，默认添加时为Object类型。
 *
 *@ClassName: GenericTest
 *@Description:TODO
 *@Author: pc
 *@Date: 2021/1/11 20:26
 *@Version: 1.0
 **/
public class GenericTest {
    @Test
    public void test1(){
        ArrayList<Object> list = new ArrayList<>();

        //需求：存放学生的成绩
        list.add(12);
        list.add(23);

        list.add(12);
        list.add(23);
        list.add(12);
        list.add(23);
        list.add(12);
        list.add(23);

        //问题1：类型不安全
        list.add("Tom");

        for(Object obj: list){

            //问题二：强制类型转换，可能出现ClassCastException
            int v = (Integer)obj;
            System.out.println(v);
        }

    }

    @Test
    public void test2(){
        //ArrayList泛型不能是基本数据类型
        ArrayList<Integer> list = new ArrayList<>();
        list.add(59);
        list.add(59);
        list.add(59);
        list.add(59);
        list.add(59);
        list.add(59);
        //在编译进行类型检查，保存数据的安全

        //遍历方式一：
        for(Integer score:list){
            int stuScore = score;
            System.out.println(stuScore);
        }

        //遍历方式二:
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            Integer stuScore = iterator.next();
            System.out.println(stuScore);
        }
    }

    //在集合中使用泛型：以HashMap为例，
    @Test
    public void test3(){
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("Tom", 56);
        map.put("Tow", 56);
        map.put("Tob", 56);
        map.put("Tim", 56);
//泛型的嵌套
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Integer> next = iterator.next();
            Integer value = next.getValue();
            String key = next.getKey();
            System.out.println(key+"---"+value);

        }


    }
}
