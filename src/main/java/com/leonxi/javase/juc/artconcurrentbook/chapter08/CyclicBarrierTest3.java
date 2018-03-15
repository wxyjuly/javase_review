/**
 * Project Name:javase_review
 * File Name:CyclicBarrierTest3.java
 * Package Name:com.leonxi.javase.juc.artconcurrentbook.chapter08
 * Date:2018年1月24日上午11:44:12
 * Copyright (c) 2018, 【Leon Xi】 All Rights Reserved.
 *
*/

package com.leonxi.javase.juc.artconcurrentbook.chapter08;
/**
 * ClassName:CyclicBarrierTest3 <br/>
 * Date:     2018年1月24日 上午11:44:12 <br/>
 * @author   Leon Xi
 * @version  v1.0
 * @see 	 
 */
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 
 * @author tengfei.fangtf
 * @version $Id: CyclicBarrierTest3.java, v 0.1 2015-8-1 上午12:09:37 tengfei.fangtf Exp $
 */
public class CyclicBarrierTest3 {

    static CyclicBarrier c = new CyclicBarrier(2);

    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    c.await();
                } catch (Exception e) {
                }
            }
        });
        thread.start();
        thread.interrupt();
        try {
            c.await();
        } catch (Exception e) {
            System.out.println(c.isBroken());
        }
    }
}


