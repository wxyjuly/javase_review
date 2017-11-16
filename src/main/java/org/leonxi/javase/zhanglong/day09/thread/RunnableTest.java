/**
 * Project Name:javase_review
 * File Name:RunnableTest.java
 * Package Name:org.leonxi.javase.zhanglong.day09.thread
 * Date:2017年10月28日上午8:20:21
 * Copyright (c) 2017, 【Leon Xi】 All Rights Reserved.
 *
*/

package org.leonxi.javase.zhanglong.day09.thread;
/**
 * ClassName:RunnableTest <br/>
 * Date:     2017年10月28日 上午8:20:21 <br/>
 * @author   Leon Xi
 * @version  v1.0
 * @see 	 
 */
public class RunnableTest {

	public static void main(String[] args) {
		testRunnableThread();

	}
	/**
	 * 
	 * testRunnable:测试Runnable实现. <br/>
	 *
	 * @author Leon Xi
	 */
	public static void testRunnableThread() {
		Thread runnableThread01 = new Thread(new RunnableDemo()) ;
		Thread runnableThread02 = new Thread(new RunnableDemo()) ;
		
		runnableThread01.start();
		runnableThread02.start();
	}
}

class RunnableDemo implements Runnable {

	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("Welcome Runnable:" + i);
		}
	}
	
}

