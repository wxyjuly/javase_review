/**
 * Project Name:javase_review
 * File Name:FinalExample.java
 * Package Name:com.leonxi.javase.juc.artconcurrentbook.chapter03.doublecheckedlocking
 * Date:2018年1月22日下午11:13:34
 * Copyright (c) 2018, 【Leon Xi】 All Rights Reserved.
 *
*/

package com.leonxi.javase.juc.artconcurrentbook.chapter03;

/**
 * ClassName:FinalExample <br/>
 * Date:     2018年1月22日 下午11:13:34 <br/>
 * @author   Leon Xi
 * @version  v1.0
 * @see 	 
 */
public class FinalExample {
    int                 i;  //普通变量
    final int           j;  //final变量
    static FinalExample obj;

    public FinalExample() { //构造函数
        i = 1; //写普通域
        j = 2; //写final域
    }

    public static void writer() { //写线程A执行
        obj = new FinalExample();
    }

    public static void reader() { //读线程B执行
        FinalExample object = obj; //读对象引用
        int a = object.i; //读普通域
        int b = object.j; //读final域
    }
}
