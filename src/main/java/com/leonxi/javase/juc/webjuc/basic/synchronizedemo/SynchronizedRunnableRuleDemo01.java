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
 *  其他线程对“该对象”的该“synchronized方法”或者“synchronized代码块”的访问将被阻塞
	继承Runnable，new线程会出现一个共享锁
	thread-1 loop 0
	thread-1 loop 1
	thread-1 loop 2
	thread-1 loop 3
	thread-1 loop 4
	thread-2 loop 0
	thread-2 loop 1
	thread-2 loop 2
	thread-2 loop 3
	thread-2 loop 4
 */
class MyRunable implements Runnable {

	@Override
	public void run() {
		synchronized (this) { //Runnable，this只会有一个锁
			try {
				for (int i = 0; i < 5; i++) {
					Thread.sleep(100); // 休眠100ms
//					Thread.sleep(10000000); // 休眠10000000ms,时间延长，然后通过通过Jps+jstack打印
					
					System.out.println(Thread.currentThread().getName() + " loop " + i);
				}
			} catch (InterruptedException ie) {
			}
		}
	}
}

public class SynchronizedRunnableRuleDemo01 {

	public static void main(String[] args) {
		Runnable demo = new MyRunable(); // 新建“Runnable对象”

		Thread t1 = new Thread(demo, "thread-1"); // 新建“线程t1”, t1是基于demo这个Runnable对象
		Thread t2 = new Thread(demo, "thread-2"); // 新建“线程t2”, t2是基于demo这个Runnable对象
		t1.start(); // 启动“线程t1”
		t2.start(); // 启动“线程t2”
	}
}

/*
 * 
*/
