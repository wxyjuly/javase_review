/**
 * Project Name:javase_review
 * File Name:LockUseCase.java
 * Package Name:com.leonxi.javase.juc.artconcurrentbook.chapter05
 * Date:2018年1月24日上午10:52:03
 * Copyright (c) 2018, 【Leon Xi】 All Rights Reserved.
 *
*/

package com.leonxi.javase.juc.artconcurrentbook.chapter05;
/**
 * ClassName:LockUseCase <br/>
 * Date:     2018年1月24日 上午10:52:03 <br/>
 * @author   Leon Xi
 * @version  v1.0
 * @see 	 
 */
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 10-1
 */
public class LockUseCase {
    public void lock() {
        Lock lock = new ReentrantLock();
        lock.lock();
        try {
        } finally {
            lock.unlock();
        }
    }
}

