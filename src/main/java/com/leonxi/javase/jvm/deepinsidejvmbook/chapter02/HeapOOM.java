/**
 * Project Name:javase_review
 * File Name:HeapOOM.java
 * Package Name:com.leonxi.javase.jvm.deepinsidejvmbook
 * Date:2018年1月24日下午6:25:17
 * Copyright (c) 2018, 【Leon Xi】 All Rights Reserved.
 *
*/

package com.leonxi.javase.jvm.deepinsidejvmbook.chapter02 ;

import java.util.ArrayList;
import java.util.List;

/**
 * 清单2-3.txt
 * ClassName:HeapOOM <br/>
 * Date:     2018年1月24日 下午6:25:17 <br/>
 * @author   Leon Xi
 * @version  v1.0
 * @see 	 
 */
/**
 * VM Args：-Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * @author zzm
 */
public class HeapOOM {

	static class OOMObject {
	}

	public static void main(String[] args) {
		List<OOMObject> list = new ArrayList<OOMObject>();

		while (true) {
			list.add(new OOMObject());
		}
	}
}

