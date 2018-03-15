/**
 * Project Name:javase_review
 * File Name:RuntimeConstantPoolOOM2.java
 * Package Name:com.leonxi.javase.jvm.deepinsidejvmbook.chapter02
 * Date:2018年1月26日下午12:35:53
 * Copyright (c) 2018, 【Leon Xi】 All Rights Reserved.
 *
*/

package com.leonxi.javase.jvm.deepinsidejvmbook.chapter02;

/**
 * 2-7
 * ClassName:RuntimeConstantPoolOOM2 <br/>
 * Date: 2018年1月26日 下午12:35:53 <br/>
 * 
 * @author Leon Xi
 * @version v1.0
 * @see
 */
public class RuntimeConstantPoolOOM2 {

	public static void main(String[] args) {
		String str1 = new StringBuilder("中国").append("钓鱼岛").toString();
		System.out.println(str1.intern() == str1);

		String str2 = new StringBuilder("ja").append("va").toString();
		System.out.println(str2.intern() == str2);
	}
}
