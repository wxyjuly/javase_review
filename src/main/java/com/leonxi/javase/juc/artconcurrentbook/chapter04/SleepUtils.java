/**
 * Project Name:javase_review
 * File Name:SleepUtil.java
 * Package Name:com.leonxi.javase.juc.artconcurrentbook.chapter04
 * Date:2018年1月24日上午9:43:48
 * Copyright (c) 2018, 【Leon Xi】 All Rights Reserved.
 *
*/

package com.leonxi.javase.juc.artconcurrentbook.chapter04;
/**
 * ClassName:SleepUtil <br/>
 * Date:     2018年1月24日 上午9:43:48 <br/>
 * @author   Leon Xi
 * @version  v1.0
 * @see 	 
 */
import java.util.concurrent.TimeUnit;

/**
 * 4-4
 */
public class SleepUtils {
    public static final void second(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
        }
    }
}
