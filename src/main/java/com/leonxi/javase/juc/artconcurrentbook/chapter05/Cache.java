/**
 * Project Name:javase_review
 * File Name:Cache.java
 * Package Name:com.leonxi.javase.juc.artconcurrentbook.chapter05
 * Date:2018年1月24日上午10:56:05
 * Copyright (c) 2018, 【Leon Xi】 All Rights Reserved.
 *
*/

package com.leonxi.javase.juc.artconcurrentbook.chapter05;
/**
 * ClassName:Cache <br/>
 * Date:     2018年1月24日 上午10:56:05 <br/>
 * @author   Leon Xi
 * @version  v1.0
 * @see 	 
 */
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 10-16
 */
public class Cache {
    private static final Map<String, Object>    map = new HashMap<String, Object>();
    private static final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    private static final Lock                   r   = rwl.readLock();
    private static final Lock                   w   = rwl.writeLock();

    public static final Object get(String key) {
        r.lock();
        try {
            return map.get(key);
        } finally {
            r.unlock();
        }
    }

    public static final Object put(String key, Object value) {
        w.lock();
        try {
            return map.put(key, value);
        } finally {
            w.unlock();
        }
    }

    public static final void clear() {
        w.lock();
        try {
            map.clear();
        } finally {
            w.unlock();
        }
    }
}
