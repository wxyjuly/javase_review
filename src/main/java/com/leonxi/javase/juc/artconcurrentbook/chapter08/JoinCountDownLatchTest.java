/**
 * Project Name:javase_review
 * File Name:JoinCountDownLatchTest.java
 * Package Name:com.leonxi.javase.juc.artconcurrentbook.chapter08
 * Date:2018年1月24日上午11:42:23
 * Copyright (c) 2018, 【Leon Xi】 All Rights Reserved.
 *
*/

package com.leonxi.javase.juc.artconcurrentbook.chapter08;
/**
 * ClassName:JoinCountDownLatchTest <br/>
 * Date:     2018年1月24日 上午11:42:23 <br/>
 * @author   Leon Xi
 * @version  v1.0
 * @see 	 
 */
/**
 * 
 * @author tengfei.fangtf
 * @version $Id: JoinCountDownLatchTest.java, v 0.1 2015-8-1 上午12:08:30 tengfei.fangtf Exp $
 */
public class JoinCountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {
        Thread parser1 = new Thread(new Runnable() {
            @Override
            public void run() {
            }
        });

        Thread parser2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("parser2 finish");
            }
        });

        parser1.start();
        parser2.start();
        parser1.join();
        parser2.join();
        System.out.println("all parser finish");
    }
}


