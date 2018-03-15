/**
 * Project Name:javase_review
 * File Name:SafeDoubleCheckedLocking.java
 * Package Name:com.leonxi.javase.juc.artconcurrentbook.chapter03.doublecheckedlocking
 * Date:2018年1月22日下午11:28:09
 * Copyright (c) 2018, 【Leon Xi】 All Rights Reserved.
 *
*/

package com.leonxi.javase.juc.artconcurrentbook.chapter03.doublecheckedlocking;

/**
 * ClassName:SafeDoubleCheckedLocking <br/>
 * Date:     2018年1月22日 下午11:28:09 <br/>
 * @author   Leon Xi
 * @version  v1.0
 * @see 	 
 */
public class SafeDoubleCheckedLocking {
    private volatile static Instance instance; //通过volatile，让变量立即可见

    public static Instance getInstance() {
        if (instance == null) {
            synchronized (SafeDoubleCheckedLocking.class) {
                if (instance == null)
                    instance = new Instance();//instance为volatile，现在没问题了
            }
        }
        return instance;
    }

    static class Instance {
    }
}

