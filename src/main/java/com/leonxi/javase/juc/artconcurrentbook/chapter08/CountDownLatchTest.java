/**
 * Project Name:javase_review
 * File Name:CountDownLatchTest.java
 * Package Name:com.leonxi.javase.juc.artconcurrentbook.chapter08
 * Date:2018年1月24日上午11:48:06
 * Copyright (c) 2018, 【Leon Xi】 All Rights Reserved.
 *
*/

package com.leonxi.javase.juc.artconcurrentbook.chapter08;
/**
 * ClassName:CountDownLatchTest <br/>
 * Date:     2018年1月24日 上午11:48:06 <br/>
 * @author   Leon Xi
 * @version  v1.0
 * @see 	 
 */
import java.util.concurrent.CountDownLatch;

/**
 * 
 * @author tengfei.fangtf
 * @version $Id: CountDownLatchTest.java, v 0.1 2015-8-1 上午12:08:52 tengfei.fangtf Exp $
 */
public class CountDownLatchTest {

    static CountDownLatch c = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
                c.countDown();
                System.out.println(2);
                c.countDown();
            }
        }).start();

        c.await();
        System.out.println("3");
    }

}
