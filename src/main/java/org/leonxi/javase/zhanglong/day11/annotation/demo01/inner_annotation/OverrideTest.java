/**
 * Project Name:javase_review
 * File Name:OverrideTest.java
 * Package Name:org.leonxi.javase.zhanglong.day11.annotation.demo01
 * Date:2017年10月20日上午11:31:21
 * Copyright (c) 2017, 【Leon Xi】 All Rights Reserved.
 *
*/

package org.leonxi.javase.zhanglong.day11.annotation.demo01.inner_annotation;
/**
 * ClassName:OverrideTest <br/>
 * Date:     2017年10月20日 上午11:31:21 <br/>
 * @author   Leon Xi
 * @version  v1.0
 * @see 	 
 */
public class OverrideTest {

	public static void main(String[] args) {
		System.out.println(new OverrideTest()) ;
	}

	@Override
	public String toString() {
		return "OverrideTest-->Override parent...";
	}

}

