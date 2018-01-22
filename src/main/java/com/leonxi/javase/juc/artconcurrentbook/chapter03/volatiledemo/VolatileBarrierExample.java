/**
 * Project Name:javase_review
 * File Name:VolatileBarrierExample.java
 * Package Name:com.leonxi.javase.juc.artconcurrentbook.chapter03
 * Date:2018年1月22日下午11:32:31
 * Copyright (c) 2018, 【Leon Xi】 All Rights Reserved.
 *
*/

package com.leonxi.javase.juc.artconcurrentbook.chapter03.volatiledemo;
/**
 * ClassName:VolatileBarrierExample <br/>
 * Date:     2018年1月22日 下午11:32:31 <br/>
 * @author   Leon Xi
 * @version  v1.0
 * @see 	 
 */
class VolatileBarrierExample {
    int          a;
    volatile int v1 = 1;
    volatile int v2 = 2;

    void readAndWrite() {
        int i = v1; //第一个volatile读
        int j = v2; // 第二个volatile读
        a = i + j; //普通写
        v1 = i + 1; // 第一个volatile写
        v2 = j * 2; //第二个 volatile写
    }

    //…                 //其他方法
}

/**
 	反编译：javap -verbose VolatileBarrierExample.class
 	
 */
