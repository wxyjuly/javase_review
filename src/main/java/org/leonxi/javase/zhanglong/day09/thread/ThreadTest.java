/**
 * Project Name:javase_review
 * File Name:ThreadTest.java
 * Package Name:org.leonxi.javase.zhanglong.day09.thread
 * Date:2017年10月28日上午8:03:33
 * Copyright (c) 2017, 【Leon Xi】 All Rights Reserved.
 *
*/

package org.leonxi.javase.zhanglong.day09.thread;

import java.util.Iterator;

import org.w3c.dom.stylesheets.StyleSheetList;

/**
 * ClassName:ThreadTest <br/>
 * Date: 2017年10月28日 上午8:03:33 <br/>
 * 
 * @author Leon Xi
 * @version v1.0
 * @see
 */
public class ThreadTest {
	public static void main(String[] args) {
//		testTheadCreate();
		testThreadRunAndStart() ;
	}

	/**
	 * 
	 * ThreadTest01:演示两个Thread创建. <br/>
	 *
	 * @author Leon Xi
	 * 输出：
		Hello Thread->91
		Welcome:0Hello Thread->92   //注意这行输出，时间片切换，换行指令都无法执行完成
		Hello Thread->93
	 */
	public static void testTheadCreate() {
		Thread myThread1 = new MyThread1() ;
		Thread myThread2 = new MyThread2() ;
		
		myThread1.start() ;
		myThread2.start() ;
	}
	
	public static void testThreadRunAndStart() {
		Thread myThread1 = new MyThread1() ;
		Thread myThread2 = new MyThread2() ;
		myThread1.run() ;  //直接调用run方法，不是执行多线程
		myThread2.run() ;
		
	}
}

class MyThread1 extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 110; i++) {
			System.out.println("Hello Thread->"+ i);
		}
	}
}

class MyThread2 extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 120; i++) {
			System.err.println("Welcome:"+i);
		}
	}
}




