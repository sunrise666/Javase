package com.sunrise.java;/**
 * @author: pc
 * @data:2021/1/8
 */

import org.junit.Test;

import java.util.*;

/**
 *  一、Map实现类的结构：
 *  |----Map：双列数据， 存储key-value对的数据， 类似于高中的函数y = f(x)
 *          |---- HashMap:作为Map的主要实现类，线程不安全，效率高
 *              |----LinkedHashMap:1.4出现，保证在遍历map元素时，可以按照添加的顺序是先遍历。
 *                          原因：在是有的HashMap底层结构的基础上，添加一对指针，指向前一个和后一个
 *                          对于频繁的遍历操作，此类执行效率高于HashMap
 *          |----TreeMap:保证按照添加的key-value对进行排序，实现排序遍历。此时考虑key的自然排序或者定制排序。
 *                      底层使用红黑树，
 *          |----Hashtable:作为古老的实现类，线程是安全的，效率低，不能存储null的key和value
 *              |----Properties:常用来处理配置文件。key和value都是String类型。
 *
 *
 *
 *         HashMap 的底层： 数组+链表(jdk7)
 *                          数组+链表+红黑树（jdk8）
 *
 *
 *  面试题：
 *      1、HashMap的底层实现原理？
 *      2、HashMap和HashTable的异同。
 *      3、CurrentHashMap与Hashtable的异同？（先不讲）
 *
 *
 *  二、Map结果的实现的理解;
 *      Map中的key是无序的、不可重复的,使用Set存储所有的key， --->key所在的类重写equals和hashcode方法。
 *      Map中的value: 无序的、可重复的,使用Colleciotn存储所有的value值，---> value所在类要重写equals方法。
 *      一个键值对： key-value构成一个entry
 *      Map中的entry： 无序的、不可重复的，使用Set存储所有的entry。
 *
 *  三、HashMap的底层实现原理？
 *      以JDK7为例说明：
 *          HashMap map = new HashMap();
 *          1、在实例化以后，底层创建了一个长度为16的一维数组Entry[] table;
 *          2、可能已经执行过多次put操作，map.put（key，value）；
 *          3、首先，调用key1所在类的hashcode()计算key1哈希值，此哈希值经过某种算法计算以后，得到在Entry数组中存放位置。
 *          4、如果此位置上数据为空， 此时key1-value1添加成功。---》情况1
 *          5、如果此位置上的数据不为空， 意味着此位置上存在一个或者多个数据（以链表的形式存在），比较key1和已经存在的一个或者多个数据的hash值
 *              如果key1哈希值与已存在的数据都不相同，此时key1-value1添加成功。---》情况2
 *              如果key1哈希值和已经存在的某一个数据的哈希值相同，继续比较，调用key1所在类的equal方法，比较：
 *                  如果equals返回false，此时key1-value1添加成功。---》情况3
 *                  如果equals返回true，使用value1替换value2。
 *
 *          补充： 关于情况2和情况3：此时key1-value1和原来的数据以链表的方式存储
 *
 *          在不断地添加过程中，会涉及到扩容的问题，默认的扩容方式为：扩容为原来的2倍，并将原有的数据复制过来。
 *
 *       jdk8相较于jdk7在底层方法实现的不同：
 *       1、new hashMap()：底层没有创建一个长度为16的数组
 *       2、jdk 8底层的数据是Node[] 而不是Entry[]
 *       3、首次调用put()方法时，底层创建长度为16的数组
 *       4、jdk7底层结构只有：数组加链表的形式，jdk8底层结构： 数组贾链表加红黑树
 *          当数组中的某一个索引位置上的元素以链表的形式存在的数据个数》8且当前数组的长度大于64时，
 *          此时索引位置上所有的数据改为使用红黑树存储。
 *
 *
 *       DEFAULT_INITIAL_CAPACITY: HashMap 的默认容量： 16
 *       DEFAULT_LOAD_FACTOR： HashMap的默认加载因子 0.75
 *       threshold: 扩容的临界值 = 容量*加载因子 = 16*0.75 = 12
 *       TREEIFY_THRETHOLD: Bucket中链表长度大于该默认值转换为红黑树： 8
 *       MIN_TREEIFY_CAPACITY: 桶中NODE被树化时的最小的hash表的容量：64
 *
 *  四、LinkedHashMap的地层实现原理：（了解）
 *      源码中：
 *          static class Entry<K,V> extends HashMap.Node<K,V> {
 *         Entry<K,V> before, after;//能够记录添加的元素的先后顺序。
 *         Entry(int hash, K key, V value, Node<K,V> next) {
 *             super(hash, key, value, next);
 *         }
 *     }
 *
 *
 *  五、Map中常用的方法：
 *   添加、删除、修改操作：
 *   Object put(Object key,Object value)：将指定key-value添加到(或修改)当前map对象中
 *  void putAll(Map m):将m中的所有key-value对存放到当前map中
 *  Object remove(Object key)：移除指定key的key-value对，并返回value
 *  void clear()：清空当前map中的所有数据
 *  元素查询的操作：
 *  Object get(Object key)：获取指定key对应的value
 *  boolean containsKey(Object key)：是否包含指定的key
 *  boolean containsValue(Object value)：是否包含指定的value
 *  int size()：返回map中key-value对的个数
 *  boolean isEmpty()：判断当前map是否为空
 *  boolean equals(Object obj)：判断当前map和参数对象obj是否相等
 *  元视图操作的方法：
 *  Set keySet()：返回所有key构成的Set集合
 *  Collection values()：返回所有value构成的Collection集合
 *  Set entrySet()：返回所有key-value对构成的Set集合
 *
 *
 * 总结：常用方法
 * 添加：put(Object key,Object value)、putAll(Map m)
 * 删除：clear()、remove(Object key)
 * 查找：get(Object key)、containsKey(Object key)、containsValue(Object value)
 * 修改：put(Object key,Object value)
 * 长度：size()
 * 遍历：keySet()、values()、entrySet()
 *
 *@ClassName: MapTest
 *@Description:TODO
 *@Author: pc
 *@Date: 2021/1/8 15:03
 *@Version: 1.0
 **/
