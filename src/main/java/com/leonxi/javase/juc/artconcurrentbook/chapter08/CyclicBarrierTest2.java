/**
 * Project Name:javase_review
 * File Name:CyclicBarrierTest2.java
 * Package Name:com.leonxi.javase.juc.artconcurrentbook.chapter08
 * Date:2018年1月24日上午11:45:00
 * Copyright (c) 2018, 【Leon Xi】 All Rights Reserved.
 *
*/

package com.leonxi.javase.juc.artconcurrentbook.chapter08;
/**
 * ClassName:CyclicBarrierTest2 <br/>
 * Date:     2018年1月24日 上午11:45:00 <br/>
 * @author   Leon Xi
 * @version  v1.0
 * @see 	 
 */
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest2 {

    static CyclicBarrier c = new CyclicBarrier(2, new A());

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

    static class A implements Runnable {

        @Override
        public void run() {
            System.out.println(3);
        }

    }

}


