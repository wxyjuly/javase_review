/**
 * Project Name:javase_review
 * File Name:ThreadStartRunMethodDiff.java
 * Package Name:com.leonxi.javase.juc.webjuc.basic
 * Date:2018年3月13日下午5:50:27
 * Copyright (c) 2018, 【Leon Xi】 All Rights Reserved.
 *
*/

package com.leonxi.javase.juc.webjuc.basic;

/**
 * ClassName:ThreadStartRunMethodDiff <br/>
 * Date: 2018年3月13日 下午5:50:27 <br/>
 * @author Leon Xi
 * @version v1.0
 * @see
 */
/*
 	main call mythread.run()
	main is running
	main call mythread.start()
	mythread is running
 */
// ThreadStartRunMethodDiff.java 的源码
class MyThread01 extends Thread {
	public MyThread01(String name) {
		super(name);
	}

	public void run() {
		System.out.println(Thread.currentThread().getName() + " is running");
	}
};

public class ThreadStartRunMethodDiff {
	public static void main(String[] args) {
		Thread mythread = new MyThread01("mythread");

		System.out.println(Thread.currentThread().getName() + " call mythread.run()");
		mythread.run();

		System.out.println(Thread.currentThread().getName() + " call mythread.start()");
		mythread.start();
	}
}
