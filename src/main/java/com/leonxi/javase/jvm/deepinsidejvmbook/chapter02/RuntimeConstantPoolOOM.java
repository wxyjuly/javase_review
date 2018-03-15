/**
 * Project Name:javase_review
 * File Name:RuntimeConstantPoolOOM.java
 * Package Name:com.leonxi.javase.jvm.deepinsidejvmbook.chapter02
 * Date:2018年1月26日下午12:34:00
 * Copyright (c) 2018, 【Leon Xi】 All Rights Reserved.
 *
*/

package com.leonxi.javase.jvm.deepinsidejvmbook.chapter02;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:RuntimeConstantPoolOOM <br/>
 * Date:     2018年1月26日 下午12:34:00 <br/>
 * @author   Leon Xi
 * @version  v1.0
 * @see 	 
 */
/**
 * 2-6
 * VM Args：-XX:PermSize=10M -XX:MaxPermSize=10M
 * @author zzm
 */
public class RuntimeConstantPoolOOM {

	public static void main(String[] args) {
		// 使用List保持着常量池引用，避免Full GC回收常量池行为
		List<String> list = new ArrayList<String>();
		// 10MB的PermSize在integer范围内足够产生OOM了
		int i = 0; 
		while (true) {
			list.add(String.valueOf(i++).intern());
		}
	}
}
