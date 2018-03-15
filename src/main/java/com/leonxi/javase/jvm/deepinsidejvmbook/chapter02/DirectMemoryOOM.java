/**
 * Project Name:javase_review
 * File Name:DirectMemoryOOM.java
 * Package Name:com.leonxi.javase.jvm.deepinsidejvmbook.chapter02
 * Date:2018年1月26日下午12:41:45
 * Copyright (c) 2018, 【Leon Xi】 All Rights Reserved.
 *
*/

package com.leonxi.javase.jvm.deepinsidejvmbook.chapter02;

import java.lang.reflect.Field;
import sun.misc.Unsafe ;

/**
 * ClassName:DirectMemoryOOM <br/>
 * Date:     2018年1月26日 下午12:41:45 <br/>
 * @author   Leon Xi
 * @version  v1.0
 * @see 	 
 */
/**
 * VM Args：-Xmx20M -XX:MaxDirectMemorySize=10M
 * @author zzm
 */
public class DirectMemoryOOM {

	private static final int _1MB = 1024 * 1024;

	public static void main(String[] args) throws Exception {
		Field unsafeField = Unsafe.class.getDeclaredFields()[0];
		unsafeField.setAccessible(true);
		Unsafe unsafe = (Unsafe) unsafeField.get(null);
		while (true) {
			unsafe.allocateMemory(_1MB);
		}
	}
}

