package com.sunrise.java;/**
 * @author: pc
 * @data:2021/1/10
 */

import org.junit.Test;

import java.util.*;

/**
 *@ClassName: TreeMapTest
 *@Description:TODO
 *@Author: pc
 *@Date: 2021/1/10 16:17
 *@Version: 1.0
 **/
public class TreeMapTest {
    //向treeMap中添加元素时，要求添加的对象类必要保存一致
    //按照key排序：自然排序、定制排序

    //自然排序
    @Test
    public void test1(){
        TreeMap map = new TreeMap();
        Person p1 = new Person("sdf", 123);
        Person p2 = new Person("frg", 13);
        Person p3 = new Person("tt", 129);
        Person p4 = new Person("bb", 53);
        Person p5 = new Person("cc", 73);

        map.put(p1, 100);
        map.put(p2, 101);
        map.put(p3,104);
        map.put(p4, 99);
        map.put(p5, 102);

        //遍历所有的key-value
        Set set1 = map.entrySet();
        Iterator iterator2 = set1.iterator();
        while (iterator2.hasNext()){
            Object next = iterator2.next();
            //entrySet集合中的元素都是entry
            Map.Entry entry = (Map.Entry)next;

            System.out.println(entry.getKey()+"--->"+entry.getValue());

        }

    }

    //定制排序
    @Test
    public void test2(){
        TreeMap map = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Person && o2 instanceof Person){
                    Person o11 = (Person) o1;
                    Person o21 = (Person) o2;
                    return Integer.compare(o11.getAge(), o21.getAge());
                }else {
                    throw new RuntimeException("输入的类型不一致");
                }
            }
        });
        Person p1 = new Person("sdf", 123);
        Person p2 = new Person("frg", 13);
        Person p3 = new Person("tt", 129);
        Person p4 = new Person("bb", 53);
        Person p5 = new Person("cc", 73);

        map.put(p1, 100);
        map.put(p2, 101);
        map.put(p3,104);
        map.put(p4, 99);
        map.put(p5, 102);

        //遍历所有的key-value
        Set set1 = map.entrySet();
        Iterator iterator2 = set1.iterator();
        while (iterator2.hasNext()){
            Object next = iterator2.next();
            //entrySet集合中的元素都是entry
            Map.Entry entry = (Map.Entry)next;

            System.out.println(entry.getKey()+"--->"+entry.getValue());

        }

    }
}
