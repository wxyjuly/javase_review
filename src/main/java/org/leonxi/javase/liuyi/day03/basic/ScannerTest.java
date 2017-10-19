/**
 * Project Name:javase_review_20171005
 * File Name:ScannerTest.java
 * Package Name:org.leonxi.javase.day03.basic
 * Date:2017年10月5日下午9:25:16
 * Copyright (c) 2017, 【Leon Xi】 All Rights Reserved.
 *
*/

package org.leonxi.javase.liuyi.day03.basic;

import java.util.Scanner;

/**
 * ClassName:ScannerTest <br/>
 * Date:     2017年10月5日 下午9:25:16 <br/>
 * @author   Leon Xi
 * @version  v1.0
 * @see 	 
 */
public class ScannerTest {

	public static void main(String[] args) {
//		scannerInputAIntNo();	
//		scannerInputNoAdd();
		getMaxScannerInputNo();
	}

	/*
	 * Scanner Test 1
	 */
	public static void scannerInputAIntNo() {
		Scanner scanner = new Scanner(System.in) ; //创建键盘录入数据对象
		System.out.println("请输入整数,范围["+Integer.MIN_VALUE+"-"+Integer.MAX_VALUE+"]:");
		int i = scanner.nextInt() ; // can block
		System.out.println("您输入的整数是："+i);
		scanner.close();
	}
	
	/*
	 * Scanner Test 2
	 * 键盘录入练习：
		键盘录入两个数据，并对这两个数据求和，输出其结果
	 */
	public static void scannerInputNoAdd() {
		Scanner scanner = new Scanner(System.in) ;
		System.out.println("请输入2整数,以（空格或者回车分隔）范围["+Integer.MIN_VALUE+"-"+Integer.MAX_VALUE+"]:");
		int x = scanner.nextInt() ;
		int y = scanner.nextInt() ;
		System.out.println(x + "+" + y + "=" + (x+y));
		scanner.close();
	}

	/*
	 * Scanner Test 3
	        键盘录入练习：键盘录入两个数据，获取这两个数据中的最大值
	 */
	public static void getMaxScannerInputNo() {
		Scanner scanner = new Scanner(System.in) ;
		System.out.println("请输入第一个整数,范围["+Integer.MIN_VALUE+"-"+Integer.MAX_VALUE+"]:");
		int x = scanner.nextInt() ;
		System.out.println("请输入第二个整数,范围["+Integer.MIN_VALUE+"-"+Integer.MAX_VALUE+"]:");
		int y = scanner.nextInt() ;
		int max = (x > y ? x : y ) ;
		System.out.println(x + "与" + y + "中较大的一个数是:" + max);
		scanner.close();
	}
}

