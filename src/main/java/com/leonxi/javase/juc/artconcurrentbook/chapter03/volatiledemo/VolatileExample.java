/**
 * Project Name:javase_review
 * File Name:VolatileExample.java
 * Package Name:com.leonxi.javase.juc.artconcurrentbook.chapter03
 * Date:2018年1月22日下午11:33:43
 * Copyright (c) 2018, 【Leon Xi】 All Rights Reserved.
 *
*/

package com.leonxi.javase.juc.artconcurrentbook.chapter03.volatiledemo;
/**
 * ClassName:VolatileExample <br/>
 * Date:     2018年1月22日 下午11:33:43 <br/>
 * @author   Leon Xi
 * @version  v1.0
 * @see 	 
 */
class VolatileExample {
    int              a    = 0;
    volatile boolean flag = false;

    public void writer() {
        a = 1; //1
        flag = true; //2
    }

    public void reader() {
        if (flag) { //3
            int i = a; //4
            //……
        }
    }
}

