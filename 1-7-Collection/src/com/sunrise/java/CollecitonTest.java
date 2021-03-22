package com.sunrise.java;/**
 * @author: pc
 * @data:2021/1/7
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * Collection接口中声明的方法的测试
 * 向Collection接口的实现类中添加OBJ时，要求在OBJ所在类的中重写equeals方法
 *
 * 集合基本操作：获取交集、并集、删除集合元素等
 *
 *@ClassName: CollecitonTest
 *@Description:TODO
 *@Author: pc
 *@Date: 2021/1/7 10:34
 *@Version: 1.0
 **/
public class CollecitonTest {
    @Test
    public void test1(){
        //contains()
        Collection coll = new ArrayList<>();
        coll.add(123);
        coll.add(456);
        coll.add(new String("tim"));
        System.out.println(coll);

        coll.add(new Person("tom",20));
        System.out.println(coll.contains(new Person("tom", 20)));

        //2、判断coll1中所有元素是否均存在coll中
        Collection coll1 = Arrays.asList(123,456);
        System.out.println(coll.containsAll(coll1));
        for(Object obj : coll){
            System.out.println(obj);
        };
    }
}
