package com.sunrise.java;/**
 * @author: pc
 * @data:2021/1/7
 */

import org.junit.Test;

import java.util.Set;
import java.util.TreeSet;

/**
 *@ClassName: TreeSet
 *@Description:TODO
 *@Author: pc
 *@Date: 2021/1/7 21:52
 *@Version: 1.0
 **/
public class TreeSetTest {
    /*
        1.向TreeSet中添加的数据要相同的对象
        2.两种排序：自然排序和定制排序
        3. 自然排序中，比较两个对象是否相同的标注为：compareTo()返回0,不再是equals方法。
        4. 在定制排序中，比较两个对象是否相同的标准为：compare()方法，不是equals方法。
     */
    @Test
    public void test1(){
        TreeSet set = new TreeSet();
//        不能添加不同的类对象
//        set.add(123);
//        set.add(456);
//        set.add(123);
//        set.add("AA");
//        set.add("BB");


        set.add(12);
        set.add(34);
        set.add(56);


    }
}
