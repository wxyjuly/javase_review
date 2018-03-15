/**
 * Project Name:javase_review
 * File Name:JavaVMStackSOF.java
 * Package Name:com.leonxi.javase.jvm.deepinsidejvmbook.chapter02
 * Date:2018年1月24日下午6:31:45
 * Copyright (c) 2018, 【Leon Xi】 All Rights Reserved.
 *
*/

package com.leonxi.javase.jvm.deepinsidejvmbook.chapter02;
/**
 * 清单2-4.txt
 * ClassName:JavaVMStackSOF <br/>
 * Date:     2018年1月24日 下午6:31:45 <br/>
 * @author   Leon Xi
 * @version  v1.0
 * @see 	 
 */
/**
 * VM Args：-Xss128k
 * @author zzm
 */
public class JavaVMStackSOF {

	private int stackLength = 1;

	public void stackLeak() {
		stackLength++;
		stackLeak();
	}

	public static void main(String[] args) throws Throwable {
		JavaVMStackSOF oom = new JavaVMStackSOF();
		try {
			oom.stackLeak();
		} catch (Throwable e) {
			System.out.println("stack length:" + oom.stackLength);
			throw e;
		}
	}
}

