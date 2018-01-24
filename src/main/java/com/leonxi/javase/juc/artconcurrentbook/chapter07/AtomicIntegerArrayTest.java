/**
 * Project Name:javase_review
 * File Name:AtomicIntegerArrayTest.java
 * Package Name:com.leonxi.javase.juc.artconcurrentbook.chapter06
 * Date:2018年1月24日上午11:04:24
 * Copyright (c) 2018, 【Leon Xi】 All Rights Reserved.
 *
*/

package com.leonxi.javase.juc.artconcurrentbook.chapter07 ;
/**
 * ClassName:AtomicIntegerArrayTest <br/>
 * Date:     2018年1月24日 上午11:04:24 <br/>
 * @author   Leon Xi
 * @version  v1.0
 * @see 	 
 */
import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * 
 * @author tengfei.fangtf
 * @version $Id: AtomicIntegerArrayTest.java, v 0.1 2015-8-1 上午12:04:44 tengfei.fangtf Exp $
 */
public class AtomicIntegerArrayTest {

    static int[]              value = new int[] { 1, 2 };

    static AtomicIntegerArray ai    = new AtomicIntegerArray(value);

    public static void main(String[] args) {
        ai.getAndSet(0, 3);
        System.out.println(ai.get(0));
        System.out.println(value[0]);
    }

}

