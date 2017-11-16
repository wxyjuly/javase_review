/**
 * Project Name:javase_review
 * File Name:AnnotationTest.java
 * Package Name:org.leonxi.javase.zhanglong.day11.annotation.demo01.self_annotation
 * Date:2017年10月20日下午2:56:51
 * Copyright (c) 2017, 【Leon Xi】 All Rights Reserved.
 *
*/

package org.leonxi.javase.zhanglong.day11.annotation.demo01.self_annotation;
/**
 * ClassName:AnnotationTest <br/>
 * Date:     2017年10月20日 下午2:56:51 <br/>
 * @author   Leon Xi
 * @version  v1.0
 * @see 	
 *  
 * 自定义Annotation:定义一个带参数的Annotation
 * interface定义接口
 * @interface定义注解
 */

public @interface AnnotationWithValueEnumTest {
	String value() default "Hello";
	EnumAnnotation value2() ; 
}

//注意default的作用范围
enum EnumTest {
	HELLO, LEON, XI
}

