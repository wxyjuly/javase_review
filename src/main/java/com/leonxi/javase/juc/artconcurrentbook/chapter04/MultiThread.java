/**
 * Project Name:javase_review
 * File Name:MultiThread.java
 * Package Name:com.leonxi.javase.juc.artconcurrentbook.chapter04
 * Date:2018年1月24日上午10:03:07
 * Copyright (c) 2018, 【Leon Xi】 All Rights Reserved.
 *
*/

package com.leonxi.javase.juc.artconcurrentbook.chapter04;
/**
 * ClassName:MultiThread <br/>
 * Date:     2018年1月24日 上午10:03:07 <br/>
 * @author   Leon Xi
 * @version  v1.0
 * @see 	 
 */
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 *  6-1 
 *  Java默认多线程：
	[5] Attach Listener
	[4] Signal Dispatcher
	[3] Finalizer
	[2] Reference Handler
	[1] main
 */
public class MultiThread {

    public static void main(String[] args) {
        // 获取Java线程管理MXBean
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        // 不需要获取同步的monitor和synchronizer信息，仅仅获取线程和线程堆栈信息
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        // 遍历线程信息，仅打印线程ID和线程名称信息
        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println("[" + threadInfo.getThreadId() + "] " + threadInfo.getThreadName());
        }
    }
}

