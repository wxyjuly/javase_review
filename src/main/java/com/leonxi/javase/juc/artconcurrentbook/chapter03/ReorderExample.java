/**
 * Project Name:javase_review
 * File Name:ReorderExample.java
 * Package Name:com.leonxi.javase.juc.artconcurrentbook.chapter03
 * Date:2018年1月22日下午11:27:19
 * Copyright (c) 2018, 【Leon Xi】 All Rights Reserved.
 *
*/

package com.leonxi.javase.juc.artconcurrentbook.chapter03;
/**
 * ClassName:ReorderExample <br/>
 * Date:     2018年1月22日 下午11:27:19 <br/>
 * @author   Leon Xi
 * @version  v1.0
 * @see 	 
 */
class ReorderExample {
    int     a    = 0;
    boolean flag = false;

    public void writer() {
        a = 1; //1
        flag = true; //2
    }

    public void reader() {
        if (flag) { //3
            int i = a * a; //4
            //s……
        }
    }
}

