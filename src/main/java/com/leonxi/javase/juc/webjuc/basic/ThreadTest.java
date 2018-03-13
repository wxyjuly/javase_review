/**
 * Project Name:javase_review
 * File Name:ThreadTest.java
 * Package Name:com.leonxi.javase.juc
 * Date:2018年3月13日下午5:23:43
 * Copyright (c) 2018, 【Leon Xi】 All Rights Reserved.
 *
*/

package com.leonxi.javase.juc.webjuc.basic;

/**
 * ClassName:ThreadTest <br/>
 * Date: 2018年3月13日 下午5:23:43 <br/>
 * 
 * @author Leon Xi
 * @version v1.0
 * @see
 */
// ThreadTest.java 源码
class MyThread extends Thread {
	private int ticket = 10;

	public void run() {
		for (int i = 0; i < 20; i++) {
			if (this.ticket > 0) {
				System.out.println(this.getName() + " 卖票：ticket" + this.ticket--);
			}
		}
	}
};

public class ThreadTest {
	public static void main(String[] args) {
		// 启动3个线程t1,t2,t3；每个线程各卖10张票！
		MyThread t1 = new MyThread();
		MyThread t2 = new MyThread();
		MyThread t3 = new MyThread();
		t1.start();
		t2.start();
		t3.start();
	}
}
