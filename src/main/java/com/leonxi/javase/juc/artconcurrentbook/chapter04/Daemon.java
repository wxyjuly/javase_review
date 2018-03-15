/**
 * Project Name:javase_review
 * File Name:Daemon.java
 * Package Name:com.leonxi.javase.juc.artconcurrentbook.chapter03
 * Date:2018年1月24日上午9:42:04
 * Copyright (c) 2018, 【Leon Xi】 All Rights Reserved.
 *
*/

package com.leonxi.javase.juc.artconcurrentbook.chapter04 ;
/**
 * ClassName:Daemon <br/>
 * Date:     2018年1月24日 上午9:42:04 <br/>
 * @author   Leon Xi
 * @version  v1.0
 * @see 	 
 * 4-5
 */
public class Daemon {

    public static void main(String[] args) {
        Thread thread = new Thread(new DaemonRunner());
        thread.setDaemon(true);
        thread.start();
        System.out.println("main thread exit..."); //added
        
    }

    static class DaemonRunner implements Runnable {
        @Override
        public void run() {
            try {
            	System.out.println("DaemonThread start run."); //added
                SleepUtils.second(100);
            } finally {
                System.out.println("DaemonThread finally run.");
            }
        }
    }
}

