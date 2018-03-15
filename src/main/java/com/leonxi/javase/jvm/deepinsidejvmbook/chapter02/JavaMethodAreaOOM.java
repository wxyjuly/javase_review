/**
 * Project Name:javase_review
 * File Name:JavaMethodAreaOOM.java
 * Package Name:com.leonxi.javase.jvm.deepinsidejvmbook.chapter02
 * Date:2018年1月26日下午12:38:27
 * Copyright (c) 2018, 【Leon Xi】 All Rights Reserved.
 *
*/

package com.leonxi.javase.jvm.deepinsidejvmbook.chapter02;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodProxy;


/**
 * 2-8
 * ClassName:JavaMethodAreaOOM <br/>
 * Date:     2018年1月26日 下午12:38:27 <br/>
 * @author   Leon Xi
 * @version  v1.0
 * @see 	 
 */
/**
 * VM Args： -XX:PermSize=10M -XX:MaxPermSize=10M
 * @author zzm
 */
public class JavaMethodAreaOOM {

	public static void main(String[] args) {
		while (true) {
			Enhancer enhancer = new Enhancer();
			enhancer.setSuperclass(OOMObject.class);
			enhancer.setUseCache(false);
			enhancer.setCallback(new MethodInterceptor() {
				public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
					return proxy.invokeSuper(obj, args);
				}
			});
			enhancer.create();
		}
	}

	static class OOMObject {

	}
}

