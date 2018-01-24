/**
 * Project Name:javase_review
 * File Name:CyclicBarrierTest.java
 * Package Name:com.leonxi.javase.juc.artconcurrentbook.chapter08
 * Date:2018年1月24日上午11:45:37
 * Copyright (c) 2018, 【Leon Xi】 All Rights Reserved.
 *
*/

package com.leonxi.javase.juc.artconcurrentbook.chapter08;
/**
 * ClassName:CyclicBarrierTest <br/>
 * Date:     2018年1月24日 上午11:45:37 <br/>
 * @author   Leon Xi
 * @version  v1.0
 * @see 	 
 */
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {

    static CyclicBarrier c = new CyclicBarrier(2);

    public static void main(String[] args) {
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    c.await();
                } catch (Exception e) {

                }
                System.out.println(1);
            }
        }).start();

        try {
            c.await();
        } catch (Exception e) {

        }
        System.out.println(2);
    }
}

