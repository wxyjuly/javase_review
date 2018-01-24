/**
 * Project Name:javase_review
 * File Name:ConnectionDriver.java
 * Package Name:com.leonxi.javase.juc.artconcurrentbook.chapter04
 * Date:2018年1月24日上午9:48:42
 * Copyright (c) 2018, 【Leon Xi】 All Rights Reserved.
 *
*/

package com.leonxi.javase.juc.artconcurrentbook.chapter04;
/**
 * ClassName:ConnectionDriver <br/>
 * Date:     2018年1月24日 上午9:48:42 <br/>
 * @author   Leon Xi
 * @version  v1.0
 * @see 	 
 */
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.concurrent.TimeUnit;

/**
 * 6-17
 */
public class ConnectionDriver {
    static class ConnectionHandler implements InvocationHandler {
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if (method.getName().equals("commit")) {
                TimeUnit.MILLISECONDS.sleep(100);
            }
            return null;
        }
    }

    // 创建一个Connection的代理，在commit时休眠1秒
    public static final Connection createConnection() {
        return (Connection) Proxy.newProxyInstance(ConnectionDriver.class.getClassLoader(), new Class<?>[] { Connection.class },
            new ConnectionHandler());
    }
}

