package com.sunrise.java;/**
 * @author: pc
 * @data:2021/1/12
 */

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 一、
 * 网络编程中有两个主要的问题：
 * 如何准确地定位网络上一台或多台主机；定位主机上的特定的应用
 * 找到主机后如何可靠高效地进行数据传输
 *
 * 二、网络编程中的两个要素：
 *  1、对应问题一：ID和端口号
 *  2、对应问题二：提供网络通信协议：TCP、IP参考模型（应用层、传输层、网络层、物理+数据链路层）
 *
 * 三、通信要素一：IP和端口号：
 * IP:唯一标识  Internet上计算机
 * 2、在Java中使用InetAddress类代表IP
 * 3、ID分类：IPV4、IPV6,万维网和局域网
 * 4、域名：  www.baidu.com   www.mi.com
 * 5、本地回路地址： 127.0.0.1 对应：localhost
 *
 * 6、如何实例化：InetAddress两个方法：getByName()、getLocalHost()
 *  两个常用方法： getHostName()、getHostAddress();
 *
 *
 * 7、端口号;
 *      端口号标识正在计算机上运行的进程（程序）
 *       不同的进程有不同的端口号
 *       被规定为一个 16 位的整数 0~65535。
 *       端口分类：
 *       公认端口：0~1023。被预先定义的服务通信占用（如：HTTP占用端口
 *          80，FTP占用端口21，Telnet占用端口23）
 *       注册端口：1024~49151。分配给用户进程或应用程序。（如：Tomcat占
 *          用端口8080，MySQL占用端口3306，Oracle占用端口1521等）。
 *       动态/私有端口：49152~65535。
 *      端口号与IP地址的组合得出一个网络套接字：Socket。
 *
 * 四、TCP、UDP
 *   TCP协议：
 *   使用TCP协议前，须先建立TCP连接，形成传输数据通道
 *   传输前，采用“三次握手”方式，点对点通信，是可靠的
 *   TCP协议进行通信的两个应用进程：客户端、服务端。
 *   在连接中可进行大数据量的传输
 *   传输完毕，需释放已建立的连接，效率低
 *   UDP协议：
 *   将数据、源、目的封装成数据包，不需要建立连接
 *   每个数据报的大小限制在64K内
 *   发送不管对方是否准备好，接收方收到也不确认，故是不可靠的
 *   可以广播发送
 *   发送数据结束时无需释放资源，开销小，速度快
 *
 *
 *@ClassName: InetAddresstest
 *@Description:TODO
 *@Author: pc
 *@Date: 2021/1/12 20:48
 *@Version: 1.0
 **/
public class InetAddresstest {

    public static void main(String[] args) {
        try {
            InetAddress inte1 = InetAddress.getByName("192.168.10.14");
            System.out.println(inte1);

            InetAddress inet2 = InetAddress.getByName("www.baidu.com");
            System.out.println(inet2);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
