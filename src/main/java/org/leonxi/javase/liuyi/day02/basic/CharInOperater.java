/**
 * Project Name:javase_review_20171005
 * File Name:CharInOperater.java
 * Package Name:org.leonxi.javase.day02.basic
 * Date:2017年10月5日上午10:45:58
 * Copyright (c) 2017, 【Leon Xi】 All Rights Reserved.
 *
*/

package org.leonxi.javase.liuyi.day02.basic;
/**
 * ClassName:CharInOperater <br/>
 * Date:     2017年10月5日 上午10:45:58 <br/>
 * @author   Leon Xi
 * @version  v1.0
 * @see 	 
 */
public class CharInOperater {
	
	public static void test() {
		char c = 'a' ;
		System.out.println(c);
		System.out.println(c+1); //字符数据参与运算:做加法或减法
		System.out.println(c-1); //字符数据参与运算:做加法或减法
	}
	
	/*
	 * 打印ASCII码
	 */
	public static void printASCII() {
		int cInt  ;
		char cChar  ;
		for (int i = 0; i < Byte.MAX_VALUE; i++) {
			cInt = i ;
			cChar = (char) i ;
			System.err.println(i + " " + cChar);
//			if (i%5==0) {
//				System.out.print("\n");
//			}
		}
	}
	public static void main(String[] args) {
		test();
//		printASCII() ;
	}

}

