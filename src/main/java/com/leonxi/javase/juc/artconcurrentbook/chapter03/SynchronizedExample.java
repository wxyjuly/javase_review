/**
 * Project Name:javase_review
 * File Name:SynchronizedExample.java
 * Package Name:com.leonxi.javase.juc.artconcurrentbook.chapter03
 * Date:2018年1月22日下午11:30:04
 * Copyright (c) 2018, 【Leon Xi】 All Rights Reserved.
 *
*/

package com.leonxi.javase.juc.artconcurrentbook.chapter03;
/**
 * ClassName:SynchronizedExample <br/>
 * Date:     2018年1月22日 下午11:30:04 <br/>
 * @author   Leon Xi
 * @version  v1.0
 * @see 	 
 */
class SynchronizedExample {
    int     a    = 0;
    boolean flag = false;

    public synchronized void writer() { //获取锁
        a = 1;
        flag = true;
    } //释放锁

    public synchronized void reader() { //获取锁
        if (flag) {
            int i = a;
            //……
        } //释放锁
    }
}

