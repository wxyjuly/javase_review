/**
 * Project Name:javase_review
 * File Name:RunnableTest.java
 * Package Name:com.leonxi.javase.juc.webjuc.basic
 * Date:2018年3月13日下午5:32:20
 * Copyright (c) 2018, 【Leon Xi】 All Rights Reserved.
 *
*/

package com.leonxi.javase.juc.webjuc.basic;

/**
 * ClassName:RunnableTest <br/>
 * Date: 2018年3月13日 下午5:32:20 <br/>
 * 
 * @author Leon Xi
 * @version v1.0
 * @see
 */
/**
 * 存在问题，资源重复卖
	Thread-0 卖票：ticket10
	Thread-1 卖票：ticket10
	Thread-2 卖票：ticket9
	Thread-1 卖票：ticket7
	Thread-0 卖票：ticket8
	Thread-1 卖票：ticket5
	Thread-2 卖票：ticket6
	Thread-1 卖票：ticket3
	Thread-0 卖票：ticket4
	Thread-1 卖票：ticket1
	Thread-2 卖票：ticket2
*/

// RunnableTest.java 源码
class MyThreadRunnable implements Runnable {
	private int ticket = 10;

	public void run() {
		for (int i = 0; i < 20; i++) {
			if (this.ticket > 0) {
				System.out.println(Thread.currentThread().getName() + " 卖票：ticket" + this.ticket--);
			}
		}
	}
};

public class RunnableTest {
	public static void main(String[] args) {
		MyThreadRunnable mt = new MyThreadRunnable();

		// 启动3个线程t1,t2,t3(它们共用一个Runnable对象)，这3个线程一共卖10张票！
		Thread t1 = new Thread(mt);
		Thread t2 = new Thread(mt);
		Thread t3 = new Thread(mt);
		t1.start();
		t2.start();
		t3.start();
	}
}


