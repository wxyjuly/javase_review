/**
 * Project Name:javase_review
 * File Name:AnnotationRetentionTest.java
 * Package Name:org.leonxi.javase.zhanglong.day11.annotation.demo01.self_annotation
 * Date:2017年10月20日下午4:28:07
 * Copyright (c) 2017, 【Leon Xi】 All Rights Reserved.
 *
*/

package org.leonxi.javase.zhanglong.day11.annotation.demo01.self_annotation;

import static java.lang.annotation.RetentionPolicy.CLASS;

import java.lang.annotation.Retention;

@Retention(CLASS)
/**
 * ClassName:AnnotationRetentionTest <br/>
 * Date:     2017年10月20日 下午4:28:07 <br/>
 * @author   Leon Xi
 * @version  v1.0
 * @see 	 
 */
public @interface AnnotationRetentionTest {
	String value();
}

