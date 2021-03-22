package com.sunrise.java;/**
 * @author: pc
 * @data:2021/1/12
 */

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.spec.RSAOtherPrimeInfo;

/**
 *
 * 实现TCP的网络编程：
 * 例题二、 客户端发送文件给服务器端，服务器端将文件保存在本地
 *
 *@ClassName: TCPTest2
 *@Description:TODO
 *@Author: pc
 *@Date: 2021/1/12 21:59
 *@Version: 1.0
 **/
public class TCPTest2 {

    @Test
    public void client() {
        Socket socket = null;
        OutputStream os = null;
        FileInputStream fis = null;
        ByteArrayOutputStream baos = null;
        InputStream is = null;
        try {
            socket = new Socket(InetAddress.getByName("127.0.0.1"), 9090);

            os = socket.getOutputStream();
            fis = new FileInputStream(new File("1.jpg"));

            byte[] buffer = new byte[1024];
            int len;

            while ((len = fis.read(buffer)) != -1){
                os.write(buffer,0, len);
            }
            socket.shutdownOutput();

            is = socket.getInputStream();
            baos = new ByteArrayOutputStream();
            while ((len = is.read(buffer)) != -1){
                baos.write(buffer,0,len);
            }
            System.out.println(baos.toString());



        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(os != null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if( is!= null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if( baos!= null){
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void server() {

        ServerSocket serverSocket = null;
        Socket socket = null;
        FileOutputStream ois = null;
        InputStream is = null;
        OutputStream os = null;
        try {
            serverSocket = new ServerSocket(9090);
            socket = serverSocket.accept();
            ois = new FileOutputStream(new File("3.jpg"));

            is = socket.getInputStream();
            byte[] buffer = new byte[1024];
            int len;

            while ((len = is.read(buffer)) != -1){
                ois.write(buffer, 0,len);
            }
            os = socket.getOutputStream();
            os.write("发送成功".getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(serverSocket != null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
            if(socket != null){
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
            if(ois != null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if(os != null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
