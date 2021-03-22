package com.sunrise.java;/**
 * @author: pc
 * @data:2021/1/10
 */

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 *@ClassName: PropertiesTest
 *@Description:TODO
 *@Author: pc
 *@Date: 2021/1/10 16:45
 *@Version: 1.0
 **/
public class PropertiesTest {

    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            Properties properties = new Properties();

            fis = new FileInputStream("jdbc.properties");

            properties.load(fis);
            String name = properties.getProperty("name");
            String password = properties.getProperty("password");

            System.out.println("name=" + name + ",password="+ password);
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(fis != null){
                try {
                    fis.close();
                }
                catch (IOException e){
                    e.printStackTrace();
                }

            }

        }
    }
}
