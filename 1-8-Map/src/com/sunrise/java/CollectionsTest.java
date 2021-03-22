package com.sunrise.java;/**
 * @author: pc
 * @data:2021/1/10
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Collections:操作Collection和Map的工具类：
 *
 *
 * Collection和Collections的区别？
 *  接口和工具类
 *
 * 常用方法：
 * 排序操作：（均为static方法）
 * reverse(List)：反转 List 中元素的顺序
 * shuffle(List)：对 List 集合元素进行随机排序
 * sort(List)：根据元素的自然顺序对指定 List 集合元素按升序排序
 * sort(List，Comparator)：根据指定的 Comparator 产生的顺序对 List 集合元素进行排序
 * swap(List，int， int)：将指定 list 集合中的 i 处元素和 j 处元素进行交换
 *
 * 查找、替换
 * Object max(Collection)：根据元素的自然顺序，返回给定集合中的最大元素
 * Object max(Collection，Comparator)：根据 Comparator 指定的顺序，返回
 * 给定集合中的最大元素
 * Object min(Collection)
 * Object min(Collection，Comparator)
 * int frequency(Collection，Object)：返回指定集合中指定元素的出现次数
 * void copy(List dest,List src)：将src中的内容复制到dest中 boolean replaceAll(List list，Object oldVal，Object newVal)：使用新值替换
 * List 对象的所有旧值
 *
 *@ClassName: CollectionsTest
 *@Description:TODO
 *@Author: pc
 *@Date: 2021/1/10 16:58
 *@Version: 1.0
 **/
public class CollectionsTest {

// * 常用方法：
// * 排序操作：（均为static方法）
// * reverse(List)：反转 List 中元素的顺序
// * shuffle(List)：对 List 集合元素进行随机排序
// * sort(List)：根据元素的自然顺序对指定 List 集合元素按升序排序
// * sort(List，Comparator)：根据指定的 Comparator 产生的顺序对 List 集合元素进行排序
// * swap(List，int， int)：将指定 list 集合中的 i 处元素和 j 处元素进行交换
//
    @Test
    public void test1(){
        List list = new ArrayList();
        list.add(12);
        list.add(123);
        list.add(122);
        list.add(142);
        list.add(162);
        list.add(182);

        System.out.println(list);

        Collections.reverse(list);
        System.out.println(list);

        Collections.sort(list);
        System.out.println(list);

        Collections.swap(list, 1,3);
        System.out.println(list);
    }
}
