/**
 * Project Name:javase_review
 * File Name:Profiler.java
 * Package Name:com.leonxi.javase.juc.artconcurrentbook.chapter04
 * Date:2018年1月24日上午10:08:16
 * Copyright (c) 2018, 【Leon Xi】 All Rights Reserved.
 *
*/

package com.leonxi.javase.juc.artconcurrentbook.chapter04;
/**
 * ClassName:Profiler <br/>
 * Date:     2018年1月24日 上午10:08:16 <br/>
 * @author   Leon Xi
 * @version  v1.0
 * @see 	 
 */
import java.util.concurrent.TimeUnit;

/**
 * 4-15
 */
public class Profiler {
    // 第一次get()方法调用时会进行初始化（如果set方法没有调用），每个线程会调用一次
    private static final ThreadLocal<Long> TIME_THREADLOCAL = new ThreadLocal<Long>() {
                                                                protected Long initialValue() {
                                                                    return System.currentTimeMillis();
                                                                }
                                                            };

    public static final void begin() {
        TIME_THREADLOCAL.set(System.currentTimeMillis());
    }

    public static final long end() {
        return System.currentTimeMillis() - TIME_THREADLOCAL.get();
    }

    public static void main(String[] args) throws Exception {
        Profiler.begin();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Cost: " + Profiler.end() + " mills");
    }
}


