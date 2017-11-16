/**
 * Project Name:javase_review
 * File Name:SuppressWarningsTest.java
 * Package Name:org.leonxi.javase.zhanglong.day11.annotation.demo01
 * Date:2017年10月20日上午11:56:50
 * Copyright (c) 2017, 【Leon Xi】 All Rights Reserved.
 *
*/

package org.leonxi.javase.zhanglong.day11.annotation.demo01.inner_annotation;

import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

/**
 * ClassName:SuppressWarningsTest <br/>
 * Date:     2017年10月20日 上午11:56:50 <br/>
 * @author   Leon Xi
 * @version  v1.0
 * @see 	 
 * @SuppressWarnings:里面的值，在每个JDK里面实现都不一样，需要查看规范，记住常用的就OK。
 * 
 */
public class SuppressWarningsTest {
	
	@SuppressWarnings({"rawtypes","unchecked","deprecation"})
	public static void main(String[] args) {
		
		Map map = new TreeMap();
		
		map.put("helloDate", new Date()) ;
		
		System.out.println(map.get("helloDate"));
		
		Date date = new Date() ;
		System.out.println(date.toLocaleString());
	}

}

