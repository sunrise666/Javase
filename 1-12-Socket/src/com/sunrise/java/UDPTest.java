package com.sunrise.java;/**
 * @author: pc
 * @data:2021/1/13
 */

import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 *
 * UDP协议的网络编程
 *
 *@ClassName: UDPTest
 *@Description:TODO
 *@Author: pc
 *@Date: 2021/1/13 11:15
 *@Version: 1.0
 **/
public class UDPTest {

    @Test
    public void sender() throws IOException {
        DatagramSocket socket = new DatagramSocket();

        String str = "sfdeggd";
        byte[] bytes = str.getBytes();
        InetAddress inet = InetAddress.getByName("127.0.0.1");
        DatagramPacket packet = new DatagramPacket(bytes, 0, bytes.length,inet, 9090);

        socket.send(packet);

        socket.close();

    }

    @Test
    public void receiver() throws IOException {
        DatagramSocket socket = new DatagramSocket(9090);
        byte[] buffer = new byte[100];
        DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);
        socket.receive(packet);

        System.out.println(new String(packet.getData(), 0, packet.getLength()));
    }
}
