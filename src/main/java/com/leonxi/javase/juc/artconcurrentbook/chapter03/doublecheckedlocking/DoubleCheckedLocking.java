/**
 * Project Name:javase_review
 * File Name:DoubleCheckedLocking.java
 * Package Name:com.leonxi.javase.juc.artconcurrentbook.chapter02
 * Date:2018年1月22日下午11:10:54
 * Copyright (c) 2018, 【Leon Xi】 All Rights Reserved.
 *
*/

package com.leonxi.javase.juc.artconcurrentbook.chapter03.doublecheckedlocking ;

/**
 * 单例双向检测锁,存在bug
 * ClassName:DoubleCheckedLocking <br/>
 * Date:     2018年1月22日 下午11:10:54 <br/>
 * @author   Leon Xi
 * @version  v1.0
 * @see 	 
 */
public class DoubleCheckedLocking { //1
    private static Instance instance; //2

    public static Instance getInstance() { //3
        if (instance == null) { //4:第一次检查
            synchronized (DoubleCheckedLocking.class) { //5:加锁
                if (instance == null) //6:第二次检查
                    instance = new Instance(); //7:问题的根源出在这里
            } //8
        } //9
        return instance; //10
    } //11

    static class Instance {
    }
}

