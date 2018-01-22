/**
 * Project Name:javase_review
 * File Name:DeadLockDemo.java
 * Package Name:com.leonxi.javase.juc.artconcurrentbook.chapter01
 * Date:2018年1月22日下午10:01:56
 * Copyright (c) 2018, 【Leon Xi】 All Rights Reserved.
 *
*/

package com.leonxi.javase.juc.artconcurrentbook.chapter01;

/**
 * 死锁例子
 * jps查看进程号：
 * jstack 进程号：查看数据
 * @author LeonXi
 * @author tengfei.fangtf
 * @version $Id: DeadLockDemo.java, v 0.1 2015-7-18 下午10:08:28 tengfei.fangtf Exp $
 */
public class DeadLockDemo {

    /** A锁 */
    private static String A = "A";
    /** B锁 */
    private static String B = "B";

    public static void main(String[] args) {
        new DeadLockDemo().deadLock();
    }

    private void deadLock() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (A) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (B) {
                        System.out.println("1");
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (B) {
                    synchronized (A) {
                        System.out.println("2");
                    }
                }
            }
        });
        t1.start();
        t2.start();
    }

}
