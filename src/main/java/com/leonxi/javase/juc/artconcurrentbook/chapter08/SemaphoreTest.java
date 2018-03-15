/**
 * Project Name:javase_review
 * File Name:SemaphoreTest.java
 * Package Name:com.leonxi.javase.juc.artconcurrentbook.chapter07
 * Date:2018年1月24日上午11:40:22
 * Copyright (c) 2018, 【Leon Xi】 All Rights Reserved.
 *
*/

package com.leonxi.javase.juc.artconcurrentbook.chapter08 ;
/**
 * ClassName:SemaphoreTest <br/>
 * Date:     2018年1月24日 上午11:40:22 <br/>
 * @author   Leon Xi
 * @version  v1.0
 * @see 	 
 */
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 
 * @author tengfei.fangtf
 * @version $Id: SemaphoreTest.java, v 0.1 2015-8-1 上午12:10:19 tengfei.fangtf Exp $
 */
public class SemaphoreTest {

    private static final int       THREAD_COUNT = 30;

    private static ExecutorService threadPool   = Executors.newFixedThreadPool(THREAD_COUNT);

    private static Semaphore       s            = new Semaphore(10);

    public static void main(String[] args) {
        for (int i = 0; i < THREAD_COUNT; i++) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        s.acquire();
                        System.out.println("save data");
                        s.release();
                    } catch (InterruptedException e) {
                    }
                }
            });
        }

        threadPool.shutdown();
    }
}


