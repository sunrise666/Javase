package com.sunrise.java;/**
 * @author: sunrise
 * @data:2021/1/7
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 1、|----Colleciton 接口：单列集合、用来存储一个一个的对象
 *      |----list接口：存储有序的、可重复的数据。 -->“动态”数组，替换原来的数组
 *          |----Arraylist：list接口的主要实现类，执行效率高，线程不安全，底层使用Object[] elementData数组存储
 *          |----linkedlist：对于频繁的插入和删除操作，使用此类的效率比Arraylist的效率高，底层双向链式存储，
 *          |----Vector：作为list接口的古老实现类，基本上开发不会用，线程安全的，执行·效率低，底层也是使用Object[] elementData类型，
 *
 *
 * 2、Arraylist源码分析：JDK7和JDK8稍有不同，
 *  2.1 jdk 7情况下，
 *      Arraylist list = new Arraylsit();//底层创建了一个长度为10的object[]数组elementData
 *      list.add(123)；
 *      。。。
 *      list.add(11)；//如果此次添加导致底层elementData数组容量不够，则扩容，默认扩容为1.5倍，同时将原有数组中的数据复制到新的数组中。
 *
 *      结论：建议开发中使用带参的构造器
 *  2.2 jdk8中arraylist：
 *          Arraylist list = new Arraylsit();//底层object[] elementData初始化为{}，并没有创建长度为10的数组
 *
 *          list.add（123）//第一次调用add蔡创建长度为10的数组，并将数据123添加到elementData中。
 *  2.3小结：
 *      jdk7中的arraylist的创建类似于单例的饿汉式，而jdk8中的Arraylist的对象的创建相当于单例的懒汉式。
 *
 *
 * 3.linkedlsit
 *      linkedlist list = new linkedlist();
 *      内部声明了Node类型的first和last属性，默认值为null
 *      list.add(123);//将123封装到Node中，创建了Node对象。
 *
 *      其中Node定义为：
 *
 *
 * 4. Vector的源码分析：在jdk7和jdk8中通过vector()构造创建对象时，底层都创建了长度为10的数组，
 *      在扩容方面，默认扩容为原理的长度的两倍。
 *
 * 5. list接口中的常用方法。
 *
 * 面试题：Arraylist、linkedlist、Vector三者的异同？
 * 同：三个类均实现了list接口，存储数据的特点相同：存储有序的，可重复的数据
 * 不同：如上
 *
 * transient关键字：这个字段的生命周期仅存于调用者的内存中而不会写到磁盘里持久化，保证安全。
 *
 *
 * list接口常用方法：
 * add（）：在列表的指定位置查出指定元素
 * addAll（）：将指定集合中的所有元素都插入到列表的指定位置
 * get（）：返回列表中指定位置的元素
 * indexOf（）：返回此列表中第一次出现的指定元素的索引；如不包含，返回-1
 * lastIndexOf（）：返回此列表中最后出现的指定元素的索引；如不包含，返回-1
 * listIterator（）：返回此列表的列表迭代器
 * listIterator（int index）：返回此列表的列表迭代器，从列表的指定位置开始
 * remove()：移除列表中指定位置的元素
 * set（）：用指定元素替换列表中指定位置的元素
 * subList（int fromIndex，int toIndex）：返回列表中[fromIndex,toIndex)之间的部分视图
 *
 * 总结方法：
 *  增： add(Object obj)
 *  删： remove(int index)\remove(Object obj)
 *  改： set(int index, Object obj)
 *  查 ； get(int index)
 *  插： add(int index, Object ele)
 *  长度： size()
 *  遍历： ①Iterator 迭代器方式
 *        ②增强for 循环
 *        ③普通的for循环
 *
 *@ClassName: listTest
 *@Description:TODO
 *@Author: pc
 *@Date: 2021/1/7 15:20
 *@Version: 1.0
 **/
public class listTest {

    @Test
    public void test3(){

        List list = new ArrayList();
        list.add(123);
        list.add(456);

        list.add("AA");

        list.add(new Person("Tom", 12));
        list.add(new Person("Tom", 12));
        list.add(456);

        //方式一：使用Iterator 迭代器
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //方式二： 使用增强for循环
         for(Object obj : list){
             System.out.println(obj);
         }

         //方式三： 使用普通for循环
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
    @Test
    public void test1(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);

        list.add("AA");

        list.add(new Person("Tom", 12));
        list.add(456);
        System.out.println(list);

        list.add(1, "VV");
        System.out.println(list);
    }
    @Test
    public void test2(){
        List list = new ArrayList();
        list.add(123);
        list.add(456);

        list.add("AA");

        list.add(new Person("Tom", 12));
        list.add(456);
        System.out.println(list);

        System.out.println(list.indexOf(123));
    }
}
