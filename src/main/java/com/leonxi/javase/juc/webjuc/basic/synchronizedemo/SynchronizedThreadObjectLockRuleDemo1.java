/**
 * Project Name:javase_review
 * File Name:SynchronizedRuleDemo01.java
 * Package Name:com.leonxi.javase.juc.webjuc.basic.synchronizedemo
 * Date:2018年3月13日下午6:09:57
 * Copyright (c) 2018, 【Leon Xi】 All Rights Reserved.
 *
*/

package com.leonxi.javase.juc.webjuc.basic.synchronizedemo;

/**
 * ClassName:SynchronizedRuleDemo01 <br/>
 * Date: 2018年3月13日 下午6:09:57 <br/>
 * 
 * @author Leon Xi
 * @version v1.0
 * @see
 */

/*
 *  第一条: 当一个线程访问“某对象”的“synchronized方法”或者“synchronized代码块”时，
  	其他线程对“该对象”的该“synchronized方法”或者“synchronized代码块”的访问将被阻塞.
  	继承Thread，new线程，synchronized(this)会出现两个锁。
	thread-2 loop 0
	thread-1 loop 0
	thread-2 loop 1
	thread-1 loop 1
	thread-2 loop 2
	thread-1 loop 2
	thread-2 loop 3
	thread-1 loop 3
	thread-2 loop 4
	thread-1 loop 4
 */

class MyThread2 extends Thread {
	
	public static final Object obj = new Object() ;
	
    public MyThread2(String name) {
        super(name);
    }

    @Override
    public void run() {
        synchronized(obj) { //obj还是锁不住
            try {  
                for (int i = 0; i < 5; i++) {
                    Thread.sleep(100); // 休眠100ms
                    System.out.println(Thread.currentThread().getName() + " loop " + i);  
                }
            } catch (InterruptedException ie) {  
            }
        }  
    }
}

public class SynchronizedThreadObjectLockRuleDemo1 {

    public static void main(String[] args) {  
        Thread t1 = new MyThread1("thread-1");  // 新建“线程thread-1”
        Thread t2 = new MyThread1("thread-2");  // 新建“线程t2”
        t1.start();                          // 启动“线程thread-1”
        t2.start();                          // 启动“线程t2” 
    } 
}


