/**
 * Project Name:javase_review
 * File Name:VolatileFeaturesExample1.java
 * Package Name:com.leonxi.javase.juc.artconcurrentbook.chapter03
 * Date:2018年1月22日下午11:35:53
 * Copyright (c) 2018, 【Leon Xi】 All Rights Reserved.
 *
*/

package com.leonxi.javase.juc.artconcurrentbook.chapter03;
/**
 * ClassName:VolatileFeaturesExample1 <br/>
 * Date:     2018年1月22日 下午11:35:53 <br/>
 * @author   Leon Xi
 * @version  v1.0
 * @see 	 
 */
class VolatileFeaturesExample1 {
    long vl = 0L; // 64位的long型普通变量

    public synchronized void set(long l) {//对单个的普通变量的写用同一个锁同步
        vl = l;
    }

    public void getAndIncrement() { //普通方法调用
        long temp = get(); //调用已同步的读方法
        temp += 1L; //普通写操作
        set(temp); //调用已同步的写方法
    }

    public synchronized long get() { //对单个的普通变量的读用同一个锁同步
        return vl;
    }
}

