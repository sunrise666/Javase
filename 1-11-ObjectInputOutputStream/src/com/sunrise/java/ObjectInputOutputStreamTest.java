package com.sunrise.java;/**
 * @author: pc
 * @data:2021/1/11
 */

import org.junit.Test;

import java.io.*;

/**
 *@ClassName: ObjectInputOutputStreamTest
 *@Description:TODO
 *@Author: pc
 *@Date: 2021/1/11 22:18
 *@Version: 1.0
 **/
public class ObjectInputOutputStreamTest {
    /*
        序列化过程， 将内存中的java对象保存到磁盘中或者通过网络传输出去
        使用ObjectOutputStream实现
     */

    @Test
    public void test1(){

        ObjectOutputStream oos =null;

        try {
            //1、造流和文件
            oos = new ObjectOutputStream(new FileOutputStream("object.dat"));
            oos.writeObject(new String("我爱北京天安门"));
            oos.flush();//刷新操作

            oos.writeObject(new Person("马尾强", 24));
            oos.flush();


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if( oos != null){
                try{
                    oos.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }


        }
    }

    //反序列化过程:将磁盘文件中的对象还原为内存中的一个JAVA对象
    //需要使用ObjectInputStream
    @Test
    public void test2(){
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("object.dat"));

            Object obj = ois.readObject();
            String str =  (String)obj;
            System.out.println(str);

            Object obj1 = ois.readObject();
            Person p = (Person)obj1;
            System.out.println(p);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {

                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
