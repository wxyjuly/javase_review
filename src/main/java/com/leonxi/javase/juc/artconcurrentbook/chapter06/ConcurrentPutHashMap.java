/**
 * Project Name:javase_review
 * File Name:ConcurrentPutHashMap.java
 * Package Name:com.leonxi.javase.juc.artconcurrentbook.chapter06
 * Date:2018年1月24日上午11:01:10
 * Copyright (c) 2018, 【Leon Xi】 All Rights Reserved.
 *
*/

package com.leonxi.javase.juc.artconcurrentbook.chapter06;
/**
 * ClassName:ConcurrentPutHashMap <br/>
 * Date:     2018年1月24日 上午11:01:10 <br/>
 * @author   Leon Xi
 * @version  v1.0
 * @see 	 
 */
import java.util.HashMap;
import java.util.UUID;

/**
 * 并发put
 * 
 * @author tengfei.fangtf
 * @version $Id: Snippet.java, v 0.1 2015-7-31 下午11:53:55 tengfei.fangtf Exp $
 */
public class ConcurrentPutHashMap {

    public static void main(String[] args) throws InterruptedException {
        final HashMap<String, String> map = new HashMap<String, String>(2);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            map.put(UUID.randomUUID().toString(), "");
                        }
                    }, "ftf" + i).start();
                }
            }
        }, "ftf");
        t.start();
        t.join();
    }

}

