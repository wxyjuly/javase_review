/**
 * Project Name:javase_review
 * File Name:Synchronized.java
 * Package Name:com.leonxi.javase.juc.artconcurrentbook.chapter04
 * Date:2018年1月24日上午9:52:33
 * Copyright (c) 2018, 【Leon Xi】 All Rights Reserved.
 *
*/

package com.leonxi.javase.juc.artconcurrentbook.chapter04;
/**
 * ClassName:Synchronized <br/>
 * Date:     2018年1月24日 上午9:52:33 <br/>
 * @author   Leon Xi
 * @version  v1.0
 * @see 	 
 */
/**
 * 6-10
 */
public class Synchronized {
    public static void main(String[] args) {
        // 对Synchronized Class对象进行加锁
        synchronized (Synchronized.class) {

        }
        // 静态同步方法，对Synchronized Class对象进行加锁
        m();
    }

    public static synchronized void m() {
    }
}

