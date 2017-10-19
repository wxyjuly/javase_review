/**
 * Project Name:javase_review_20171005
 * File Name:CompareVarableAndConstAdd.java
 * Package Name:org.leonxi.javase.day02.basic
 * Date:2017年10月5日上午10:26:55
 * Copyright (c) 2017, 【Leon Xi】 All Rights Reserved.

    面试题：
        byte b1=3,b2=4,b;
        b=b1+b2;  
        b=3+4;
        哪句是编译失败的呢？为什么呢？
        b = b1 + b2;是有问题的。
        因为
        【变量相加】，会首先看类型问题，最终把结果赋值的也会考虑类型问题。
        【常量相加】，首先做加法，然后看结果是否在赋值的数据类型范围内，如果不是，才报错｛编译器优化，会直接计算结果｝。
*/

package org.leonxi.javase.liuyi.day02.basic;
/**
 * ClassName:CompareVarableAndConstAdd <br/>
 * Date:     2017年10月5日 上午10:26:55 <br/>
 * @author   Leon Xi
 * @version  v1.0
 * @see 	 
 */
public class CompareVarAddAndConstAdd {
	
	public static void test() {
		byte b1 = 3, b2 = 4, b ;
//		b = b1 + b2 ;  //变量相加，会出现类型提升【会报错】。
		b=3+4 ;		   // 常量相加，在编译阶段计算，然后看是否草果范围，未超过直接保存
		
		System.out.println(b);
	}

	public static void main(String[] args) {
		test();
	}

}

