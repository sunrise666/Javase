package com.sunrise.java;/**
 * @author: pc
 * @data:2021/1/12
 */

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * 实现TCP的网络编程
 *  例子1： 客户端发送信息给服务端、服务端将数据显示出来
 *
 *@ClassName: TCPTest1
 *@Description:TODO
 *@Author: pc
 *@Date: 2021/1/12 21:28
 *@Version: 1.0
 **/
public class TCPTest1 {

    //客户端
    @Test
    public void client() {

        Socket sokect = null;
        OutputStream os = null;
        try {
//            1、创建Socket对象， 指明服务器端的ip
            InetAddress inet = InetAddress.getByName("127.0.0.1");
            //获取服务器端的端口号
            sokect = new Socket(inet, 8899);
            //建立io流
            os = sokect.getOutputStream();

            //发送数据
            os.write("你好，发的发发发".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (os != null){

                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (sokect != null){
                try {
                    sokect.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }


    }

    //服务器端
    @Test
    public void server(){
        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            //1、串讲服务器端的ServerSocket,指明自己的端口号
            ss = new ServerSocket(8899);
            //2、调用accept表示接受来自客户端的socket
            socket = ss.accept();
            //3、获取输入流
            is = socket.getInputStream();
//        不建议使用：可能会出现中文乱码的情况
//        byte[] buffer = new byte[20];
//        int len;
//        while ((len = is.read(buffer)) != -1){
//            String str = new String(buffer, 0, len);
//            System.out.println(str);
//        }
            //4、读取输入流的数据
            baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[5];

            int len;
            while ((len = is.read(buffer)) != -1){
                baos.write(buffer, 0,len);
            }
            System.out.println(baos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ss != null){
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null){

//                5、资源关闭
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (baos != null){
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }









    }
}
