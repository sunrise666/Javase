package com.sunrise.java;/**
 * @author: pc
 * @data:2021/1/13
 */

import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * URL网络编程：
 * 1\URL(Uniform Resource Locator)：统一资源定位符，它表示 Internet 上某一
 * 资源的地址。
 * 2、格式：
 *      http://192.168.1.100:8080/helloworld/index.jsp#a?username=shkstart&password=123
 *      <传输协议>://<主机名>:<端口号>/<文件名>#片段名?参数列表
 *
 *
 *
 *@ClassName: URLTest
 *@Description:TODO
 *@Author: pc
 *@Date: 2021/1/13 11:32
 *@Version: 1.0
 **/
public class URLTest {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://192.168.1.100:8080/helloworld/index.jsp#a?username=shkstart&password=123");
        System.out.println(url.getHost());




    }
}
