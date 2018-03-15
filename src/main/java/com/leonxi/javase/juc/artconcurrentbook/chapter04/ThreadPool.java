/**
 * Project Name:javase_review
 * File Name:ThreadPool.java
 * Package Name:com.leonxi.javase.juc.artconcurrentbook.chapter04
 * Date:2018年1月24日上午9:51:28
 * Copyright (c) 2018, 【Leon Xi】 All Rights Reserved.
 *
*/

package com.leonxi.javase.juc.artconcurrentbook.chapter04;
/**
 * ClassName:ThreadPool <br/>
 * Date:     2018年1月24日 上午9:51:28 <br/>
 * @author   Leon Xi
 * @version  v1.0
 * @see 	 
 */
/**
 * 6-19
 */
public interface ThreadPool<Job extends Runnable> {
    // 执行一个Job，这个Job需要实现Runnable
    void execute(Job job);

    // 关闭线程池
    void shutdown();

    // 增加工作者线程
    void addWorkers(int num);

    // 减少工作者线程
    void removeWorker(int num);

    // 得到正在等待执行的任务数量
    int getJobSize();
}

