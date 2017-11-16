/**
 * Project Name:javase_review
 * File Name:AnnotationUsage.java
 * Package Name:org.leonxi.javase.zhanglong.day11.annotation.demo01.self_annotation
 * Date:2017年10月20日下午2:59:25
 * Copyright (c) 2017, 【Leon Xi】 All Rights Reserved.
 *
*/

package org.leonxi.javase.zhanglong.day11.annotation.demo01.self_annotation.test;

import org.leonxi.javase.zhanglong.day11.annotation.demo01.self_annotation.AnnotationTest;
import org.leonxi.javase.zhanglong.day11.annotation.demo01.self_annotation.AnnotationWithParamTest;
import org.leonxi.javase.zhanglong.day11.annotation.demo01.self_annotation.AnnotationWithValueEnumTest;
import org.leonxi.javase.zhanglong.day11.annotation.demo01.self_annotation.AnnotationWithValueTest;
import org.leonxi.javase.zhanglong.day11.annotation.demo01.self_annotation.EnumAnnotation;

/**
 * ClassName:AnnotationUsage <br/>
 * Date:     2017年10月20日 下午2:59:25 <br/>
 * @author   Leon Xi
 * @version  v1.0
 * @see 	 
 */
@AnnotationTest
public class AnnotationUsage {

	@AnnotationTest
	public static void main(String[] args) {
		System.out.println("use of self define Annotation...");
	}
	
	//Annotation在只有一个参数的时候，并且定义为value;可以不写value.
	@AnnotationWithParamTest(value = "Hello Annotation")
	public void annotationTest1() { }
	@AnnotationWithParamTest("Hello Annotation")
	public void annotationTest2() {	}
	
	//Annotation在只有一个参数的时候，定义为其他value1，需要写.
	@AnnotationWithValueTest(value1="Hello Annotation")
	public void annotationTest3() {	}
	
	@AnnotationWithValueEnumTest(value="Hello", value2=EnumAnnotation.Hello)
	public void annotationTestUseEnum4() {	}
}

