/**
 * Project Name:javase_review
 * File Name:UnsafeLazyInitialization.java
 * Package Name:com.leonxi.javase.juc.artconcurrentbook.chapter03.doublecheckedlocking
 * Date:2018年1月22日下午11:30:52
 * Copyright (c) 2018, 【Leon Xi】 All Rights Reserved.
 *
*/

package com.leonxi.javase.juc.artconcurrentbook.chapter03.doublecheckedlocking;

/**
 * ClassName:UnsafeLazyInitialization <br/>
 * Date:     2018年1月22日 下午11:30:52 <br/>
 * @author   Leon Xi
 * @version  v1.0
 * @see 	 
 */
public class UnsafeLazyInitialization {
    private static Instance instance;

    public static Instance getInstance() {
        if (instance == null) //1：A线程执行
            instance = new Instance(); //2：B线程执行
        return instance;
    }

    static class Instance {
    }
}

