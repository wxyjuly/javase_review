/**
 * Project Name:javase_review
 * File Name:FinalReferenceExample.java
 * Package Name:com.leonxi.javase.juc.artconcurrentbook.chapter03
 * Date:2018年1月22日下午11:16:33
 * Copyright (c) 2018, 【Leon Xi】 All Rights Reserved.
 *
*/

package com.leonxi.javase.juc.artconcurrentbook.chapter03;

/**
 * ClassName:FinalReferenceExample <br/>
 * Date:     2018年1月22日 下午11:16:33 <br/>
 * @author   Leon Xi
 * @version  v1.0
 * @see 	 
 */

public class FinalReferenceExample {
    final int[]                  intArray; //final是引用类型
    static FinalReferenceExample obj;

    public FinalReferenceExample() { //构造函数
        intArray = new int[1]; //1
        intArray[0] = 1; //2
    }

    public static void writerOne() { //写线程A执行
        obj = new FinalReferenceExample(); //3
    }

    public static void writerTwo() { //写线程B执行
        obj.intArray[0] = 2; //4
    }

    public static void reader() { //读线程C执行
        if (obj != null) { //5
            int temp1 = obj.intArray[0]; //6
        }
    }
}

