package com.sunrise.java;/**
 * @author: pc
 * @data:2021/1/7
 */

import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 *
 * 1、Set接口的框架：
 *  |----Colleciton 接口：单列集合、用来存储一个一个的对象
 *       |----Set接口：存储无序的、不可重复的数据。 -->高中讲的集合
 *       |----HashSet: 作为Set接口的主要实现类， 线程是不安全的，可以存储null值
 *            |----LinkedHashSet:作为HashSet的子类，遍历其内部数据时，可以按照添加的顺序遍历
 *       |----TreeSet: ：底层的存储结构是用红黑树，可以按照添加的对象的指定属性进行排序。
 *
 * 1、 Set接口没有额外定义的心的方法，使用的都是Collection中声明过的方法。
 * 2、要求：向Set中添加数据，其所在的类一定要重写equals和hashCode()方法。
 *    要求： 重写的hashCOde()方法和equals方法竟可能保持一致性：相等的对象必须具有相等的散列码
 *    重写两个方法的小技巧： 对象中用作equals方法比较的Field，都应该用来计算hashCode
 *
 *@ClassName: SetTest
 *@Description:TODO
 *@Author: pc
 *@Date: 2021/1/7 19:38
 *@Version: 1.0
 **/
public class SetTest {
    /**
     * 一、Set接口：
     * 以HashSet为例说明：
     * 1、存储无序的：不等于随机性。存储数据在底层数组中不是按照索引的顺序添加，而是根据数据的哈希值
     *
     * 2、不可重复的数据：
     * 保证添加的元素按照equals()方法判断时，不能返回true，即：相同的元素只能添加一个。
     *
     * 二、添加元素的过程：以HashSet为例：
     *      我们向HashSet汇总添加元素a，首先调用元素a所在类的hashCode()方法，计算元素a的哈希值，
     *      此哈希值接着通过某种算法计算出在HashSet底层数组中存放位置（索引位置），判断数组此位置是否已经有元素：
     *          如果此位置上没有其他元素，则元素a添加成功；-->情况1
     *          如果此位置上已有其他元素b（或者说多个元素），则需要比较元素a与元素b的哈希值：”
     *              如果hash值不相同，则元素a添加成功--》情况2
     *              如果hash值相同，则调用元素a的equals方法比较两者之间的：
     *                  如果equals方法返回的True，则元素a添加失败
     *                  如果equals方法返回False， 则元素a添加成功。--》情况3
     *
     *      对于添加成功的情况2和2来说， 元素a与已经存在在指定索引位置的数据以链表的方式；来存储。
     *
     *      jdk 7: 元素a放到数组中，指向原来的元素
     *      jdk 8: 原来的元素放在数组中，指向元素a。
     *
     *      总结：七上八下
     *
     *      HashSet的底层结构： 数组加链表的结构。
     *
     */
    // LinekdHashSet的使用：
    //LinkedHashSet作为HashSet的子类，在添加数据的同时，每个数据还维护了两个引用，记录此数据前一个数据和后一个数据
    //优点：对于频繁的遍历操作，LinkedHashSet效率高于HashSet。
    @Test
    public void test2(){
        Set set = new LinkedHashSet();
        set.add(456);
        set.add(123);
        set.add("AA");
        set.add("BB");

        for( Object obj: set){
            System.out.println(obj);
        }
    }
    @Test
    public void test1(){
        Set set = new HashSet();
        set.add(456);
        set.add(123);
        set.add("AA");
        set.add("BB");

        for( Object obj: set){
            System.out.println(obj);
        }
    }
}
