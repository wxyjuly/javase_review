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
 * 测试@Deprecated标签
 */
public class DeprecatedTest {
	
	@Deprecated
	public void testDeprecatedAnnotation() {
		System.out.println("@Deprecated-->testDeprecatedAnnotation");
	}

	public static void main(String[] args) {
		new DeprecatedTest().testDeprecatedAnnotation() ;
	}

}

