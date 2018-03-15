/**
 * Project Name:javase_review
 * File Name:FinalReferenceEscapeExample.java
 * Package Name:com.leonxi.javase.juc.artconcurrentbook.chapter03
 * Date:2018年1月22日下午11:15:23
 * Copyright (c) 2018, 【Leon Xi】 All Rights Reserved.
 *
*/

package com.leonxi.javase.juc.artconcurrentbook.chapter03;

/**
 * ClassName:FinalReferenceEscapeExample <br/>
 * Date:     2018年1月22日 下午11:15:23 <br/>
 * @author   Leon Xi
 * @version  v1.0
 * @see 	 
 */
public class FinalReferenceEscapeExample {

    final int                          i;
    static FinalReferenceEscapeExample obj;

    public FinalReferenceEscapeExample() {
        i = 1; //1写final域
        obj = this; //2 this引用在此“逸出”
    }

    public static void writer() {
        new FinalReferenceEscapeExample();
    }

    public static void reader() {
        if (obj != null) { //3
            int temp = obj.i; //4
        }
    }
}