public class MapTest {

// *  元视图操作的方法：
// *  Set keySet()：返回所有key构成的Set集合
// *  Collection values()：返回所有value构成的Collection集合
// *  Set entrySet()：返回所有key-value对构成的Set集合
    @Test
    public void test5(){
        Map map = new HashMap();
        map.put(123,"swedw");
        map.put(345,"sefre");
        map.put(346,"segh");
        //遍历所有的key

        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //遍历所有的value
        Collection values = map.values();
        Iterator iterator1 = values.iterator();
        while (iterator1.hasNext()){
            System.out.println(iterator1.next());
        }

        //遍历所有的key-value
        Set set1 = map.entrySet();
        Iterator iterator2 = set1.iterator();
        while (iterator2.hasNext()){
            Object next = iterator2.next();
            //entrySet集合中的元素都是entry
            Map.Entry entry = (Map.Entry)next;

            System.out.println(entry.getKey()+"--->"+entry.getValue());

        }
        //方式二：
        Set set2 = map.keySet();
        Iterator iterator3 = set2.iterator();
        while (iterator3.hasNext()){
            Object key = iterator3.next();
            Object value = map.get(key);
            System.out.println(key+"---"+ value);

        }
    }
// *  元素查询的操作：
// *  Object get(Object key)：获取指定key对应的value
// *  boolean containsKey(Object key)：是否包含指定的key
// *  boolean containsValue(Object value)：是否包含指定的value
// *  int size()：返回map中key-value对的个数
// *  boolean isEmpty()：判断当前map是否为空
// *  boolean equals(Object obj)：判断当前map和参数对象obj是否相等
    @Test
    public void test4(){
        Map map = new HashMap();
        map.put(123,"swedw");
        map.put(345,"sefre");
        map.put(346,"segh");

        System.out.println(map.get(123));
        System.out.println(map.containsKey(345));
        System.out.println(map.containsValue("se"));
        System.out.println(map.size());
        System.out.println(map.isEmpty());

        Map map1 = new HashMap();
        map1.put(345,"sefre");
        map1.put(346,"segh");
        System.out.println(map.equals(map1));
    }
// *   添加、删除、修改操作：  Object put(Object key,Object value)：将指定key-value添加到(或修改)当前map对象中
// *  void putAll(Map m):将m中的所有key-value对存放到当前map中
//  Object remove(Object key)：移除指定key的key-value对，并返回value
// *  void clear()：清空当前map中的所有数据
    @Test
    public void test3(){
        Map map = new HashMap();
        map.put(23,45);
        map.put(23,47);
        System.out.println(map);

        Map map1 = new HashMap();
        map1.put(53,56);
        map1.put("sa", 2335);
        map.putAll(map1);

        System.out.println(map);

        Object v1 = map.remove("sa");
        System.out.println(v1);
        System.out.println(map);

        map.clear();
        System.out.println(map);
    }
    @Test
    public void test2(){
        Map map = new LinkedHashMap();
        map.put(123,"swedw");
        map.put(345,"sefre");
        map.put(346,"segh");

        System.out.println(map);
    }
    @Test
    public void test1(){
        Map map = new HashMap();
        map.put('s',123);


    }
}
