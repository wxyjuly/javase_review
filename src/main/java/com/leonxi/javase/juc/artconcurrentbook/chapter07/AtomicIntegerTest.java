/**
 * Project Name:javase_review
 * File Name:AtomicIntegerTest.java
 * Package Name:com.leonxi.javase.juc.artconcurrentbook.chapter07
 * Date:2018年1月24日上午11:05:32
 * Copyright (c) 2018, 【Leon Xi】 All Rights Reserved.
 *
*/

package com.leonxi.javase.juc.artconcurrentbook.chapter07;
/**
 * ClassName:AtomicIntegerTest <br/>
 * Date:     2018年1月24日 上午11:05:32 <br/>
 * @author   Leon Xi
 * @version  v1.0
 * @see 	 
 */
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 
 * @author tengfei.fangtf
 * @version $Id: AtomicIntegerTest.java, v 0.1 2015-8-1 上午12:13:16 tengfei.fangtf Exp $
 */
public class AtomicIntegerTest {

    static AtomicInteger ai = new AtomicInteger(1);

    public static void main(String[] args) {
        System.out.println(ai.getAndIncrement());
        System.out.println(ai.get());
    }

}

