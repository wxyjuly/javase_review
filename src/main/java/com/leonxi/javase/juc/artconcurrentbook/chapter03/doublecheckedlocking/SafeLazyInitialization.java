/**
 * Project Name:javase_review
 * File Name:SafeLazyInitialization.java
 * Package Name:com.leonxi.javase.juc.artconcurrentbook.chapter03.doublecheckedlocking
 * Date:2018年1月22日下午11:29:20
 * Copyright (c) 2018, 【Leon Xi】 All Rights Reserved.
 *
*/

package com.leonxi.javase.juc.artconcurrentbook.chapter03.doublecheckedlocking;

/**
 * ClassName:SafeLazyInitialization <br/>
 * Date:     2018年1月22日 下午11:29:20 <br/>
 * @author   Leon Xi
 * @version  v1.0
 * @see 	 
 */
public class SafeLazyInitialization {
    private static Instance instance;

    public synchronized static Instance getInstance() {
        if (instance == null)
            instance = new Instance();
        return instance;
    }

    static class Instance {
    }
}

