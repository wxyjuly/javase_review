/**
 * Project Name:javase_review
 * File Name:MsgQueueManager.java
 * Package Name:com.leonxi.javase.juc.artconcurrentbook.chapter11
 * Date:2018年1月24日上午11:51:06
 * Copyright (c) 2018, 【Leon Xi】 All Rights Reserved.
 *
*/

package com.leonxi.javase.juc.artconcurrentbook.chapter11;
/**
 * ClassName:MsgQueueManager <br/>
 * Date:     2018年1月24日 上午11:51:06 <br/>
 * @author   Leon Xi
 * @version  v1.0
 * @see 	 
 */
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedTransferQueue;

/**
 * 总消息队列管理
 *
 * @author tengfei.fangtf
 */
public class MsgQueueManager implements IMsgQueue {

    /**
     * 消息总队列
     */
    public final BlockingQueue<Message> messageQueue;

    private MsgQueueManager() {
        messageQueue = new LinkedTransferQueue<Message>();
    }

    public void put(Message msg) {
        try {
            messageQueue.put(msg);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public Message take() {
        try {
            return messageQueue.take();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return null;
    }

}


