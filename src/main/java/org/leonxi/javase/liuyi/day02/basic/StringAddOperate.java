/**
 * Project Name:javase_review_20171005
 * File Name:StringAddOperate.java
 * Package Name:org.leonxi.javase.day02.basic
 * Date:2017年10月5日上午10:59:23
 * Copyright (c) 2017, 【Leon Xi】 All Rights Reserved.
 *
*/

package org.leonxi.javase.liuyi.day02.basic;
/**
 * ClassName:StringAddOperate <br/>
 * Date:     2017年10月5日 上午10:59:23 <br/>
 * @author   Leon Xi
 * @version  v1.0
 * @see 	 
 */
public class StringAddOperate {

	/*
	        字符串数据和其他数据做+，结果是字符串类型。
                    这里的+不是加法运算，而是字符串连接符
	 */
	public static void stringAdd() {
		String string = " AbcdefG " ;
		System.out.println(97 + 1 + string);
		System.out.println(string + 97 + 1);
		System.out.println(string + 97 + 1 + string);
		System.out.println(string + (97 + 1) + string);
	}
	
	public static void main(String[] args) {
		stringAdd() ; 
	}
}

