/**
 * Project Name:javase_review_20171005
 * File Name:ComputerHandleBasicVarOverflow.java
 * Package Name:org.leonxi.javase.day02.basic
 * Date:2017年10月5日上午10:36:17
 * Copyright (c) 2017, 【Leon Xi】 All Rights Reserved.
 *
*/

package org.leonxi.javase.liuyi.day02.basic;
/**
 * ClassName:ComputerHandleBasicVarOverflow <br/>
 * Date:     2017年10月5日 上午10:36:17 <br/>
 * @author   Leon Xi
 * @version  v1.0
 * @see
 * 
	 byte b = 130;有没有问题? 如果我想让赋值正确，可以怎么做? 结果是多少呢?    
	    练习：byte b = (byte)300;	 
 */
public class ComputerHandleBasicVarOverflow {

	public static void main(String[] args) {
		testByte130Overflow();
	}
	public static void testByte130Overflow() {
//		byte b = 130 ; //Type mismatch: cannot convert from int to byte
		byte b = (byte) 130 ; 
		System.out.println("byte contain 130-->" + b);  // -126
		/* 分析过程【[计算补码]-》[按类型长度截取]-》[补码算原码]】：
		        我们要想知道结果是什么，就应该知道计算机是如何进行计算的。
		        而我们又知道计算机中数据的运算都是补码进行的。
		        而要得到补码，首先要计算出数据的二进制。        
		        A:获取130这个数据的二进制。
		            00000000 00000000 00000000 10000010
		            这是130的[原码]，也是[反码]，还是[补码]。
		        B:做截取操作，截成byte类型的了。
		            10000010 
		            这个结果是[补码]。
		        C:已知[补码求原码]。
		                       符号位        数值位
		            补码：    1            0000010            
		            反码：    1            0000001            
		            原码：    1            1111110		 
		 */
	}
}

